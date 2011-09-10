package biz.neustar.leftronic.util;

import java.util.List;

public class Leaderboard {
    private List<LeaderboardEntry> leaderboard;

    public Leaderboard(List<LeaderboardEntry> leaderboard) {
        this.leaderboard = leaderboard;
    }

    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboard;
    }
}
