package com.parsing.leon.client;

import com.parsing.leon.model.EventResponse;
import com.parsing.leon.model.Match;
import com.parsing.leon.model.Sport;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "leonClient", url = "${leon.feign.client.url}")
public interface LeonFeignClient {

    @RequestMapping(method = RequestMethod.GET,value =  "${leon.feign.client.sports.endpoint}")
    @Headers({
            "authority: leonbets.com",
            "accept: */*",
            "accept-language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
            "referer: https://leonbets.com/registration",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36",
            "x-app-browser: chrome",
            "x-app-env: prod",
            "x-app-language: en_US",
            "x-app-layout: desktop",
            "x-app-modernity: modern",
            "x-app-os: windows",
            "x-app-platform: web",
            "x-app-referrer: https://leonbets.com/ru-ua/registration",
            "x-requested-uri: /registration"
    })
    List<Sport> getAllSportsWithLeagues();

    @RequestMapping(method = RequestMethod.GET,value = "${leon.feign.client.events.endpoint}")
    @Headers({
            "authority: leonbets.com",
            "accept: */*",
            "accept-language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
            "referer: https://leonbets.com/bets/soccer/england/1970324836975359-premier-league",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36",
            "x-app-browser: chrome",
            "x-app-env: prod",
            "x-app-language: en_US",
            "x-app-layout: desktop",
            "x-app-modernity: modern",
            "x-app-os: windows",
            "x-app-platform: web",
            "x-app-referrer: https://leonbets.com/ru-ua/registration",
            "x-app-rendering: csr",
            "x-app-skin: default",
            "x-app-version: 6.80.4",
            "x-requested-uri: /registration"
    })
    EventResponse getAllMatchesOfLeague(@PathVariable("leagueID") String leagueID);

    @RequestMapping(method = RequestMethod.GET,value = "${leon.feign.client.match.endpoint}")
    @Headers({
            "authority: leonbets.com",
            "accept: */*",
            "accept-language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
            "referer: https://leonbets.com/bets/soccer/england/premier-league/1970324843317652-brentford-manchester-city",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36",
            "x-app-browser: chrome",
            "x-app-env: prod",
            "x-app-language: en_US",
            "x-app-layout: desktop",
            "x-app-modernity: modern",
            "x-app-os: windows",
            "x-app-platform: web",
            "x-app-referrer: https://leonbets.com/ru-ua/registration",
            "x-app-rendering: csr",
            "x-app-skin: default",
            "x-app-version: 6.80.4",
            "x-requested-uri: /registration"
    })
    Match getInfoAboutMatch(@PathVariable("matchID") String matchID);
}