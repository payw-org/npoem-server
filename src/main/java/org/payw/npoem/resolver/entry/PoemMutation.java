package org.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;
import org.payw.npoem.service.entry.PoemService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PoemMutation implements GraphQLMutationResolver {
    private final PoemService poemService;

    public Long writePoem(PoemSaveRequestDto requestDto) {
        return poemService.writePoem(requestDto);
    }
}
