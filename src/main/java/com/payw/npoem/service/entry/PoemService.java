package com.payw.npoem.service.entry;

import com.payw.npoem.domain.entry.Poem;
import com.payw.npoem.domain.entry.PoemRepository;
import com.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;
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
