package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class workout1 extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout1);
        Intent intent = new Intent();
        intent=getIntent();
        String hello=intent.getStringExtra(workouts.YOU);
        youTubePlayerView=findViewById(R.id.youtube);
        YouTubePlayer.OnInitializedListener listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(hello);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Intialization Failed", Toast.LENGTH_SHORT).show();

            }
        };
        youTubePlayerView.initialize("AIzaSyAYOfNg8B21iqtxbJtzS76UjbwmfZJW9dg",listener);

    }
    public void moreFun(View view) {
        startActivity(new Intent(this,workouts.class));
    }

    public void nextFun(View view) {
        startActivity(new Intent(this,FeedbackWorkout.class));
    }
}