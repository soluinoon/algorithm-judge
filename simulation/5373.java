import java.util.*;
import java.io.*;

/*
 * 5373 큐빙
 * 
 */

public class Main {

    static char[][][] cube;
    static char[][] cubeTemp;
    static ArrayList<String>[] order;
    static int n;
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        
        cube = new char[6][3][3];
        order = new ArrayList[n];

        // input
        for (int i = 0; i < n; i++) {
            order[i] = new ArrayList<>();
            int orderAmount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < orderAmount; j++) {
                order[i].add(st.nextToken());
            }
        }

        // excute
    

        
        cubeInit();
        for (int i = 0; i < n; i++) {
            
                for (int j = 0; j < order[i].size(); j++) {
                    str = order[i].get(j);
                    intersection(str);
                    //printing();
                }
                printResult();
                cubeInit();
        }
        
    }

    static void cubeInit() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[0][i][j] = 'o';
                cube[1][i][j] = 'w';
                cube[2][i][j] = 'r';
                cube[3][i][j] = 'y';
                cube[4][i][j] = 'g';
                cube[5][i][j] = 'b';
            }
        }
    }

    static void intersection(String str) {
        char face = str.charAt(0);
        char ori = str.charAt(1);

        if (face == 'U') {
            if (ori == '-')
                turnFaceAntiClockWise(1);
            else if (ori == '+')
                turnFaceClockWise(1);
            turnUp(ori);

        } else if (face == 'D') {
            if (ori == '-')
                turnFaceAntiClockWise(3);
            else if (ori == '+')
                turnFaceClockWise(3);
            turnDown(ori);

        } else if (face == 'F') {
            if (ori == '-')
                turnFaceAntiClockWise(2);
            else if (ori == '+')
                turnFaceClockWise(2);

            turnFront(ori);

        } else if (face == 'B') {
            if (ori == '-')
                turnFaceAntiClockWise(0);
            else if (ori == '+')
                turnFaceClockWise(0);
            turnBack(ori);

        } else if (face == 'L') {
    
            if (ori == '-')
                turnFaceAntiClockWise(4);
            else if (ori == '+')
                turnFaceClockWise(4);
            turnLeft(ori);

        } else if (face == 'R') {
            if (ori == '-')
                turnFaceAntiClockWise(5);
            else if (ori == '+')
                turnFaceClockWise(5);
            turnRight(ori);
        }

    }

    static void turnLeft(char ori) {

        // clockwise
        char temp[] = {cube[0][0][0], cube[0][1][0], cube[0][2][0]};
        if (ori == '+') {
            cube[0][2][0] = cube[3][2][0];
            cube[0][1][0] = cube[3][1][0];
            cube[0][0][0] = cube[3][0][0];

            cube[3][2][0] = cube[2][2][0];
            cube[3][1][0] = cube[2][1][0];
            cube[3][0][0] = cube[2][0][0];

            cube[2][2][0] = cube[1][2][0];
            cube[2][1][0] = cube[1][1][0];
            cube[2][0][0] = cube[1][0][0];

            cube[1][2][0] = temp[2];
            cube[1][1][0] = temp[1];
            cube[1][0][0] = temp[0];
        }
        
        // alter-clockwise
        else if (ori == '-') {

            cube[0][2][0] = cube[1][2][0];
            cube[0][1][0] = cube[1][1][0];
            cube[0][0][0] = cube[1][0][0];

            cube[1][2][0] = cube[2][2][0];
            cube[1][1][0] = cube[2][1][0];
            cube[1][0][0] = cube[2][0][0];

            cube[2][2][0] = cube[3][2][0];
            cube[2][1][0] = cube[3][1][0];
            cube[2][0][0] = cube[3][0][0];

            cube[3][0][0] = temp[0];
            cube[3][1][0] = temp[1];
            cube[3][2][0] = temp[2];
        }
    }

    static void turnRight(char ori) {

        // clockwise
        char temp[] = {cube[1][2][2], cube[1][1][2], cube[1][0][2]};
        if (ori == '+') {
            cube[1][2][2] = cube[2][2][2];
            cube[1][1][2] = cube[2][1][2];
            cube[1][0][2] = cube[2][0][2];

            cube[2][0][2] = cube[3][0][2];
            cube[2][1][2] = cube[3][1][2];
            cube[2][2][2] = cube[3][2][2];

            cube[3][0][2] = cube[0][0][2];
            cube[3][1][2] = cube[0][1][2];
            cube[3][2][2] = cube[0][2][2];

            cube[0][0][2] = temp[2];
            cube[0][1][2] = temp[1];
            cube[0][2][2] = temp[0];
        }
        
        // alter-clockwise
        else if (ori == '-') {

            cube[1][2][2] = cube[0][2][2];
            cube[1][1][2] = cube[0][1][2];
            cube[1][0][2] = cube[0][0][2];

            cube[0][2][2] = cube[3][2][2];
            cube[0][1][2] = cube[3][1][2];
            cube[0][0][2] = cube[3][0][2];

            cube[3][2][2] = cube[2][2][2];
            cube[3][1][2] = cube[2][1][2];
            cube[3][0][2] = cube[2][0][2];

            cube[2][2][2] = temp[0];
            cube[2][1][2] = temp[1];
            cube[2][0][2] = temp[2];

        }
    }

    static void turnUp(char ori) {

        // clockwise
        char temp[] = {cube[0][2][0], cube[0][2][1], cube[0][2][2]};
        if (ori == '+') {

            cube[0][2][0] = cube[4][2][2];
            cube[0][2][1] = cube[4][1][2];
            cube[0][2][2] = cube[4][0][2];

            cube[4][0][2] = cube[2][0][0];
            cube[4][1][2] = cube[2][0][1];
            cube[4][2][2] = cube[2][0][2];

            cube[2][0][0] = cube[5][2][0];
            cube[2][0][1] = cube[5][1][0];
            cube[2][0][2] = cube[5][0][0];

            cube[5][0][0] = temp[0];
            cube[5][1][0] = temp[1];
            cube[5][2][0] = temp[2];
        }
        
        // alter-clockwise
        else if (ori == '-') {
            
            cube[0][2][0] = cube[5][0][0];
            cube[0][2][1] = cube[5][1][0];
            cube[0][2][2] = cube[5][2][0];

            cube[5][0][0] = cube[2][0][2];
            cube[5][1][0] = cube[2][0][1];
            cube[5][2][0] = cube[2][0][0];

            cube[2][0][2] = cube[4][2][2];
            cube[2][0][1] = cube[4][1][2];
            cube[2][0][0] = cube[4][0][2];

            cube[4][2][2] = temp[0];
            cube[4][1][2] = temp[1];
            cube[4][0][2] = temp[2];

        }

    }

    static void turnDown(char ori) {

         // clockwise
         char temp[] = {cube[2][2][0], cube[2][2][1], cube[2][2][2]};
         if (ori == '+') {
 
             cube[2][2][2] = cube[4][2][0];
             cube[2][2][1] = cube[4][1][0];
             cube[2][2][0] = cube[4][0][0];
 
             cube[4][2][0] = cube[0][0][0];
             cube[4][1][0] = cube[0][0][1];
             cube[4][0][0] = cube[0][0][2];
 
             cube[0][0][0] = cube[5][0][2];
             cube[0][0][1] = cube[5][1][2];
             cube[0][0][2] = cube[5][2][2];
 
             cube[5][0][2] = temp[2];
             cube[5][1][2] = temp[1];
             cube[5][2][2] = temp[0];
         }
         
         // alter-clockwise
         else if (ori == '-') {
             
            cube[2][2][0] = cube[5][2][2];
            cube[2][2][1] = cube[5][1][2];
            cube[2][2][2] = cube[5][0][2];

            cube[5][2][2] = cube[0][0][2];
            cube[5][1][2] = cube[0][0][1];
            cube[5][0][2] = cube[0][0][0];

            cube[0][0][2] = cube[4][0][0];
            cube[0][0][1] = cube[4][1][0];
            cube[0][0][0] = cube[4][2][0];

            cube[4][0][0] = temp[0];
            cube[4][1][0] = temp[1];
            cube[4][2][0] = temp[2];
 
         }
    }

    static void turnFront(char ori) {

        // clockwise
        char temp[] = {cube[1][2][0], cube[1][2][1], cube[1][2][2]};
        if (ori == '+') {
            
            cube[1][2][2] = cube[4][2][2];
            cube[1][2][1] = cube[4][2][1];
            cube[1][2][0] = cube[4][2][0];

            cube[4][2][2] = cube[3][0][0];
            cube[4][2][1] = cube[3][0][1];
            cube[4][2][0] = cube[3][0][2];

            cube[3][0][0] = cube[5][2][2];
            cube[3][0][1] = cube[5][2][1];
            cube[3][0][2] = cube[5][2][0];

            cube[5][2][2] = temp[2];
            cube[5][2][1] = temp[1];
            cube[5][2][0] = temp[0];
        }
        
        // alter-clockwise
        else if (ori == '-') {

            cube[1][2][0] = cube[5][2][0];
            cube[1][2][1] = cube[5][2][1];
            cube[1][2][2] = cube[5][2][2];

            cube[5][2][0] = cube[3][0][2];
            cube[5][2][1] = cube[3][0][1];
            cube[5][2][2] = cube[3][0][0];

            cube[3][0][2] = cube[4][2][0];
            cube[3][0][1] = cube[4][2][1];
            cube[3][0][0] = cube[4][2][2];

            cube[4][2][0] = temp[0];
            cube[4][2][1] = temp[1];
            cube[4][2][2] = temp[2];
        }
    }

    static void turnBack(char ori) {

        char temp[] = {cube[1][0][2], cube[1][0][1], cube[1][0][0]};
        if (ori == '+') {
            

            cube[1][0][0] = cube[5][0][0];
            cube[1][0][1] = cube[5][0][1];
            cube[1][0][2] = cube[5][0][2];

            cube[5][0][0] = cube[3][2][2];
            cube[5][0][1] = cube[3][2][1];
            cube[5][0][2] = cube[3][2][0];

            cube[3][2][2] = cube[4][0][0];
            cube[3][2][1] = cube[4][0][1];
            cube[3][2][0] = cube[4][0][2];

            cube[4][0][0] = temp[2];
            cube[4][0][1] = temp[1];
            cube[4][0][2] = temp[0];
        }
        
        // alter-clockwise
        else if (ori == '-') {

            cube[1][0][0] = cube[4][0][0];
            cube[1][0][1] = cube[4][0][1];
            cube[1][0][2] = cube[4][0][2];

            cube[4][0][2] = cube[3][2][0];
            cube[4][0][1] = cube[3][2][1];
            cube[4][0][0] = cube[3][2][2];

            cube[3][2][0] = cube[5][0][2];
            cube[3][2][1] = cube[5][0][1];
            cube[3][2][2] = cube[5][0][0];

            cube[5][0][2] = temp[0];
            cube[5][0][1] = temp[1];
            cube[5][0][0] = temp[2];
        }
    }

    static void printResult() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(cube[1][i][j]);
                }
                System.out.println();
            }
    }

    static void printing() {
        for (int k = 0; k < 6; k++) {
        System.out.println(k);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[k][i][j]);
            }
            System.out.println();
        }
    }
}

    static void turnFaceClockWise(int index) {
        cubeTemp = new char[3][3];

        cubeTemp[0][0] = cube[index][2][0];
        cubeTemp[0][1] = cube[index][1][0];
        cubeTemp[0][2] = cube[index][0][0];
        cubeTemp[1][0] = cube[index][2][1];
        cubeTemp[1][1] = cube[index][1][1];
        cubeTemp[1][2] = cube[index][0][1];
        cubeTemp[2][0] = cube[index][2][2];
        cubeTemp[2][1] = cube[index][1][2];
        cubeTemp[2][2] = cube[index][0][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[index][i][j] = cubeTemp[i][j];
            }
        }
    }

    static void turnFaceAntiClockWise(int index) {
        cubeTemp = new char[3][3];

        cubeTemp[0][0] = cube[index][0][2];
        cubeTemp[0][1] = cube[index][1][2];
        cubeTemp[0][2] = cube[index][2][2];
        cubeTemp[1][0] = cube[index][0][1];
        cubeTemp[1][1] = cube[index][1][1];
        cubeTemp[1][2] = cube[index][2][1];
        cubeTemp[2][0] = cube[index][0][0];
        cubeTemp[2][1] = cube[index][1][0];
        cubeTemp[2][2] = cube[index][2][0];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[index][i][j] = cubeTemp[i][j];
            }
        }
    }
    
}