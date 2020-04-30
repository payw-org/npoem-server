package org.payw.npoem.resolver.user;

import org.payw.npoem.service.user.UserService;
import org.payw.npoem.resolver.user.dto.UserSaveRequestDto;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMutation implements GraphQLMutationResolver {
    private final UserService userService;

    public String createUser(UserSaveRequestDto requestDto) {
        return userService.createUser(requestDto);
    }
}
