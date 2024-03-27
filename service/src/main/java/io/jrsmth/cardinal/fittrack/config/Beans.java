package io.jrsmth.cardinal.fittrack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

@Configuration
public class Beans {
    @Bean
    public JsonParser jsonParser() {
        return JsonParserFactory.getJsonParser();
    }

}
