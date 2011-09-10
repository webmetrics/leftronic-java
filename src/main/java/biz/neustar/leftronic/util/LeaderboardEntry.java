package biz.neustar.leftronic.util;

public class LeaderboardEntry {
    private String name;
    private int value;

    public LeaderboardEntry(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
