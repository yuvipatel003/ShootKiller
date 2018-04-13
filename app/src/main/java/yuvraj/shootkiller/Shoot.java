package yuvraj.shootkiller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Shoot extends AppCompatActivity {

    ProgressBar mProgress;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, play;
    TextView scoretable, highscore, misstable,percentage,health,miss_title,score_title,highscore_title;
    int score = 0, miss,turn,scorei=0,leave,progress,end=0,hscore,mode=0;
    SharedPreferences sharedpreferences;
 //   private MalibuCountDownTimer countDownTimer;
    long startTime,interval,leveltime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoot);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);

        health = (TextView) findViewById(R.id.health);
        highscore_title = (TextView) findViewById(R.id.highscore_title);
        score_title = (TextView) findViewById(R.id.score_title);
        miss_title = (TextView) findViewById(R.id.miss_title);


        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        try {
            hscore = prefs.getInt("high", 0);

        } catch (NumberFormatException e) {
            hscore = 0;
        }
        highscore = (TextView) findViewById(R.id.highscore);
        highscore.setText(String.valueOf(hscore));

        percentage = (TextView) findViewById(R.id.percentage);
        scoretable = (TextView) findViewById(R.id.score);
        misstable = (TextView) findViewById(R.id.miss);

        start();
        progress=100;
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgress.setMax(100);
        mProgress.setProgress(progress);
        percentage.setText(" ("+String.valueOf(progress)+"%)");
        mProgress.setBackgroundColor(666666);

        scoretable.setText(String.valueOf(score));


        Bundle bdl = getIntent().getExtras();
         mode = bdl.getInt("mode");

        if(mode==1)
        {
            leveltime = 1000;
            interval = 200;
            miss=5;
        }
        else if(mode==2)
        {
            leveltime=900;
            interval=180;
            miss=4;
        }
        else if(mode==3)
        {
            leveltime=800;
            interval=160;
            miss=3;
        }
        else if(mode==4)
        {
            leveltime=700;
            interval=140;
            miss=3;
        }
        else
        {

        }
        leave=0;
        misstable.setText(String.valueOf(miss));

            makeover();
            gamestart();
    }

    public void start() {


        b1.setBackgroundResource(R.drawable.closedoor1);
        b2.setBackgroundResource(R.drawable.closedoor1);
        b3.setBackgroundResource(R.drawable.closedoor1);
        b4.setBackgroundResource(R.drawable.closedoor1);
        b5.setBackgroundResource(R.drawable.closedoor1);
        b6.setBackgroundResource(R.drawable.closedoor1);
        b7.setBackgroundResource(R.drawable.closedoor1);
        b8.setBackgroundResource(R.drawable.closedoor1);
        b9.setBackgroundResource(R.drawable.closedoor1);

    }


    public void gamestart() {
        b1.setBackgroundResource(R.drawable.closedoor1);
        b2.setBackgroundResource(R.drawable.closedoor1);
        b3.setBackgroundResource(R.drawable.closedoor1);
        b4.setBackgroundResource(R.drawable.closedoor1);
        b5.setBackgroundResource(R.drawable.closedoor1);
        b6.setBackgroundResource(R.drawable.closedoor1);
        b7.setBackgroundResource(R.drawable.closedoor1);
        b8.setBackgroundResource(R.drawable.closedoor1);
        b9.setBackgroundResource(R.drawable.closedoor1);

        Random r = new Random();
        int i1 = (r.nextInt(9) + 1);

        if(i1==1)
        {
            leave=leave+1;
            turn=1;
            b1.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b1.setBackgroundResource(R.drawable.killer);
                }
            }, interval);



        }
        else if(i1==2)
        {
            leave=leave+1;
            turn=2;
            b2.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b2.setBackgroundResource(R.drawable.killer);
                }
            }, interval);


        } else if(i1==3)
        {
            leave=leave+1;
            turn=3;
            b3.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b3.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==4)
        {
            leave=leave+1;
            turn=4;
            b4.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b4.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==5)
        {
            leave=leave+1;
            turn=5;
            b5.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b5.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==6)
        {
            leave=leave+1;
            turn=6;
            b6.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b6.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==7)
        {
            leave=leave+1;
            turn=7;
            b7.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b7.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==8)
        {
            leave=leave+1;
            turn=8;
            b8.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b8.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        } else if(i1==9)
        {
            leave=leave+1;
            turn=9;
            b9.setBackgroundResource(R.drawable.opendoor);
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {

                    b9.setBackgroundResource(R.drawable.killer);
                }
            }, interval);

        }else
        {

        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                if (end==0) {
                                        check();
                                       gamestart();
                }
                else
                {
                    Intent i = new Intent(Shoot.this,score.class);
                    i.putExtra("yrscore", score);
                    i.putExtra("hscore", hscore);
                    i.putExtra("mode", mode);
                    startActivity(i);
                }
            }
        }, leveltime);










    }

    public void b1_click(View v) {
        if(turn==1)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b2_click(View v) {
        if(turn==2)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b3_click(View v) {
        if(turn==3)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b4_click(View v) {
        if(turn==4)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b5_click(View v) {
        if(turn==5)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b6_click(View v) {
        if(turn==6)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b7_click(View v) {
        if(turn==7)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b8_click(View v) {
        if(turn==8)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }
    public void b9_click(View v) {
        if(turn==9)
        {
            score=score+1;
            scorei=scorei+1;
            leave=leave-1;
        }
        else
        {
            miss=miss-1;
        }

    }


    public void display()
    {
        misstable.setText(String.valueOf(miss));
        scoretable.setText(String.valueOf(score));
    }

    public void check()
    {
         if (scorei>4)
         {
        scorei=0;
             leveltime=leveltime-20;
             interval=interval-4;
         }
        if(leave>=2)
        {
            leave=0;
            progress=progress-4;
            mProgress.setProgress(progress);
            percentage.setText(" ("+String.valueOf(progress)+"%)");



            if (progress<=0)
            {
                end=1;
            }
        }
        if (miss<=0)
        {
            end=1;
        }

        display();

    }


    public void makeover()
    {
        Typeface myCustom=Typeface.createFromAsset(getAssets(),"g1.ttf");


        scoretable.setTypeface(myCustom);
        highscore.setTypeface(myCustom);
        misstable.setTypeface(myCustom);
        percentage.setTypeface(myCustom);
        health.setTypeface(myCustom);
        miss_title.setTypeface(myCustom);
        score_title.setTypeface(myCustom);
        highscore_title.setTypeface(myCustom);


        scoretable.setTransformationMethod(null);
        highscore.setTransformationMethod(null);
        misstable.setTransformationMethod(null);
        percentage.setTransformationMethod(null);
        health.setTransformationMethod(null);
        miss_title.setTransformationMethod(null);
        score_title.setTransformationMethod(null);
        highscore_title.setTransformationMethod(null);
    }
}
