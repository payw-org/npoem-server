package com.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.payw.npoem.domain.entry.Poem;
import com.payw.npoem.domain.entry.PoemRepository;
import com.payw.npoem.service.entry.PoemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PoemQuery implements GraphQLQueryResolver {
    private final PoemService poemService;

    public List<Poem> poems() {
        return poemService.findAllPoems();
    }
}
