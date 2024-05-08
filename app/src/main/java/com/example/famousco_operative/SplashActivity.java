package com.example.famousco_operative;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer sound;
    Animation topAnimation, bottomAnimation;
    ImageView logo,title;

    Button letsgo;
    ConstraintLayout mainview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Utils.blackIconStatusBar(SplashActivity.this, R.color.baground);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.toptodown);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.downtotop);


        logo = findViewById(R.id.logo);
        title = findViewById(R.id.titles);

        letsgo = findViewById(R.id.letsgo);
        mainview = findViewById(R.id.mainview);



        mainview.setVisibility(View.VISIBLE);

        //top animation
        logo.setAnimation(bottomAnimation);
        title.setAnimation(bottomAnimation);

        //bottom animation
        letsgo.setAnimation(topAnimation);



        letsgo.setOnClickListener(v -> {


            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,
                    Pair.create(logo, "logo"),

                    Pair.create(title, "subtitletext"));

            startActivity(intent, options.toBundle());
            finish();


        });

    }


}

