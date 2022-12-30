class Solution {
    /**
     * 행렬 테두리 회전하기
     * 2022-12-31
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] table = new int[rows + 1][columns + 1];

        fillTable(table, rows, columns);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = spin(table, queries[i]);
            System.out.println(i);
            //print(table, rows, columns);
        }

        return answer;
    }

    public void fillTable(int[][] table, int rows, int colunms) {
        int count = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= colunms; j++) {
                table[i][j] = count;
                count++;
            }
        }
    }

    public void print(int[][] table, int rows, int colunms) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= colunms; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int spin(int[][] table, int[] quary) {
        int min = Integer.MAX_VALUE;

        int row = quary[0];
        int col = quary[1];
        int temp = table[row][col];
        int rowRange = quary[2] - quary[0];
        int colRange = quary[3] - quary[1];

        // left
        for (int i = 0; i < rowRange; i++) {
            table[row][col] = table[row + 1][col];
            if (table[row + 1][col] < min) {
                min = table[row + 1][col];
            }
            row++;
        }

        // down
        for (int i = 0; i < colRange; i++) {
            table[row][col] = table[row][col + 1];
            if (table[row][col + 1] < min) {
                min = table[row][col + 1];
            }
            col++;
        }

        // right
        for (int i = 0; i < rowRange; i++) {
            table[row][col] = table[row - 1][col];
            if (table[row - 1][col] < min) {
                min = table[row - 1][col];
            }
            row--;
        }

        // up
        for (int i = 0; i < colRange; i++) {
            table[row][col] = table[row][col - 1];
            if (table[row][col - 1] < min) {
                min = table[row][col - 1];
            }
            col--;
        }
        if (temp < min) {
            min = temp;
        }
        table[row][col + 1] = temp;
        return min;
    }
}