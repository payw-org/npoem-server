package org.payw.npoem.resolver.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

import org.payw.npoem.domain.user.User;
import org.payw.npoem.service.user.UserService;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserQuery implements GraphQLQueryResolver {
    private final UserService userService;

    public List<User> users() {
        return userService.findAllUsers();
    }

    public Optional<User> user(String nickname) {
        return userService.loadUserByNickname(nickname);
    }
}
