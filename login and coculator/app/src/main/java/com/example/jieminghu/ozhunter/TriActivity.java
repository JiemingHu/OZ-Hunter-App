package com.example.jieminghu.ozhunter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TriActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3,edit4,edit5;
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tri);
        edit1=(EditText) findViewById(R.id.editText1);
        edit2=(EditText) findViewById(R.id.editText2);
        edit3=(EditText) findViewById(R.id.editText3);
        edit4=(EditText) findViewById(R.id.editText4);
        edit5=(EditText) findViewById(R.id.editText5);
    }

    public void OnSin(View v){
        String str=edit1.getText().toString();
        result=sin(str);
        edit2.setText(result);
    }

    public void OnCos(View v){
        String str=edit1.getText().toString();
        result=cos(str);
        edit3.setText(result);
    }

    public void OnTan(View v){
        String str=edit1.getText().toString();
        result=tan(str);
        edit4.setText(result);
    }
    public void OnCtan(View v){
        String str=edit1.getText().toString();
        result=ctan(str);
        edit5.setText(result);
    }

    public static String sin(String s){
        double d= Double.parseDouble(s);
        return String.valueOf(Math.sin(Math.PI / 180 *d));
    }
    public static String cos(String s){
        double d= Double.parseDouble(s);
        return String.valueOf(Math.cos(Math.PI / 180 * d));
    }
    public static String tan(String s){
        double d= Double.parseDouble(s);
        return String.valueOf(Math.tan(Math.PI / 180 * d));
    }
    public static String ctan(String s){
        double d= Double.parseDouble(s);
        return String.valueOf(1/(Math.tan(Math.PI / 180 * d)));
    }
}
