package algorithm.stack_queue;

import java.util.*;

public class Printer {
    /*
    첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.

    테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과,
    몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
    이때 맨 왼쪽은 0번째라고 하자.
    두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다. 중요도는 1 이상 9 이하의 정수이고,
    중요도가 같은 문서가 여러 개 있을 수도 있다.

    3
    1 0
    5
    4 2
    1 2 3 4
    6 0
    1 1 9 1 1 1
    * */

    static class Document {
        int index;
        int prior;

        Document(int index, int prior) {
            this.index = index;
            this.prior = prior;
        }
    }

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);

        int testCnt = sc.nextInt();
        for (int i = 0; i < testCnt; i++) {// 테스트 케이스 수만큼
            int docCnt = sc.nextInt(); // 문서 개수
            int qDoc = sc.nextInt(); // 궁금한 문서

            // 초기화
            Queue<Document> queue = new LinkedList<>();
            int cnt = 0;

            for (int j = 0; j < docCnt; j++) {
                queue.add(new Document(j,sc.nextInt()));
            }

            int printOrder = 0; // 출력 순서

            while (!queue.isEmpty()) { // 큐가 빌때까지 반복
                Document peek = queue.poll();
                boolean priorChk = false;

                for (Document doc : queue) {
                    if (doc.prior > peek.prior) {
                        priorChk = true;
                        break;
                    }
                }

                if (priorChk) {
                    queue.add(peek);
                }
                if (!priorChk){ //우선문서가 있으면
                    printOrder++;
                    if (peek.index == qDoc) { //원하는 문서 번호면
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}

