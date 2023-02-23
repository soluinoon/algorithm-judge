import java.util.*;

class Solution {
    static int camera = 0;
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        
        int index = 0;
        while (true) {
            if (index >= routes.length || index == -1) {
                break;
            }
            index = getLowerCar(index, routes);
        }
        
        return camera;
    }
    
    private int getLowerCar(int startIndex, int[][] routes) {
        if (startIndex >= routes.length) {
            return -1;
        }
        int endIndex = startIndex;
        int endRoute = routes[startIndex][1];
        
        while (endIndex < routes.length && routes[endIndex][0] <= endRoute) {
            endIndex++;
        }
        camera++;
        return endIndex;
    }
}
