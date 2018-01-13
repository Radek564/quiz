package com.sd.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private Button exitBtn;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mp.setLooping(true);
        mp.start();

        startBtn = (Button) findViewById(R.id.start);
        exitBtn = (Button) findViewById(R.id.exit);

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    public void onDestroy(){
        super.onDestroy();
        mp.release();
    }
}
