package algorithm.twoPointer;

import java.util.*;

public class HerdSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        /**
         연속되는 숫자의 합 -> 1~i개의 연속되는 숫자의 합에 k씩를 더한 값으로 볼 수 있음
         N = (1+2+...+i)+(i*k)
         여기서 k가 정수인 것만 count하면 됨
         (N-(1+2))/2
         (N-(1+2+3))/3
         (N-(1+2+3+4))/4
         (N-(1+2+3+4+5))/5
         (N-(1+2+3+4+5+6))/6
         ...
         k = (N-(1+2+...+i))%i
         */

        int cnt = 0;
        int sum = 0;
        int i = 1;
        while (sum < N) {
            //1부터 i까지의 합이 N을 넘어서는 경우는 불가능하므로 해당 i가 마지막
            sum+=i;
            if((N-(double)sum)%i == 0) { cnt++; } //연산 결과가 0이면 정수

            i++;
        }

        System.out.println(cnt);

    }
}