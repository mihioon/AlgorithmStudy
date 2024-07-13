package algorithm.stack_queue;

import java.util.Scanner;

public class IronBar {
    public static void main(String[] args) {
        /*
            레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
            쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
        */

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        char[] charArray = str.toCharArray();

        int start = 0;
        char prev ='.';
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(i == 0){
                prev = '*';
            }
            if(i != 0){
                prev = charArray[i-1];
            }

            if(charArray[i] == '('){
                start++;
                prev = charArray[i];
            }
            if(charArray[i] == ')'){
                if(prev == '('){ //레이저
                    start--;
                    cnt+=start;
                }
                if(prev == ')'){ //막대꼬다리
                    start--;
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);

    }
}
