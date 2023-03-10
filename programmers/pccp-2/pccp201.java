class Solution {
    // 상 우 하 좌  
    // 배열이 아니라 가상의 좌표계를 상정하므로, 상, 하를 그에 맞게 바꿔줌
    static int[] moveRow = {1, 0, -1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    
    static int dir = 0;
    static int row = 0;
    static int col = 0;
    
    public int[] solution(String command) {
        
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            
            if (c == 'R') {
                doR();
            } else if (c == 'L') {
                doL();
            } else if (c == 'G') {
                doG();
            } else if (c == 'B') {
                doB();
            }
            // System.out.println(String.format("row = %d, col = %d, dir = %d", row, col, dir));
        }
        
        int[] answer = {col, row};
        
        return answer;
    }
    
    private void doR() {
        dir += 1;
        if (dir >= 4) {
            dir = 0;
        }
    }
    
    private void doL() {
        dir -= 1;
        if (dir <= -1) {
            dir = 3;
        }
    }
    
    private void doG() {
        row += moveRow[dir];
        col += moveCol[dir];
    }
    
    private void doB() {
        row += moveRow[dir] * -1;
        col += moveCol[dir] * -1;
    }
}
