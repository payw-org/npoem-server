package org.payw.npoem.service.entry;

import lombok.RequiredArgsConstructor;
import org.payw.npoem.domain.entry.TodayWord;
import org.payw.npoem.domain.entry.TodayWordRepository;
import org.payw.npoem.domain.entry.Word;
import org.payw.npoem.domain.entry.WordRepository;
import org.payw.npoem.resolver.entry.dto.WordSaveRequestDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordService {

    private final WordRepository wordRepository;
    private final TodayWordRepository todayWordRepository;

    public Long registerWord(WordSaveRequestDto requestDto) {
        return wordRepository.save(Word.builder().text(requestDto.getText()).build()).getId();
    }

    public TodayWord todayWord() {
        return todayWordRepository.findFirstByOrderByIdDesc();
    }
}
