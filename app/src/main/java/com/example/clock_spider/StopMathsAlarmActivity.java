package com.example.clock_spider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class StopMathsAlarmActivity extends AppCompatActivity {
    TextView question;
    EditText answer;
    Button stopAlarm;
    int num1,num2,num3,ans,num4,num5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_maths_alarm);
        question= findViewById(R.id.mathsQuestion);
        answer = findViewById(R.id.mathsQuestionAnswer);
        stopAlarm = findViewById(R.id.stopAlarm);
      Random random = new Random();

       num1 = random.nextInt(20 );
        num4 = random.nextInt(20 );
        num2 = random.nextInt(20);
        num3 = random.nextInt(20);
        ArrayList<String> s=new ArrayList<>();
        s.add("Solve:integration of sinx,limits from 0 to pie/2 ");
        s.add("Solve:integration of cosx,limits from 0 to pie/2 ");
        s.add("Solve:(integration of sinx+cosx,limits from 0 to pie/2)-1 ");
        num5=random.nextInt(3);
        String a= s.get(num5);

//
        ans=1;
        question.setText(a);
        s.clear();
        stopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans1 = answer.getText().toString();
                if(TextUtils.isEmpty(ans1)){
                    Toast.makeText(StopMathsAlarmActivity.this, "Enter ans", Toast.LENGTH_SHORT).show();
                }else{
                    if(Integer.parseInt(ans1) == ans){
                        AlertReciever.mediaPlayer.stop();
                        Intent intent1 = new Intent(StopMathsAlarmActivity.this,AlarmService.class);
                        stopService(intent1);
                        finish();
                        System.exit(0);
                    }else{
                        Toast.makeText(StopMathsAlarmActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
