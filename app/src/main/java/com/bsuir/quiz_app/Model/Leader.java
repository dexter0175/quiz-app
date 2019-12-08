package com.bsuir.quiz_app.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leader {
    @SerializedName("_id")
    @Expose
    private String userId;
    private int totalScore;
    private int games;

    public Leader(String userId, int totalScore, int games) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.games = games;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
