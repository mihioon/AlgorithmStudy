package algorithm.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        /*
        * 인형을 0이 아닌 경우 stack에 넣고 pop을 하면 해당 인형이 나옴
        * */
        List<Stack<Integer>> stackList = new ArrayList<>();
        int size = board.length;
        for (int col = 0; col < size; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = size - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    stack.push(board[row][col]);
                }
            }
            stackList.add(stack);
        }

        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            Stack<Integer> stack = stackList.get(move - 1);

            if (!stack.isEmpty()) {
                int top = stack.pop();
                if (!basket.isEmpty() && basket.peek() == top) {
                    basket.pop();
                    answer += 2; // 인형이 터질 때 2개가 터지므로 2를 더함
                } else {
                    basket.push(top);
                }
            }
        }

        System.out.println(answer);
    }
}
