package algorithm.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String[] stringArray = new String[N];
        for(int i = 0; i < N; i++) {
            stringArray[i] = scanner.next();
        }
        scanner.close();

        for(int i = 0; i < N ;i++){
            boolean flag = true;
            Stack<Integer> stack = new Stack<Integer>();
            char[] charArray = stringArray[i].toCharArray();
            int x = 0;
            int y = 0;
            for( char a : charArray){
                if(a == '('){
                    stack.push(1);
                    x++;
                }
                if(a == ')'){
                    y++;
                    try {
                        stack.pop();
                    } catch (Exception e){
                        flag=false;
                        break;
                    }
                }
            }
            if(x!=y)System.out.println("NO");
            if(x==y&&flag) System.out.println("YES");
        }
    }
}