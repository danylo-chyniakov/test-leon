package com.parsing.leon;

import com.parsing.leon.service.LeonService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LeonApplicationRunner implements ApplicationRunner {
    LeonService leonService;

    public LeonApplicationRunner(LeonService leonService) {
        this.leonService = leonService;
    }

    @Override
    public void run(ApplicationArguments args) {
        leonService.printAllFirstMatchesOfTopLeaguesWithMarkets();
    }
}