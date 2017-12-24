package com.example.dell_pc.servicesassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
 private Button btn1, btn2;
    private EditText text ;
    private TextView text2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register( MainActivity.this);
        btn1 = (Button) findViewById(R.id.btn1);
        text= (EditText) findViewById(R.id.txt);
        text2= (TextView) findViewById(R.id.txt2);
        btn2 =(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                Intent intent = new Intent( MainActivity.this, MyIntentService.class);
                stopService(intent);
            }

        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text =text2.getText().toString();
                Intent intent = new Intent( MainActivity.this, MyIntentService.class );
                intent.putExtra("txt2", text);
                startService(intent);

            }

        });

    }
}
