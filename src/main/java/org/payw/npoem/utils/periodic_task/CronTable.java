package org.payw.npoem.utils.periodic_task;

import lombok.RequiredArgsConstructor;
import org.payw.npoem.domain.entry.TodayWord;
import org.payw.npoem.domain.entry.TodayWordRepository;
import org.payw.npoem.domain.entry.Word;
import org.payw.npoem.domain.entry.WordRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CronTable {

    private final WordRepository wordRepository;
    private final TodayWordRepository todayWordRepository;

    @Scheduled(cron = "01 00 00 * * *")
    public void updateTodayWord() {
        Word word = wordRepository.findRandomWord();
        TodayWord todayWord = new TodayWord(word.getText());
        todayWordRepository.save(todayWord);
    }
}
