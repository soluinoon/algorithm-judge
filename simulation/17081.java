import java.io.*;
import java.util.*;

class Main {
    /**
     * 17081
     * 2022-12-20
     */
    static char[][] table;
    static Info[][] tableInfo;
    // 상 하 좌 우
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};

    static int n, m, monsterCount, boxCount, playerRow, playerCol, turns, startRow, startCol;
    static int endFlag;
    static ArrayList<Character> movements = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        table = new char[n + 1][m + 1];
        tableInfo = new Info[n + 1][m + 1];
        // input - table
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = temp.charAt(j - 1);
                if (c == 'M' || c == '&') {
                    monsterCount++;
                }
                if (c == 'B') {
                    boxCount++;
                }
                if (c == '@') {
                    playerRow = i;
                    startRow = i;
                    playerCol = j;
                    startCol = j;
                    c = '.';
                }
                table[i][j] = c;
                tableInfo[i][j] = new Info();
            }
        }
        // input - movement
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            movements.add(str.charAt(i));
        }


        // input - monster
        for (int i = 0; i < monsterCount; i++) {
            String temp = br.readLine();
            st = new StringTokenizer(temp);
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            tableInfo[row][col].name = st.nextToken();
            tableInfo[row][col].atk = Integer.parseInt(st.nextToken());
            tableInfo[row][col].def = Integer.parseInt(st.nextToken());
            tableInfo[row][col].hp = Integer.parseInt(st.nextToken());
            tableInfo[row][col].exp = Integer.parseInt(st.nextToken());
        }

        // input - box
        for (int i = 0; i < boxCount; i++) {
            String temp = br.readLine();
            st = new StringTokenizer(temp);
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            String category = st.nextToken();
            if (category.equals("O")) {
                tableInfo[row][col].name = st.nextToken();
            } else if (category.equals("W")) {
                tableInfo[row][col].name = category;
                tableInfo[row][col].atk = Integer.parseInt(st.nextToken());
            } else {
                tableInfo[row][col].name = category;
                tableInfo[row][col].def = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        Player player = new Player();
        for (int i = 0; i < movements.size(); i++) {
            int move = parseMovement(movements.get(i));
            int nextCol = playerCol + moveCol[move];
            int nextRow = playerRow + moveRow[move];

            // move
            if (isMovable(nextRow, nextCol)) {
                playerCol = nextCol;
                playerRow = nextRow;
            }
            turns++;

            // action
            char action = table[playerRow][playerCol];
            if (action == 'B') {
                openBox(player, playerRow, playerCol);
            } else if (action == '^') {
                if (player.accessories.contains("DX")) {
                    player.currentHp -= 1;
                } else {
                    player.currentHp -= 5;
                }
                if (player.currentHp <= 0) {
                    if (player.accessories.contains("RE")) {
                        player.currentHp = player.MaxHp;
                        playerCol = startCol;
                        playerRow = startRow;
                        player.accessories.remove("RE");
                    } else {
                        endFlag = 1;
                    }
                }
            } else if (action == '&' || action == 'M') {
                fight(player, playerRow, playerCol);
            }

            if (endFlag == 1) {
                break;
            }
        }
        print(player);
    }

    public static int parseMovement(Character c) {
        if (c == 'U') {
            return 0;
        } else if (c == 'D') {
            return 1;
        } else if (c == 'L') {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean isMovable(int row, int col) {
        if (row < 1 || n < row || col < 1 || m < col || table[row][col] == '#') {
            return false;
        }
        return true;
    }

    public static void openBox(Player player, int row, int col) {
        Info info = tableInfo[row][col];

        if (info.name.equals("W")) {
            player.weapon = info.atk;
        } else if (info.name.equals("A")) {
            player.armor = info.def;
        } else {
            player.getAccessory(info.name);
        }
        table[row][col] = '.';
    }

    public static void fight(Player player, int row, int col) {
        Info monsterInfo = tableInfo[row][col];
        int monsterMaxHp = monsterInfo.hp;
        int count = 0;

        if (table[row][col] == 'M' && player.accessories.contains("HU")) {
            player.currentHp = player.MaxHp;
        }
        while (true) {
            // player attack
            if (count == 0 && player.accessories.contains("CO")) {
                if (player.accessories.contains("DX"))
                    monsterInfo.hp -= Math.max(1, player.getAtk() * 3 - monsterInfo.def);
                else
                    monsterInfo.hp -= Math.max(1, player.getAtk() * 2 - monsterInfo.def);
            } else {
                monsterInfo.hp -= Math.max(1, player.getAtk() - monsterInfo.def);
            }

            if (monsterInfo.hp <= 0) {
                if (player.accessories.contains("EX")) {
                    player.updateExp((int) Math.floor((monsterInfo.exp * 1.2)));
                } else {
                    player.updateExp(monsterInfo.exp);
                }
                if (table[row][col] == 'M') {
                    endFlag = 1;
                }
                table[row][col] = '.';
                if (player.accessories.contains("HR")) {
                    player.currentHp += 3;
                    if (player.currentHp > player.MaxHp) {
                        player.currentHp = player.MaxHp;
                    }
                }
                return;
            }

            // monsterAttack
            if (count == 0 && table[row][col] == 'M' && player.accessories.contains("HU")) {
                player.currentHp -= 0;
            } else {
                player.currentHp -= Math.max(1, monsterInfo.atk - player.getDef());
            }
            if (player.currentHp <= 0) {
                if (player.accessories.contains("RE")) {
                    player.currentHp = player.MaxHp;
                    monsterInfo.hp = monsterMaxHp;
                    playerCol = startCol;
                    playerRow = startRow;
                    player.accessories.remove("RE");
                } else {
                    endFlag = 1;
                }
                return;
            }
            count++;
        }
    }

    public static void print(Player player) {
        // print greed
        if (player.currentHp > 0) {
            table[playerRow][playerCol] = '@';
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        // print turns
        System.out.println("Passed Turns : " + turns);
        // print playerInfo
        System.out.println("LV : " + player.level);
        if (player.currentHp < 0) {
            player.currentHp = 0;
        }
        System.out.println("HP : " + player.currentHp + "/" + player.MaxHp);
        System.out.println("ATT : " + player.playerAtk + "+" + player.weapon);
        System.out.println("DEF : " + player.playerDef + "+" + player.armor);
        System.out.println("EXP : " + player.exp + "/" + player.level * 5);
        // print game status
        if (turns >= movements.size() && endFlag == 0) {
            System.out.println("Press any key to continue.");
            return;
        }
        if (player.currentHp > 0) {
            System.out.println("YOU WIN!");
        } else {
            if (table[playerRow][playerCol] == '^') {
                System.out.println("YOU HAVE BEEN KILLED BY SPIKE TRAP..");
            } else {
                System.out.println("YOU HAVE BEEN KILLED BY " + tableInfo[playerRow][playerCol].name + "..");
            }
        }
    }

    static class Player {
        int MaxHp = 20;
        int currentHp = 20;
        int playerAtk = 2;
        int playerDef = 2;
        int level = 1;
        int exp = 0;

        int weapon = 0;
        int armor = 0;
        ArrayList<String> accessories = new ArrayList<>();

        public void updateExp(int n) {
            System.out.println("get exp " + n);
            exp += n;
            if (exp >= level * 5) {
                exp = 0;
                level++;
                MaxHp += 5;
                playerAtk += 2;
                playerDef += 2;
                currentHp = MaxHp;
            }
        }

        public void getAccessory(String accessory) {
            if (accessories.size() >= 4 || accessories.contains(accessory)) {
                return;
            }
            accessories.add(accessory);
        }

        public int getAtk() {
            return playerAtk + weapon;
        }

        public int getDef() {
            return playerDef + armor;
        }
    }

    static class Info {
        String name;
        int hp;
        int atk;
        int def;
        int exp;
    }
}
