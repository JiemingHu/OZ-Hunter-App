package com.example.jieminghu.ozhunter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notation extends AppCompatActivity {

    EditText NotationFrom;
    EditText NotationTo;
    EditText NotationInput;
    EditText NotationOutput;
    EditText FirstBstring;
    EditText SecondBstring;
    EditText OutputString;
    Button NotationGenerate;
    Button OperationAnd;
    Button OperationOr;
    Button OperationXor;
    Button OperationNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notation);
        NotationFrom = (EditText) findViewById(R.id.editText1);
        NotationTo = (EditText) findViewById(R.id.editText2);
        NotationInput = (EditText) findViewById(R.id.editText3);
        NotationOutput = (EditText) findViewById(R.id.editText4);
        FirstBstring = (EditText) findViewById(R.id.editText5);
        SecondBstring = (EditText) findViewById(R.id.editText6);
        OutputString = (EditText) findViewById(R.id.editText7);
        NotationGenerate = (Button) findViewById(R.id.output);
        OperationAnd = (Button) findViewById(R.id.AND);
        OperationOr = (Button) findViewById(R.id.OR);
        OperationXor = (Button) findViewById(R.id.XOR);
        OperationNot = (Button) findViewById(R.id.NOT);
    }

    public void transResult(View view){
        int from = Integer.parseInt(NotationFrom.getText().toString());
        int to = Integer.parseInt(NotationTo.getText().toString());
        String input = NotationInput.getText().toString();
        Notation_transform notation_transform = new Notation_transform(from,to,input);
        NotationOutput.setText(notation_transform.NotationTrans());
    }

    public void operateAnd(View view){
        int first = Integer.valueOf(FirstBstring.getText().toString());
        int second = Integer.valueOf(SecondBstring.getText().toString());
        int result = first & second;
        OutputString.setText(Integer.toString(result)+" ("+ Integer.toBinaryString(result)+")");
    }

    public void operateOr(View view){
        int first = Integer.valueOf(FirstBstring.getText().toString());
        int second = Integer.valueOf(SecondBstring.getText().toString());
        int result = first | second;
        OutputString.setText(Integer.toString(result)+" ("+ Integer.toBinaryString(result)+")");
    }

    public void operateXor(View view){
        int first = Integer.valueOf(FirstBstring.getText().toString());
        int second = Integer.valueOf(SecondBstring.getText().toString());
        int result = first ^ second;
        OutputString.setText(Integer.toString(result)+" ("+ Integer.toBinaryString(result)+")");
    }

    public void operateNot(View view){
        int first = Integer.valueOf(FirstBstring.getText().toString());
        int result = ~first;
        OutputString.setText(Integer.toString(result)+" ("+ Integer.toBinaryString(result)+")");
    }

}
