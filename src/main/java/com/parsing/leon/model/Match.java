package com.parsing.leon.model;

import lombok.Data;

import java.util.List;

import static com.parsing.leon.utils.DateTimeUtils.getKickOffAsUTC;

@Data
public class Match {
    private String id;
    private String name;
    private String kickoff;
    private LeagueOfMatch league;
    private List<Market> markets;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // League
        sb.append(league.getSport().getName()).append(", ").append(league.getName()).append("\n");

        // Match
        sb.append("\t");
        sb.append(name).append(" , ").append(getKickOffAsUTC(kickoff)).append(" , ").append(id).append("\n");

        for (Market market : markets) {
            // Market
            sb.append("\t\t");
            sb.append(market.getName()).append("\n");

            // Runners
            for (Runners runner : market.getRunners()) {
                sb.append("\t\t\t");
                sb.append(runner.getName()).append(", ").append(runner.getPrice()).append(", ").append(runner.getId()).append("\n");
            }
        }

        return sb.toString();
    }


}
