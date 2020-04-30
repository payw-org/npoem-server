package org.payw.npoem.service.user;

import java.util.UUID;

import org.payw.npoem.config.security.JwtTokenProvider;
import org.payw.npoem.domain.user.User;
import org.payw.npoem.domain.user.UserRepository;
import org.payw.npoem.resolver.user.dto.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserService {

	private final JwtTokenProvider jwtTokenProvider;

    public String createUser(UserSaveRequestDto requestDto) {
    	UUID uuid = UUID.randomUUID();

        User user = User.builder()
        		.nickname(uuid.toString())
                .build();
        
        return jwtTokenProvider.createToken(user.getNickname());
    }
}
