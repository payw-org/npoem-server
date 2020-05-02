package org.payw.npoem.service.user;

import java.util.UUID;

import org.payw.npoem.config.security.JwtTokenProvider;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    public User createUser(UserSaveRequestDto requestDto) {
        UUID uuid = UUID.randomUUID();

        User user = User.builder()
                .nickname(uuid.toString())
                .build();

        userRepository.save(user);
        
        return user;
    }
}
