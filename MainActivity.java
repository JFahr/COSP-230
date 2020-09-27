package com.example.animalvoices;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    MediaPlayer mpCow, mpPig;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btnCow);
        button2 = (Button) findViewById(R.id.btnPig);
        button1.setOnClickListener(bIrishJig);
        button2.setOnClickListener(bBagpipes);
        mpCow = new MediaPlayer();
        mpCow=MediaPlayer.create(this, R.raw.cows);
        mpPig = new MediaPlayer();
        mpPig = MediaPlayer.create(this, R.raw.pigs);
        playing=0;

    }//end on create
    Button.OnClickListener bIrishJig = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpCow.start();
                    playing =1;
                    button1.setText("Pause The Cows Sound");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCow.pause();;
                    playing = 0;
                    button1.setText("Listen To The Cows");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }//end switch

        }
    };//end bUkulele
    Button.OnClickListener bBagpipes = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpPig.start();
                    playing = 1;
                    button2.setText("Pause The Pigs Sound");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPig.pause();
                    playing =0;
                    button2.setText("Play Bagpipes Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }//end switch
        }//end onClick
    };//end bDrums
}//end Main Activity class