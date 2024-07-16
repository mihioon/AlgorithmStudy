package algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        //n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        if(n == 0){
            System.out.println(integerList.get(0));
            return;
        }
        if(n == 1){
            System.out.println(integerList.get(1));
            return;
        }
        int order = 2;
        int nthNum = 0;
        while ( order <= n ) {
            nthNum = integerList.get(order-2)+integerList.get(order-1);
            integerList.add(nthNum);
            order++;
        }
        System.out.println(nthNum);
    }
}
