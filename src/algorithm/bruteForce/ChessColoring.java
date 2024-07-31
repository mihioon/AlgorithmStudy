package algorithm.bruteForce;

import java.util.Scanner;

public class ChessColoring {
    public static String[] board; // 전역변수

    public static int getSolution(int startRow, int startCol) {
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int sol = 0 ;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(board[startRow+x].charAt(startCol+y) != orgBoard[x % 2].charAt(y)) {
                    sol++;
                }
            }
        }
        return Math.min(sol, 64-sol);
    }

    public static void main(String[] args) {
        // 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
        // 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

        // N행 M열
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.next();
        }
        scanner.close();

        // 8*8단위의 보드를 만드는 것 - 한 꼭짓점을 기준으로 잡으면 결정 됨. 0부터 i<N-8+1까지
        int totalMin = Integer.MAX_VALUE; // 최솟값을 찾기 위함 - 가장 큰 수로 초기화 한 후 비교한다.
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                int boardMin = getSolution(i,j); // 시작점만 넘기고 전역변수를 써서 연산
                if(boardMin < totalMin){
                    totalMin = boardMin;
                }
            }
        }

        System.out.println(totalMin);
    }
}
