package com.jrsmth.cardinal.fittrack;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public JsonParser jsonParser() {
        return JsonParserFactory.getJsonParser();
    }
}
