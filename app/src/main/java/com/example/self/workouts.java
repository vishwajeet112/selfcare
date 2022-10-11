package com.example.self;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class workouts extends AppCompatActivity {
    public static final String YOU = "workouts.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
    }

    public void workout1(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"swOyWKk7Oko");
        startActivity(intent);
    }

    public void workout2(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"_l3ySVKYVJ8");
        startActivity(intent);
    }

    public void workout3(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"pvIjsG5Svck");
        startActivity(intent);
    }

    public void workout4(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"DJQGX2J4IVw");
        startActivity(intent);
    }

    public void workout5(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"swOyWKk7Oko");
        startActivity(intent);
    }

    public void workout6(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"z21McHHOpAg");
        startActivity(intent);
    }

    public void workout7(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"42bFodPahBU");
        startActivity(intent);
    }

    public void workout15(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"RrB77_yU_ZM");
        startActivity(intent);
    }

    public void workout14(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"YLtVkelZPxQ");
        startActivity(intent);
    }

    public void workout13(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"H6owLNsWEmE");
        startActivity(intent);
    }

    public void workout12(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"H7GyHF97yoU");
        startActivity(intent);
    }

    public void workout11(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"WpVu2duHnQE");
        startActivity(intent);
    }

    public void workout10(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"DW6GvnglGAk");
        startActivity(intent);

    }

    public void workout9(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"TeUzJmU25Rc");
        startActivity(intent);
    }

    public void workout8(View view) {
        Intent intent=new Intent(this,workout1.class);
        intent.putExtra(YOU,"RUNrHkbP4Pc");
        startActivity(intent);
    }
}