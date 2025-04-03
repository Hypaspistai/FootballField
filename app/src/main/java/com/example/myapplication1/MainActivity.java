package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEAM1_SCORE_KEY = "team1Score";
    private static final String TEAM2_SCORE_KEY = "team2Score";

    private int team1Score = 0;
    private int team2Score = 0;
    private TextView team1ScoreView;
    private TextView team2ScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Сохранение значений счётчика при смене ориентации
        if (savedInstanceState != null) {
            team1Score = savedInstanceState.getInt(TEAM1_SCORE_KEY);
            team2Score = savedInstanceState.getInt(TEAM2_SCORE_KEY);
        }

        // Инициализация элементов интерфейса
        team1ScoreView = findViewById(R.id.team1_score);
        team2ScoreView = findViewById(R.id.team2_score);
        Button team1Button = findViewById(R.id.team1_button);
        Button team2Button = findViewById(R.id.team2_button);

        // Обновление результатов счётчика
        updateScores();

        // Эффекты нажатия кнопок
        team1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1Score++;
                updateScores();
            }
        });

        team2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team2Score++;
                updateScores();
            }
        });
    }

    // Сохранение положения при смене ориентации
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEAM1_SCORE_KEY, team1Score);
        outState.putInt(TEAM2_SCORE_KEY, team2Score);
    }

    private void updateScores() {
        team1ScoreView.setText(String.valueOf(team1Score));
        team2ScoreView.setText(String.valueOf(team2Score));
    }
}