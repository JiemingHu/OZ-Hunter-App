package com.example.jieminghu.ozhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    String total="";
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        edit=(EditText) findViewById(R.id.input);
    }

    public void OnClick(View v){
        Button button=(Button)v;
        String str=button.getText().toString();
        total+=str;
        //EditText edit=(EditText)findViewById(R.id.input);
        edit.setText(total);

    }
    public void OnClear(View v){
        //EditText edit2=(EditText)findViewById(R.id.input);
        edit.setText("");
        total="";
    }
    public void OnLog(View v){
        //EditText edit=(EditText)findViewById(R.id.input);
        edit.setText(total+"@");
        total+="@";
    }

    public void OnPow(View v){
        //EditText edit=(EditText)findViewById(R.id.input);
        edit.setText(total+"^");
        total+="^";
    }

    public void OnX(View v){
        //EditText edit=(EditText)findViewById(R.id.input);
        edit.setText(total+"1/");
        total+="1/";
    }

    public void OnNotation(View v){
        Intent i=new Intent(this,Notation.class);
        startActivity(i);
    }

    public void OnDelete(View view){
        if (total.length() > 1){
            total = total.substring(0,total.length()-1);
            edit.setText(total);
        }else if (total.length() <= 1){
            edit.setText("");
            total = "";
        }
    }


    public void OnTri(View v){
        Intent i=new Intent(this,TriActivity.class);
        startActivity(i);
    }
    /*public String add_zero(String initial){
        List<String> tmp_string = ParseTreeNode.reconnectString(initial);
        int length = tmp_string.size();
        for (int i=0;i<length;i++){
            if (ParseTreeNode.getNextTokenType(tmp_string.get(i)) == Type.SUB && (i==0 || (ParseTreeNode.getNextTokenType(tmp_string.get(i-1)) == Type.LEFT))){
                tmp_string.set(i,"0-");
            }
        }
        String output = "";
        for (int k=0;k<length;k++){
            output += tmp_string.get(k);
        }
        return output;
    }

    public String tt = "1+2";/////////////////////////////////////////////
    public String input = add_zero(tt);
    public List<String> input_list = ParseTreeNode.reconnectString(input);
    public List<Type> input_type = ParseTreeNode.getTokenOfString(input_list);
    public Type t1,t2;
    public String tmp;

    public Type getNext(){
        if (input_list.size()!=0){
            Type tmp_type = input_type.get(0);
            tmp = input_list.get(0);
            input_list.remove(0);
            input_type.remove(0);
            return tmp_type;
        }else{
            return null;
        }
    }

    public ParseTreeNode parseBracket(){
        t1 = getNext();
        ParseTreeNode rootNode = null;
        if (t1 == Type.NUM){
            double num = Double.parseDouble(tmp);
            rootNode = new ParseTreeNode(num);
        }else if (t1 == Type.LEFT){
            rootNode = parseAddSub();
        }
        return rootNode;
    }

    public ParseTreeNode parseMulDiv(){
        ParseTreeNode rootNode = parseBracket();
        t2 = getNext();
        while (t2==Type.MUL || t2==Type.DIV || t2==Type.COM || t2==Type.POW || t2==Type.LOG){
            ParseTreeNode newRootNode;
            if (t2 == Type.MUL){
                newRootNode = new ParseTreeNode("*");
            }else if (t2 == Type.DIV){
                newRootNode = new ParseTreeNode("/");
            }else if (t2 == Type.LOG){
                newRootNode = new ParseTreeNode("@");
            }else if (t2 == Type.POW){
                newRootNode = new ParseTreeNode("^");
            }else{
                newRootNode = new ParseTreeNode("%");
            }
            newRootNode.leftTree = rootNode;
            newRootNode.rightTree = parseBracket();
            rootNode = newRootNode;
            t2 = getNext();
        }
        return rootNode;
    }

    public ParseTreeNode parseAddSub(){
        ParseTreeNode rootNode = parseMulDiv();
        while (t2==Type.ADD || t2==Type.SUB){
            ParseTreeNode newRootNode;
            if (t2 == Type.ADD){
                newRootNode = new ParseTreeNode("+");
            }else{
                newRootNode = new ParseTreeNode("-");
            }
            newRootNode.leftTree = rootNode;
            newRootNode.rightTree = parseMulDiv();
            rootNode = newRootNode;
        }
        return rootNode;
    }*/


    public void getResult(View view){
        //String tmp = edit.getText().toString();
       // edit.setText(total + "******");
        //tt = edit.getText().toString();
       //double result = ParseTreeNode.evaluateParserTree(parseAddSub());
       // String result_string = Double.toString(result);
       // edit.setText(tt + "=" + result_string);
        //String tmp = edit.getText().toString();
        //edit.setText(tmp + "=");
        //String tmp = edit.getText().toString();
        parseExpression ee = new parseExpression();
        double result = ParseTreeNode.evaluateParserTree(ee.parseAddSub());
        edit.setText(total + "="+ Double.toString(result));
        //total=Double.toString(result);
    }

    class parseExpression {
        //MainActivity t = new MainActivity();
        //public String expression = t.edit.getText().toString();
        public String expression = total;
        public String input = add_zero(expression);
        public List<String> input_list = ParseTreeNode.reconnectString(input);
        public List<Type> input_type = ParseTreeNode.getTokenOfString(input_list);
        public Type t1,t2;
        public String tmp;
        public Double result;

        //public parseExpression(){
            //expression = total;
            // input = add_zero(expression);
            //input_list = ParseTreeNode.reconnectString(input);
            //input_type = ParseTreeNode.getTokenOfString(input_list);
            //result = ParseTreeNode.evaluateParserTree(expression);
            //System.out.println(expression+"----------------------------");
            //System.out.println(t.edit.getText().toString()+"----------------------------");
        //}

       /* public String returnInput(){
            this.input=add_zero(expression);
            return input;
        }
        public List<String> returnList(){
            this.input_list = ParseTreeNode.reconnectString(returnInput());
            return input_list;
        }
        public List<Type> returnType(){
            this.input_type = ParseTreeNode.getTokenOfString(returnList());
            return input_type;
        }*/

        public String add_zero(String initial){
            List<String> tmp_string = ParseTreeNode.reconnectString(initial);
            int length = tmp_string.size();
            for (int i=0;i<length;i++){
                if (ParseTreeNode.getNextTokenType(tmp_string.get(i)) == Type.SUB && (i==0 || (ParseTreeNode.getNextTokenType(tmp_string.get(i-1)) == Type.LEFT))){
                    tmp_string.set(i,"0-");
                }
                if (tmp_string.get(i).equals("e")){
                    tmp_string.set(i,"2.718281828459045");
                }
            }

            String output = "";
            for (int k=0;k<length;k++){
                output += tmp_string.get(k);
            }
            return output;
        }

        public Type getNext(){
            //String input = add_zero(expression);
            //List<String> input_list = ParseTreeNode.reconnectString(input);
            //List<Type> input_type = ParseTreeNode.getTokenOfString(input_list);

            if (input_list.size()!= 0){
                Type tmp_type = input_type.get(0);
                tmp = input_list.get(0);
                input_list.remove(0);
                input_type.remove(0);
                //expression = expression.substring(0,expression.length()-1);
                return tmp_type;
            }else{
                return null;
            }
        }

        public ParseTreeNode parseBracket(){
            t1 = getNext();
            ParseTreeNode rootNode = null;
            if (t1 == Type.NUM){
                double num = Double.parseDouble(tmp);
                rootNode = new ParseTreeNode(num);
            }else if (t1 == Type.LEFT){
                rootNode = parseAddSub();
            }
            return rootNode;
        }

        public ParseTreeNode parseMulDiv(){
            ParseTreeNode rootNode = parseBracket();
            t2 = getNext();
            while (t2==Type.MUL || t2==Type.DIV || t2==Type.COM || t2==Type.POW || t2==Type.LOG){
                ParseTreeNode newRootNode;
                if (t2 == Type.MUL){
                    newRootNode = new ParseTreeNode("*");
                }else if (t2 == Type.DIV){
                    newRootNode = new ParseTreeNode("/");
                }else if (t2 == Type.LOG){
                    newRootNode = new ParseTreeNode("@");
                }else if (t2 == Type.POW){
                    newRootNode = new ParseTreeNode("^");
                }else{
                    newRootNode = new ParseTreeNode("%");
                }
                newRootNode.leftTree = rootNode;
                newRootNode.rightTree = parseBracket();
                rootNode = newRootNode;
                t2 = getNext();
            }
            return rootNode;
        }

        public ParseTreeNode parseAddSub(){
            ParseTreeNode rootNode = parseMulDiv();
            while (t2==Type.ADD || t2==Type.SUB){
                ParseTreeNode newRootNode;
                if (t2 == Type.ADD){
                    newRootNode = new ParseTreeNode("+");
                }else{
                    newRootNode = new ParseTreeNode("-");
                }
                newRootNode.leftTree = rootNode;
                newRootNode.rightTree = parseMulDiv();
                rootNode = newRootNode;
            }
            return rootNode;
        }
    }
}
