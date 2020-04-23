package org.payw.npoem.service.entry;


import org.payw.npoem.domain.entry.Poem;
import org.payw.npoem.domain.entry.PoemRepository;
import org.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;

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

    public Long writePoem(PoemSaveRequestDto requestDto) {
        return poemRepository.save(requestDto.toEntity()).getId();
    }
}
