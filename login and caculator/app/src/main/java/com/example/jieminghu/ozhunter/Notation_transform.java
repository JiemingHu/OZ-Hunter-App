package com.example.jieminghu.ozhunter;

/**
 * Created by Jieming Hu on 20/04/16.
 */
public class Notation_transform {
    public static int from;
    public static int to;
    public static String input;

    public Notation_transform(int from, int to, String input){
        this.from = from;
        this.to = to;
        this.input = input;
    }

    public static int mul(int d,int z){
        int pro = 1;
        if (z==0){
            pro = 1;
        }else {
            for (int m=1;m<=z;m++){
                pro = d * pro;
            }
        }
        return pro;
    }

    public static String NotationTrans(){
        int num = Integer.valueOf(input,from);
        int t1 = 0;

        for (int i=0;;i++){
            int t = mul(to,i);
            if (num/t == 0){
                t1 = i;
                break;
            }
        }

        String[] st1 = new String[t1];
        for (int j=0;j<t1;j++){
            if (num != 0){
                st1[j] = String.valueOf(num%to);
                num = num / to;
            }
        }

        String st2 = "";
        for (int k=0;k<t1;k++){
            st2 = st2 + st1[t1-1-k];
        }

        return st2;
    }
}
