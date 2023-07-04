class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ptr = 0;
        int turbulent = 0;
        int prev = arr[0];
        int upCount = 0;
        int downCount = 0;

        while (true) {
            ptr++;
            if (ptr == arr.length) {
                break;
            }
            System.out.println("ptr = " + ptr);
            // even
            if (ptr % 2 == 0) {
                if (prev < arr[ptr]) {
                    downCount++;
                    upCount = 0;
                } else if (prev > arr[ptr]){
                    upCount++;
                    downCount = 0;
                } else {
                    upCount = 0;
                    downCount = 0;
                }
            }
            // odd 
            else {
                if (prev > arr[ptr]) {
                    downCount++;
                    upCount = 0;
                } else if (prev < arr[ptr]){
                    upCount++;
                    downCount = 0;
                } else {
                    upCount = 0;
                    downCount = 0;
                }
            }
            if (upCount > turbulent) {
                turbulent = upCount;
                System.out.println("up update");
            }
            if (downCount > turbulent) {
                turbulent = downCount;
                System.out.println("down update");
            }
            prev = arr[ptr];
        }
        return turbulent + 1;
    }
}
