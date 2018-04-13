package yuvraj.shootkiller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity {

    int yrscore,hscore,mode;
    TextView yourscore,highscore,yscore_title,hscore_title;
    Button play,main,exit;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        yourscore= (TextView) findViewById(R.id.yrscore);
        highscore= (TextView) findViewById(R.id.hscore);
        yscore_title= (TextView) findViewById(R.id.yrscore_title);
        hscore_title= (TextView) findViewById(R.id.hscore_title);

        play=(Button)findViewById(R.id.playagain);
        main=(Button)findViewById(R.id.mainmenu);
        exit=(Button)findViewById(R.id.exit1);

        Bundle bdl = getIntent().getExtras();
       yrscore = bdl.getInt("yrscore");

        mode = bdl.getInt("mode");
        getscore();



        yourscore.setText(String.valueOf(yrscore));
        highscore.setText(String.valueOf(hscore));

        makeover();
    }

    public void playagain_click(View v)
    {

        Intent i = new Intent(score.this,Shoot.class);
        i.putExtra("mode", mode);
        startActivity(i);

    }

    public void mainmenu_click(View v)
    {

        Intent i = new Intent(score.this,MainActivity.class);
        startActivity(i);

    }

    public void exit_click(View v)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click Yes To Exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    public void getscore()
    {
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        try {
            hscore = sharedpreferences.getInt("high", 0);

        } catch (NumberFormatException e) {
            hscore = 0;
        }


        if(yrscore>hscore)
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("high",yrscore);
            editor.commit();
           hscore=yrscore;
        }


    }

    public void makeover()
    {
        Typeface myCustom=Typeface.createFromAsset(getAssets(),"g1.ttf");




        yourscore.setTypeface(myCustom);
        highscore.setTypeface(myCustom);
        yscore_title.setTypeface(myCustom);
        hscore_title.setTypeface(myCustom);
        play.setTypeface(myCustom);
        main.setTypeface(myCustom);
        exit.setTypeface(myCustom);



        yourscore.setTransformationMethod(null);
        highscore.setTransformationMethod(null);
        yscore_title.setTransformationMethod(null);
        hscore_title.setTransformationMethod(null);
        play.setTransformationMethod(null);
        main.setTransformationMethod(null);
        exit.setTransformationMethod(null);

    }
}
