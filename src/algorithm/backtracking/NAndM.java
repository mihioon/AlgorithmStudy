package algorithm.backtracking;

import java.util.Scanner;

public class NAndM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //자연수수
        int m = sc.nextInt(); //개수

        int[] combination = new int[m];
        generateCombinations(n, m, 0, 1, combination);
    }

    //
    public static void generateCombinations(int n, int m, int depth, int start, int[] combination) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            combination[depth] = i;
            generateCombinations(n, m, depth + 1, i + 1, combination);
        }
    }
}
