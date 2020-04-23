package com.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.payw.npoem.domain.entry.Poem;
import com.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;
import com.payw.npoem.service.entry.PoemService;
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
