package yuvraj.shootkiller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
int mode;
    Button e,m,h,ex,exit;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode=0;

         e= (Button) findViewById(R.id.easy);
        m= (Button) findViewById(R.id.medium);
        h= (Button) findViewById(R.id.hard);
        ex= (Button) findViewById(R.id.expert);
        exit= (Button) findViewById(R.id.exit);
        makeover();

    }

    public void easy_click(View v)
    {
        mode=1;
        Intent i = new Intent(MainActivity.this,Shoot.class);
        i.putExtra("mode", mode);
        startActivity(i);

    }
    public void medium_click(View v)
    {
        mode=2;
        Intent i = new Intent(MainActivity.this,Shoot.class);
        i.putExtra("mode", mode);
        startActivity(i);

    }
    public void hard_click(View v)
    {
        mode=3;
        Intent i = new Intent(MainActivity.this,Shoot.class);
        i.putExtra("mode", mode);
        startActivity(i);

    }
    public void expert_click(View v)
    {
        mode=4;
        Intent i = new Intent(MainActivity.this,Shoot.class);
        i.putExtra("mode", mode);
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

    public void makeover()
    {
        Typeface myCustom=Typeface.createFromAsset(getAssets(),"g1.ttf");


        e.setTypeface(myCustom);
        m.setTypeface(myCustom);
        h.setTypeface(myCustom);
        ex.setTypeface(myCustom);
        exit.setTypeface(myCustom);


        e.setTransformationMethod(null);
        m.setTransformationMethod(null);
        h.setTransformationMethod(null);
        ex.setTransformationMethod(null);
        exit.setTransformationMethod(null);
    }
}
