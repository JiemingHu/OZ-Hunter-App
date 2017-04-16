package com.example.jieminghu.ozhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class register extends AppCompatActivity {
    Button back_to_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        back_to_login = (Button)findViewById(R.id.backloginbutton);
        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register.this,Login.class);
                startActivity(i);
            }
        });
    }
}
