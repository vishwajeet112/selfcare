package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Physical1_5 extends AppCompatActivity {
    public static final String EXTRAS="Physical1_5.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical15);
    }
    public void highJackingKnees(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"High knee Jacks: \n \n Standing feet together with arms straight up to sky. Left right leg at right angle while swinging arms down touching under right leg. Recover then repeat in left side.\n");
        startActivity(intent);
    }
    public void jumpingJacks(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Jumping Jacks \n \n In a fluid motion, jump your legs out to the side and raise your arms up over your head. Land and repeat.\n");
        startActivity(intent);
    }
    public void punching(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Straight Punches \n \n Stand in a staggered position with both fists guarding your face. Punch with your front fist while blocking your face with the other hand. Punch with your other fist while rotating your hip forward. Repeat the move.\n");
        startActivity(intent);
    }
    public void squat1(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Overhead Squats \n\n Stand with your feet hip-width apart and hands above your head. Keeping your back straight, push back with your hips like you are sitting in a chair. Try to go to 90 degrees at your knees before returning.");
        startActivity(intent);
    }
    public void squat2(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Squats \n\n Stand with your feet hip-width apart and hands straight parallel to the ground. Keeping your back straight, push back with your hips like you are sitting in a chair. Try to go to 90 degrees at your knees before returning.");
        startActivity(intent);
    }
    public void windmill(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Windmill Exercise\n \n Start standing with your feet hip-width apart and arms stretched above your head with hands together. Rotate your torso to face the right side of the room, making sure your feet and hips stay forward. Lower your torso down to the right then toward your toes as you try to keep your legs straight.");
        startActivity(intent);
    }
    public void streching(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Side Streching \n\n Stand up with your feet set slightly wider than your shoulders. Then raise your left arm up and sideways over your head. At the same time reach down with your right arm and bend your upper body down to the right hand side. Repeat this on the other side. Avoid leaning forwards or back when doing this exercise by imagining you are sandwiched between two walls, one in front of you and one behind that stop you being able to move forwards or backwards, only sideways.");
        startActivity(intent);
    }
    public void mountainClimb(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Mountain Climbing \n\n Start in a plank position. Drive your knee up towards your chest or elbows while alternating lead legs. Increase your speed to increase your heart rate.");
        startActivity(intent);
    }
    public void running(View view){
        Intent intent=new Intent(this,physical1_5_start.class);
        intent.putExtra(EXTRAS,"Running exercise \n\n Running, or jogging, is one of the best cardio exercises you can do. Running for at least 10 minutes a day can significantly lower your risk of cardiovascular disease. Runners lower their chances of dying from heart disease by half.");
        startActivity(intent);
    }
}