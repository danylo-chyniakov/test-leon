package com.parsing.leon.service;

import com.parsing.leon.client.LeonFeignClient;
import com.parsing.leon.model.EventResponse;
import com.parsing.leon.model.League;
import com.parsing.leon.model.Match;
import com.parsing.leon.model.Sport;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class LeonService {
    LeonFeignClient client;
    ExecutorService executorService;

    public LeonService(@Value("${executor.pool.size}") int poolSize, LeonFeignClient client) {
        this.client = client;
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void printAllFirstMatchesOfTopLeaguesWithMarkets() {
        List<Sport> sportList = client.getAllSportsWithLeagues();

        List<String> topLeaguesIds = getTopLeaguesIDs(sportList);

        List<Future<String>> futures = topLeaguesIds.stream()
                .map(topLeagueId -> executorService.submit(() -> processTopLeague(topLeagueId)))
                .toList();

        futures.forEach(future -> {
            try {
                String dataAboutMatch = future.get();
                System.out.println(dataAboutMatch);
                System.out.println("\n\n\n");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    private static List<String> getTopLeaguesIDs(List<Sport> sportList) {
        return sportList.stream()
                .flatMap(sport -> sport.getRegions().stream())
                .flatMap(region -> region.getLeagues().stream())
                .filter(League::getTop)
                .map(League::getId)
                .toList();
    }

    @SneakyThrows
    private String processTopLeague(String topLeagueId) {
        EventResponse allMatchesOfLeague = client.getAllMatchesOfLeague(topLeagueId);
        Match infoAboutMatch = client.getInfoAboutMatch(allMatchesOfLeague.getEvents().getFirst().getId());
        return infoAboutMatch.toString();
    }
}
