package com.jrsmth.cardinal.fittrack.bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrsmth.cardinal.fittrack.week.Week;
import com.jrsmth.cardinal.fittrack.week.WeekRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("local")
@RequiredArgsConstructor @Slf4j
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final WeekRepository weekRepository;
    private final ObjectMapper mapper;
    private final JsonParser parser;

    @Override @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            weekRepository.saveAll(getWeeks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Bootstrapping Data after event trigger: " + event);
    }

    private List<Week> getWeeks() throws IOException {
        byte[] file = Files.readAllBytes(Paths.get("src/main/resources/weeks.json"));
        var unconvertedWeeks = parser.parseList(new String(file));
        List<Week> weeks = new ArrayList<>();

        for (Object week : unconvertedWeeks) {
            log.info("[getWeeks] Converting week {}", week);
            weeks.add(mapper.convertValue(week, Week.class));
        }

        log.info("[getWeeks] Retrieving {} weeks from JSON file", weeks.size());
        return weeks;
    }

}
