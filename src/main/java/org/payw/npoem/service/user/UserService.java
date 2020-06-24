package org.payw.npoem.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.payw.npoem.domain.entry.Poem;
import org.payw.npoem.domain.entry.PoemRepository;
import org.payw.npoem.domain.user.User;
import org.payw.npoem.domain.user.UserRepository;
import org.payw.npoem.resolver.user.dto.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PoemRepository poemRepository;

    public User createUser(UserSaveRequestDto requestDto) {
        UUID uuid = UUID.randomUUID();

        User user = User.builder()
                .nickname(uuid.toString())
                .build();

        userRepository.save(user);
        
        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // TODO return userRepository.findByUsername result
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    public Optional<User> loadUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    };

    public String updateNickname(User user, String nickname) {
        user.setNickname(nickname);
        userRepository.save(user);
        return user.getNickname();
    }

    public Boolean isPlayedToday() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LocalDateTime now = LocalDateTime.now();

        Poem poem =  poemRepository.findByUserIdAndCreatedBetween(
                user.getId(),
                LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0) ,
                now
        ).orElse(null);

        return poem != null;
    }
}
