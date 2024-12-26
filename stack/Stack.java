import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class Stack {
    public static void main(String[] args) {
        // Stack<Integer> st = new Stack();
        // ArrayDeque<Integer> st = new ArrayDeque<>(5);
        System.out.println(checkParanthesis("){{}}"));
        
    }

    public static boolean checkParanthesis(String str){
                
        ArrayDeque<Character> stk = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if(ch=='{'|| ch=='(' || ch=='['){
                stk.push(ch);
            }else{
                if(!stk.isEmpty() && matcher( stk.peek(), ch)){
                    stk.pop();
                }else{
                    return false;
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean matcher(char a, char b){
        return ((a=='(' && b==')') || 
        (a=='{' && b=='}')||
        (a=='[' && b==']'));
    }

}
