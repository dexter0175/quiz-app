package com.bsuir.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.bsuir.quiz_app.Model.Leader;
import com.bsuir.quiz_app.Model.Result;
import com.bsuir.quiz_app.Network.NetworkService;
import com.bsuir.quiz_app.UI.LeaderboardAdapter;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderboardActivity extends AppCompatActivity  {

    private RecyclerView rvLeader;
    private String userId;
    private ProgressDialog dialog;
    private LeaderboardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Leaderboard");
        setSupportActionBar(toolbar);

        this.userId = getSharedPreferences("UserInfo", Context.MODE_PRIVATE).getString("UserId","<undefined>");

        this.rvLeader = findViewById(R.id.recyclerView);
        rvLeader.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new LeaderboardAdapter();
        rvLeader.setAdapter(adapter);

        this.dialog = new ProgressDialog(LeaderboardActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading");
        dialog.setMessage("Retrieving leaderboard");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        NetworkService.getInstance()
                .getJSONApi()
                .getLeaders()
                .enqueue(new Callback<Leader[]>() {
                    @Override
                    public void onResponse(@NotNull Call<Leader[]> call, @NotNull Response<Leader[]> response) {
                        adapter.setItems(response.body());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();

                    }

                    @Override
                    public void onFailure(@NotNull Call<Leader[]> call, @NotNull Throwable t) {

                        t.printStackTrace();
                        dialog.dismiss();
                    }
                });

    }
}
