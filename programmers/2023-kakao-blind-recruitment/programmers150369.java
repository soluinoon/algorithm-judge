class Solution {
    static int index;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        index = n - 1;
        
        // 처음 00인 부분 제거
        while (index > 0 && deliveries[index] == 0 && pickups[index] == 0) {
            index--;
        }
        if (index == 0) {
            if (deliveries[index] == 0 && pickups[index] == 0) {
                return 0;
            } else {
                return 2;
            }
        }
        
        // 로직
        long cost = 0;
        while (index >= 0) {
            // System.out.println("현재 인덱스 : " + index);
            int deliveryEndpoint = delivery(cap, deliveries);
            int pickupEndpoint = pickup(cap, pickups);
            
            // 실제 인덱스 보정
            cost += (index + 1) * 2;
            
            index = Math.max(deliveryEndpoint, pickupEndpoint);
            if (index == 0 && deliveries[index] == 0 && pickups[index] == 0) {
                break;
            } 
        }
        
        return cost;
    }
    
    public int delivery(int cap, int[] deliveries) {
        int endpoint = index;
        
        while (endpoint >= 0 && cap >= 0) {
            int capTemp = cap;
            
            cap -= deliveries[endpoint];
            // System.out.println("딜리버리 캡 갱신 : " + cap);
            
            deliveries[endpoint] = Math.max(0, deliveries[endpoint] - capTemp);
            // System.out.println("딜리버리 갱신 : " + endpoint + "-" + deliveries[endpoint]);
            if (cap < 0) {
                return endpoint;
            }
            endpoint--;
        }
        return endpoint;
    }
    
    public int pickup(int cap, int[] pickups) {
        int endpoint = index;
        
        while (endpoint >= 0 && cap >= 0) {
            int capTemp = cap;
            
            cap -= pickups[endpoint];
            // System.out.println("픽업 캡 갱신 : " + cap);
            
            pickups[endpoint] = Math.max(0, pickups[endpoint] - capTemp);
            // System.out.println("픽업 갱신 : " + endpoint + "-" + pickups[endpoint]);

            if (cap < 0) {
                return endpoint;
            }
            endpoint--;
        }
        return endpoint;
    }
}
