package com.bsuir.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bsuir.quiz_app.Model.Category;
import com.bsuir.quiz_app.Model.Result;
import com.bsuir.quiz_app.Model.User;
import com.bsuir.quiz_app.Network.NetworkService;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private int total;
    private int correct;
    private String userId;
    private int categoryId;
    private ProgressDialog dialog;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
         this.correct = getIntent().getIntExtra("correctAnswers",0);
         this.total = getIntent().getIntExtra("questions",0);
         this.userId = getSharedPreferences("UserInfo", Context.MODE_PRIVATE).getString("UserId","<undefined>");
         this.categoryId = Category.valueOf(getIntent().getStringExtra("category") ).id;

        TextView  tvScore = findViewById(R.id.score);
        tvScore.setText(String.format("%d/%d", correct, total));

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        this.dialog = new ProgressDialog(ResultActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading");
        dialog.setMessage("Saving results");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
        NetworkService.getInstance()
                .getJSONApi()
                .postResult(new Result(userId,categoryId,correct,total))
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(@NotNull Call<Result> call, @NotNull Response<Result> response) {

                        dialog.dismiss();

                    }

                    @Override
                    public void onFailure(@NotNull Call<Result> call, @NotNull Throwable t) {

                        t.printStackTrace();
                        dialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
