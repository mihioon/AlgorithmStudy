package algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if(n == 0){
            System.out.println(0);
            return;
        }
        if(n == 1){
            System.out.println(1);
            return;
        }
        int first = 0;
        int second = 1;
        int order = 2;
        int nthNum = 0;
        while ( order <= n ) {
            nthNum = first+second;
            first=second;
            second=nthNum;
            order++;
        }
        System.out.println(nthNum);
        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + " ms");
    }
}
