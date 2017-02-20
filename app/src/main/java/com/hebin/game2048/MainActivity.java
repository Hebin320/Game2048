package com.hebin.game2048;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Game2048Layout.OnGame2048Listener {

    TextView idScore;
    Game2048Layout idGame2048;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idScore = (TextView) findViewById(R.id.id_score);
        idGame2048 = (Game2048Layout) findViewById(R.id.id_game2048);
        idGame2048.setOnGame2048Listener(this);
    }

    @Override
    public void onScoreChange(int score) {
        idScore.setText("SCORE: " + score);
    }

    @Override
    public void onGameOver() {
        new AlertDialog.Builder(this).setTitle("GAME OVER")
                .setMessage("YOU HAVE GOT " + idScore.getText())
                .setPositiveButton("RESTART", (dialog, which) -> idGame2048.restart()).setNegativeButton("EXIT", (dialog, which) -> finish()).show();
    }
}
