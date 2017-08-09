package com.sourabhkulkarni.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startbutton;
    Button playagain;
    TextView tv;
    TextView PointsTextView;
    TextView sumtextView;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    TextView ttv;
    RelativeLayout gameRL;

    ArrayList<Integer> answers=new ArrayList<Integer>();
    int Locationofcorrectanswers;
    int score=0;
     TextView pointsTextView;

    int numberOfQuestions=0;
    public void playagain(View view){

        score=0;
        numberOfQuestions=0;
        ttv.setText("30s");
        PointsTextView.setText("0/0");
        tv.setText("");
        GenerateQuestion();
        playagain.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                ttv.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                ttv.setText("0s");
                tv.setText("Your score:"+ Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));


            }


        }.start();





    }


    public void GenerateQuestion(){
        Random rand=new Random();
        int a=rand.nextInt(20);
        int b=rand.nextInt(20);

        sumtextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        Locationofcorrectanswers=rand.nextInt(4);
        answers.clear();

        int inCorrect;

        for(int i=0;i<4;i++){

            if(i==Locationofcorrectanswers){
                answers.add(a+b);

            }else {
                inCorrect=rand.nextInt(41);
                while (inCorrect==a+b){
                    inCorrect=rand.nextInt(41);
                }

                answers.add(inCorrect);
            }
            // answers.add(inCorrect);
            //answers.clear();

        }
        b1.setText(Integer.toString(answers.get(0)));
        b2.setText(Integer.toString(answers.get(1)));
        b3.setText(Integer.toString(answers.get(2)));
        b4.setText(Integer.toString(answers.get(3)));



    }
    public void start(View view){
        startbutton.setVisibility(View.INVISIBLE);
        gameRL.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.Playagain));


    }

    public void chooseAns(View view){

        Log.i("Tag", (String) view.getTag());
        if(view.getTag().toString().equals(Integer.toString(Locationofcorrectanswers))){

            Log.i("correct", "correct");
            score++;
            tv=(TextView)findViewById(R.id.textView4);
            tv.setText("correct");

        }else {
            tv=(TextView)findViewById(R.id.textView4);
            tv.setText("wrong");

        }
        numberOfQuestions++;
        PointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        GenerateQuestion();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbutton = (Button) findViewById(R.id.button);
        sumtextView = (TextView) findViewById(R.id.SumtextView3);
        PointsTextView = (TextView) findViewById(R.id.textView2);
        ttv=(TextView)findViewById(R.id.textView) ;
        tv=(TextView)findViewById(R.id.textView4);
        gameRL=(RelativeLayout)findViewById(R.id.gameRL);

        b1 = (Button) findViewById((R.id.button1));
        b2 = (Button) findViewById((R.id.button2));
        b3 = (Button) findViewById((R.id.button3));
        b4 = (Button) findViewById((R.id.button4));
        playagain=(Button)findViewById(R.id.Playagain);
       // GenerateQuestion();
        playagain(findViewById(R.id.Playagain));


    }
}