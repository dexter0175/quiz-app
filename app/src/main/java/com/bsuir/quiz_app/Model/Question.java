package com.bsuir.quiz_app.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question  implements Parcelable {
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("correct_answer")
    @Expose
    private String correct_answer;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("incorrect_answers")
    @Expose
    private String[] incorrect_answers;
    @SerializedName("type")
    @Expose
    private String type;

    public Question(String question, String category, String correct_answer, String difficulty, String[] incorrect_answers, String type) {
        this.question = question;
        this.category = category;
        this.correct_answer = correct_answer;
        this.difficulty = difficulty;
        this.incorrect_answers = incorrect_answers;
        this.type = type;
    }

    protected Question(Parcel in) {
        question = in.readString();
        category = in.readString();
        correct_answer = in.readString();
        difficulty = in.readString();
        incorrect_answers = in.createStringArray();
        type = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(String[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(question);
        dest.writeString(category);
        dest.writeString(correct_answer);
        dest.writeString(difficulty);
        dest.writeStringArray(incorrect_answers);
        dest.writeString(type);
    }
}