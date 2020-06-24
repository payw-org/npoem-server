package org.payw.npoem.service.user;

import java.util.List;
import java.util.Optional;

import org.payw.npoem.domain.user.User;
import org.payw.npoem.domain.user.UserRepository;
import org.payw.npoem.resolver.user.dto.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User createUser(UserSaveRequestDto requestDto) {
        User user = User.builder()
                .nickname(requestDto.getNickname())
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
}
