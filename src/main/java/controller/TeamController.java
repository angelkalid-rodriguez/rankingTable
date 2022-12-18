package controller;

import model.Team;
import view.RankingTableView;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TeamController {

    private RankingTableView rankingTableView;

    /**
     * Constructor
     */
    public TeamController() {
    }

    /**
     * Constructor
     *
     * @param rankingTableView
     */
    public TeamController(RankingTableView rankingTableView) {
        this.rankingTableView = rankingTableView;
        this.rankingTableView.setController(this);
    }

    /**
     * Data coming from an Array, it calculates the ranking
     *
     * @param arrMatches
     * @return
     */
    public List<String> calculateRankingTable(String[] arrMatches) {

        HashMap<String, Integer> finalRanking = new HashMap<String, Integer>();

        for (String row : arrMatches) {

            String[] match = row.split(",");

            String FirstTeamName = match[0].replaceAll("[^A-Za-z]", " ").trim();
            int FirstTeamScore = Integer.parseInt(match[0].replaceAll("[^0-9]", ""));

            String secondTeamName = match[1].replaceAll("[^A-Za-z]", " ").trim();
            int secondTeamScore = Integer.parseInt(match[1].replaceAll("[^0-9]", ""));

            Team t1 = new Team(FirstTeamName, FirstTeamScore, 0);
            Team t2 = new Team(secondTeamName, secondTeamScore, 0);

            //Validate if a team exist in the ranking table
            if (!finalRanking.containsKey(t1.getName())) {
                finalRanking.put(t1.getName(), t1.getTotalPoints());
            } if(!finalRanking.containsKey(t2.getName())) {
                finalRanking.put(t2.getName(), t2.getTotalPoints());
            }

            //Set the points of each match (Tie is worth 1 pt, win is worth 3 pts and a loss is worth 0 pts)
            if (t1.getScore() > t2.getScore()) {
                //Team 1 is the winner
                finalRanking.put(t1.getName(), finalRanking.getOrDefault(t1.getName(), t1.getTotalPoints()) + 3);

            } else if (t1.getScore() < t2.getScore()){
                //Team 2 is the winner
                finalRanking.put(t2.getName(), finalRanking.getOrDefault(t2.getName(), t2.getTotalPoints()) + 3);

            // A draw is worth 1 pt
            } else if (t1.getScore() == t2.getScore()) {
                finalRanking.put(t1.getName(), finalRanking.getOrDefault(t1.getName(), t1.getTotalPoints()) + 1);
                finalRanking.put(t2.getName(), finalRanking.getOrDefault(t2.getName(), t2.getTotalPoints()) + 1);
            }
        }

        //Sort the Hashmap by value (Points)
        HashMap<String, Integer> temp
                = finalRanking.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        AtomicInteger currentCounter = new AtomicInteger();
        AtomicInteger generalCounter = new AtomicInteger();
        AtomicInteger tieCounter = new AtomicInteger();

        //Sort the Hashmap by Key Alphabetically
        return temp.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Integer>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .map(it -> {
                    generalCounter.getAndIncrement();
                    if (it.getValue() == 0 || it.getValue() > 1) {
                        currentCounter.set(generalCounter.get());
                        return currentCounter.getAndIncrement() + ". " + it.getKey() + ", " + it.getValue() + " pts";
                    } else {
                        tieCounter.set(currentCounter.get());
                        return tieCounter.get() + ". " + it.getKey() + ", " + it.getValue() + " pt";
                    }
                })
                .collect(Collectors.toList());
    }
}
