import sorting.*;
import strings.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class MainClass {

    public MainClass() {}

    public static void linearSearch() {
        int[] testArray = { 1, 3, 5, 9};

        int result = LinearSearch.search(testArray, 4, 3);
        System.out.println("result is "+ result);
    }

    public static void stringquestions() {
        StringQuestions sq = new StringQuestions();
        System.out.println(sq.LC_9_isPalindrome(939));
    }

    public static int knapsack(int W, int[] weights, int[] vals) {
        return knapsack1(W, weights, vals, 0);
    }

    private static int knapsack1(int W, int[] weights, int[] vals, int i) {
        if (i == weights.length) return 0;
        if (W - weights[i] < 0)
            return knapsack1(W, weights, vals, i+1);
        return Math.max(knapsack1(W - weights[i], weights, vals, i+1),
                knapsack1(W, weights, vals, i+1));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        char[] pathChar = path.toCharArray();
        int numOfValleys = 0;
        int index = 0;

        for (int i = 0; i < steps; i++) {
            if (index == 0 && pathChar[i] == 'D') {
                index--;
                numOfValleys++;
            } else if (index != 0 && pathChar[i] == 'D') {
                index--;
            } else if (pathChar[i] == 'U') {
                index++;
            }
        }

        return numOfValleys;
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }

    public static int recursiveInt = 10;

    public static void countdown(int recursiveNum) {

        if (recursiveNum == 0) return;
        countdown(--recursiveNum);
        System.out.println(recursiveNum);
    }

    public static void main(String arg[])
    {

        String test = "https://%1\\$s/flow/freeze_flow/";

        String x = String.format(test, "classpass.com");
        System.out.println(x);

        //linearSearch();
//        //stringquestions();
//        int[] weights = {10, 20, 30};
////        int[] values = {60, 100, 12};
////        int max_weight = 5;
////        int x = knapsack(max_weight, weights, values);
        //int result = countingValleys(8, "UDDDUDUU");
//       int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}};
//       int result = orangesRotting(grid);
//        System.out.println(result)
//        countdown(10);

    }
}
