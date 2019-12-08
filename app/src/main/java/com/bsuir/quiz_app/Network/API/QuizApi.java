package com.bsuir.quiz_app.Network.API;

import com.bsuir.quiz_app.Model.ApiResponse;
import com.bsuir.quiz_app.Model.Leader;
import com.bsuir.quiz_app.Model.Question;
import com.bsuir.quiz_app.Model.Result;
import com.bsuir.quiz_app.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface QuizApi {
    @GET("questions")
    Call<ApiResponse> getQuestions(@Query("amount") int amount,@Query("category") int catId);

    @GET("{userId}/history")
    Call<Leader []> getHistory(@Path("userId") String userId);

    @GET("leaderboard")
    Call<Leader []> getLeaders();

    @POST("result")
    Call<Result> postResult(@Body Result result);

    @POST("user")
    Call<User> getUserByName(@Query("name") String name);
}
