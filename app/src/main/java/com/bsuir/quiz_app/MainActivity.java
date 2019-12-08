package com.bsuir.quiz_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bsuir.quiz_app.Model.Category;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Select a category..");
        setSupportActionBar(toolbar);

    }


    public void onCategorySelected(View v) {
        int ID = v.getId();
        Intent intent = new Intent(MainActivity.this, GameActivity.class);


        switch (ID) {
            case R.id.COMPUTER_BTN:
                intent.putExtra("CATEGORY", Category.COMPUTER.name());
                break;
            case R.id.MUSIC_BTN:
                intent.putExtra("CATEGORY", Category.MUSIC.name());
                break;
            case R.id.FILMS_BTN:
                intent.putExtra("CATEGORY", Category.FILMS.name());
                break;
            case R.id.TELEVISION_BTN:
                intent.putExtra("CATEGORY", Category.TELEVISION.name());
                break;
            case R.id.GAMES_BTN:
                intent.putExtra("CATEGORY", Category.GAMES.name());
                break;
            case R.id.BOOKS_BTN:
                intent.putExtra("CATEGORY", Category.BOOKS.name());
                break;
            case R.id.GENERAL_BTN:
                intent.putExtra("CATEGORY", Category.GENERAL.name());
                break;
            case R.id.MATHEMATICS_BTN:
                intent.putExtra("CATEGORY", Category.MATHEMATICS.name());
                break;
            case R.id.SPORTS:
                intent.putExtra("CATEGORY", Category.SPORTS.name());
                break;
            case R.id.ART:
                intent.putExtra("CATEGORY", Category.ART.name());
                break;
            case R.id.ANIMALS_BTN:
                intent.putExtra("CATEGORY", Category.ANIMALS.name());
                break;
            case R.id.POLITICS_BTN:
                intent.putExtra("CATEGORY", Category.POLITICS.name());
                break;
            case R.id.ANIME:
                intent.putExtra("CATEGORY", Category.ANIME.name());
                break;

        }
        intent.setFlags(FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ldrboardItem:
                Intent intent1 = new Intent(MainActivity.this, LeaderboardActivity.class);
                startActivity(intent1);
                break;
            case R.id.logoutItem:
                SharedPreferences preferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                preferences.edit().remove("UserId").commit();
                Intent intent2 = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
        return true;
    }
}
