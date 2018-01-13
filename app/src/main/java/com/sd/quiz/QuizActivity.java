package com.sd.quiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends Activity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView highScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonQuit;

    private Vibrator vibrator;

    private MediaPlayer mp2;

    Random rnd = new Random();

    public String highScoreKeyString = "highScore";
    private String mAnswer;
    private int mScore = 0;
    private int highScore = 0;
    private int mQuestionNumber = 0;
    private int mAnsweredQuestions = 0;
    private int index = QuestionLibrary.mQuestions.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        mScoreView = (TextView) findViewById(R.id.score_text);
        highScoreView = (TextView) findViewById(R.id.highscore);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mButtonQuit = (Button) findViewById(R.id.quit);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        updateQuestion();
        loadPref();

        highScoreView.setText("Najlepszy wynik: " + highScore);

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);

                if (mButtonChoice1.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    mButtonChoice1.setBackgroundColor(Color.GREEN);
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                    mp2.start();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
                            mp2.release();
                            updateQuestion();
                        }
                    }, 3000);

                } else {
                    mButtonChoice1.setBackgroundColor(Color.RED);
                    if (mButtonChoice2.getText() == mAnswer) {
                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                        }
                    if (mButtonChoice3.getText() == mAnswer) {
                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice4.getText() == mAnswer) {
                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
                    mp2.start();
                    vibrator.vibrate(900);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mp2.release();
                            finish();
                        }
                    }, 3000);
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);

                if (mButtonChoice2.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    mButtonChoice2.setBackgroundColor(Color.GREEN);
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                    mp2.start();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
                            mp2.release();
                            updateQuestion();
                        }
                    }, 3000);

                } else {
                    mButtonChoice2.setBackgroundColor(Color.RED);
                    if (mButtonChoice1.getText() == mAnswer) {
                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice3.getText() == mAnswer) {
                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice4.getText() == mAnswer) {
                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
                    mp2.start();
                    vibrator.vibrate(900);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mp2.release();
                            finish();
                        }
                    }, 3000);
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);

                if (mButtonChoice3.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    mButtonChoice3.setBackgroundColor(Color.GREEN);
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                    mp2.start();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
                            mp2.release();
                            updateQuestion();
                        }
                    }, 3000);

                } else {
                    mButtonChoice3.setBackgroundColor(Color.RED);
                    if (mButtonChoice1.getText() == mAnswer) {
                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice2.getText() == mAnswer) {
                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice4.getText() == mAnswer) {
                        mButtonChoice4.setBackgroundColor(Color.GREEN);
                    }
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
                    mp2.start();
                    vibrator.vibrate(900);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mp2.release();
                            finish();
                        }
                    }, 3000);
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);

                if (mButtonChoice4.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    mButtonChoice4.setBackgroundColor(Color.GREEN);
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.correct);
                    mp2.start();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mButtonChoice4.setBackgroundColor(Color.parseColor("#0091EA"));
                            mp2.release();
                            updateQuestion();
                        }
                    }, 3000);

                } else {
                    mButtonChoice4.setBackgroundColor(Color.RED);
                    if (mButtonChoice1.getText() == mAnswer) {
                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice2.getText() == mAnswer) {
                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                    }
                    if (mButtonChoice3.getText() == mAnswer) {
                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                    }
                    mp2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
                    mp2.start();
                    vibrator.vibrate(900);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mButtonChoice1.setEnabled(true);
                            mButtonChoice2.setEnabled(true);
                            mButtonChoice3.setEnabled(true);
                            mButtonChoice4.setEnabled(true);
                            mp2.release();
                            finish();
                        }
                    }, 3000);
                }
            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    private void updateQuestion(){

        if(mQuestionNumber>=index){
            mQuestionNumber = 0;
        }

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            // mQuestionNumber = rnd.nextInt(index);
            mQuestionNumber += 1;
            mAnsweredQuestions += 1;
    }

    private void updateScore(int point){
        mScoreView.setText("Wynik: " + mScore);
        if (mScore > highScore) {
            highScore = mScore;
            highScoreView.setText("Najlepszy wynik: " + highScore);
            savePref(highScoreKeyString, highScore);
        }
    }

    public void loadPref() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        int highScoreKey = sharedPref.getInt(highScoreKeyString, 0);
            highScore = highScoreKey;
    }

    public void savePref(String key, int value) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}
