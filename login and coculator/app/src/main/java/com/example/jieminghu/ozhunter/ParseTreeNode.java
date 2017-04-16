package com.example.jieminghu.ozhunter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ParseTreeNode {
    public ParseTreeNode leftTree;
    public ParseTreeNode rightTree;
    public Object value;

    public ParseTreeNode(String node_value){
        value = node_value;
        leftTree = null;
        rightTree = null;
    }
    public ParseTreeNode(Double node_value){
        value = node_value;
        leftTree = null;
        rightTree = null;
    }

    public static List reconnectString(String input){
        List output = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(input,"()+-*/%^@",true);
        while(tokenizer.hasMoreTokens()){
            output.add(tokenizer.nextToken());
        }
        return output;
    }

    public static List getTokenOfString(List<String> input){
        List output = new ArrayList<Type>();
        for (int i=0;i<input.size();i++){
            output.add(getNextTokenType(input.get(i)));
        }
        return output;
    }

    public static Type getNextTokenType(String token){
        if (token.equals("+")){
            return Type.ADD;
        }else if (token.equals("-")){
            return Type.SUB;
        }else if (token.equals("*")){
            return Type.MUL;
        }else if (token.equals("/")){
            return Type.DIV;
        }else if (token.equals("(")){
            return Type.LEFT;
        }else if (token.equals(")")){
            return Type.RIGHT;
        }else if (token.equals("%")){
            return Type.COM;
        }else if (token.equals("@")){
            return Type.LOG;
        }else if (token.equals("^")){
            return Type.POW;
        }else {
            return Type.NUM;
        }
    }

    public static double evaluateParserTree(ParseTreeNode tree){
        if (tree.value.toString().equals("+")){
            return evaluateParserTree(tree.leftTree) + evaluateParserTree(tree.rightTree);
        }else if (tree.value.toString().equals("-")){
            return evaluateParserTree(tree.leftTree) - evaluateParserTree(tree.rightTree);
        }else if (tree.value.toString().equals("*")){
            return evaluateParserTree(tree.leftTree) * evaluateParserTree(tree.rightTree);
        }else if (tree.value.toString().equals("/")){
            return evaluateParserTree(tree.leftTree) / evaluateParserTree(tree.rightTree);
        }else if (tree.value.toString().equals("%")){
            return evaluateParserTree(tree.leftTree) % evaluateParserTree(tree.rightTree);
        }else if (tree.value.toString().equals("^")){
            return Math.pow(evaluateParserTree(tree.leftTree),evaluateParserTree(tree.rightTree));
        }else if (tree.value.toString().equals("@")){
            return Math.log(evaluateParserTree(tree.rightTree))/ Math.log(evaluateParserTree(tree.leftTree));
        }else {
            return Double.valueOf(tree.value.toString()).doubleValue();
        }
    }
}
