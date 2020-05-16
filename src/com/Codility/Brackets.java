package com.Codility;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {

        System.out.println(solution("{}[]{}[(){}]{[()]}")); //return 1
        System.out.println(solution("{}{}{}[[[]")); //return 0
    }
    public static int solution(String S) {

        // main idea: use "Stack" (push and pop)

        //special case
        if(S.length() == 0)
            return 1;

        // new Stack<Character>()
        Stack<Character> stack = new Stack<>();

        // scan the string (just one pass)
        for(int i=0; i< S.length(); i++){
            // note: push "its pair"
            if( S.charAt(i) == '(' ){
                stack.push(')');
            }
            else if( S.charAt(i) == '[' ){
                stack.push(']');
            }
            else if( S.charAt(i) == '{' ){
                stack.push('}');
            }
            // pop and check
            else if( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){
                // important: check if the stack is empty or not (be careful)
                if(stack.isEmpty() == true){
                    return 0;
                }
                else{
                    char temp = stack.pop(); // check if the stack is empty before pop!!!
                    if(temp != S.charAt(i)){ // not a pair
                        return 0;
                    }
                }
            }
        }
        // note: check if the stack is empty or not (be careful)
        if( !stack.isEmpty() ){
            return 0;
        }
        else{
            return 1;
        }
    }
}
