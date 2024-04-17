package com.example.frag_r7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout portrait, landscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        if(portrait != null)
        {
            Toast.makeText(this, "Portrait mode is active", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Landscape mode is active", Toast.LENGTH_SHORT).show();
        }

    }

    private void init()
    {
        portrait = findViewById(R.id.portrait_mode);
        landscape = findViewById(R.id.landscape_mode);
    }
}