package com.bsuir.quiz_app.Model;

public class Result {
    private String userId;
    private int     categoryId;
    private int     correct;
    private int     total;
    private float   score;

    public Result(String userId, int categoryId, int correct, int total) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.correct = correct;
        this.total = total;
        this.score = correct/total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
