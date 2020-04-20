package com.payw.npoem.service.entry;

import com.payw.npoem.domain.entry.Poem;
import com.payw.npoem.domain.entry.PoemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PoemService {

    private final PoemRepository poemRepository;

    public List<Poem> findAllPoems() {
        return poemRepository.findAll();
    }

}
