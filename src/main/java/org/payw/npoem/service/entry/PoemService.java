package org.payw.npoem.service.entry;


import org.payw.npoem.domain.entry.Poem;
import org.payw.npoem.domain.entry.PoemRepository;
import org.payw.npoem.domain.entry.Word;
import org.payw.npoem.domain.entry.WordRepository;
import org.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PoemService {

    private final PoemRepository poemRepository;
    private final WordRepository wordRepository;

    public List<Poem> findAllPoems() {
        return poemRepository.findAll();
    }

    public Long writePoem(PoemSaveRequestDto requestDto) {
        Word word = wordRepository.findById(requestDto.getWord_id())
                .orElseThrow(EntityNotFoundException::new);

        Poem poem = Poem.builder().content(requestDto.getContent())
                .spentTime(requestDto.getSpentTime())
                .word(word)
                .build();
        return poemRepository.save(poem).getId();
    }
}