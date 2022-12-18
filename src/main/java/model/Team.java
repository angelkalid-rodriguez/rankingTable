package model;

public class Team {

    private String name;
    private int score;
    private int totalPoints;

    public Team() {
    }

    /**
     * Constructor
     *
     * @param name
     * @param score
     * @param totalPoints
     */
    public Team(String name, int score, int totalPoints) {
        this.name = name;
        this.score = score;
        this.totalPoints = totalPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

}
