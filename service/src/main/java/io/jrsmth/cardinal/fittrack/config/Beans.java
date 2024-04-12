package io.jrsmth.cardinal.fittrack.config;

import io.jrsmth.cardinal.common.util.security.TokenFilter;
import io.jrsmth.cardinal.common.util.security.TokenManager;
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

    @Bean
    public TokenManager tokenManager() {
        return new TokenManager();
    }

    @Bean
    public TokenFilter tokenFilter(TokenManager manager) {
        return new TokenFilter(manager);
    }

}
