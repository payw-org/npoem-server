package org.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

import org.payw.npoem.domain.entry.TodayWord;
import org.payw.npoem.service.entry.WordService;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TodayWordQuery implements GraphQLQueryResolver {

    private final WordService wordService;

    TodayWord todayWord() {
        return wordService.todayWord();
    }

}
