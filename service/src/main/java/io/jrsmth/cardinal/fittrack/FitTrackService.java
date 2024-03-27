package io.jrsmth.cardinal.fittrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FitTrackService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FitTrackService.class, args);
    }

}
