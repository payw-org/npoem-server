package org.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.payw.npoem.resolver.entry.dto.WordSaveRequestDto;
import org.payw.npoem.service.entry.WordService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WordMutation implements GraphQLMutationResolver {
    private final WordService wordService;

    public Long registerWord(WordSaveRequestDto requestDto) { return wordService.registerWord(requestDto); }
}
