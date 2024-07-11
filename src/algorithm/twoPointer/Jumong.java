package algorithm.twoPointer;

import java.util.*;

public class Jumong {
    public static void main(String[] args) {
        /**
         * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다.
         * 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
         * 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
         * 고유한 번호는 100,000보다 작거나 같은 자연수이다.
         */

        int cnt = 0;
        // 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        //solution1
/*        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(list[i]+list[j] == M){
                    cnt++;
                }
            }
        }*/

        //solution2
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;

        while(left < right) {
            if(arr[left] + arr[right] == M) {
                cnt++;
                left++;
                right--;
            }else {
                if(arr[left] + arr[right] < M) {
                    left++;
                }else {
                    right--;
                }
            }
        }

        // 출력
        System.out.println(cnt);

    }
}