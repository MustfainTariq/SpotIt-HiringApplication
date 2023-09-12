package com.mustfaintariq.i200770;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Conservation extends AppCompatActivity {
    ImageButton voicecall;
    ImageButton videocall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conservation);

        voicecall = (ImageButton) findViewById(R.id.voice_call);
        videocall = (ImageButton) findViewById(R.id.video_call);
        voicecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VoiceCall.class);
                startActivity(intent);
            }
        });

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoCall.class);
                startActivity(intent);
            }
        });

    }
}