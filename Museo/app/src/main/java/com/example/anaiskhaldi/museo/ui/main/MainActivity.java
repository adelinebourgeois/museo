package com.example.anaiskhaldi.museo.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.ui.search.SearchLocationActivity;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.example.anaiskhaldi.museo.utils.Preference;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Affichage du SplashScreen pendant deux secondes
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                Preference.setBack(MainActivity.this, false);
                // Passage du MainActivity vers le MapActivity
                Intent intentLocation = new Intent(MainActivity.this, SearchLocationActivity.class);
                startActivity(intentLocation);
                finish();

            }
        }, Constant.SPLASH_TIME);

    }
}
