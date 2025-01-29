import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxTaxiEarnings {

    public long getDescentPeriods(int[] prices) {
        long[] dp=new long[prices.length];
        dp[0]=1;
        long ans=1, temp=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-prices[i]==1){
               dp[i]=dp[i-1]+1;
               
            }else{
                dp[i]=1;
            }
            ans+=dp[i];
        }

        return ans;
        
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        long ans=0L;
        Map<Integer,List<int[]>> map=new HashMap<>();
        for (int[] ride : rides) {
            List<int[]> values=map.get(ride[1]);
            if(values==null){
                values=new ArrayList<>();
                map.put(ride[1], values);
            }
            values.add(ride);
        }
           
            long[] dp=new long[n+1];
            for (int i = 2; i <=n; i++) {
                List<int[]> value=map.get(i);
                if(value!=null){
                    long earning=0;
                    for (int[] earn : value) {
                        earning=Math.max(earning, (earn[1]-earn[0]+earn[2]+dp[earn[0]]));
                        
                    }
                    dp[i]=earning;
                }
                dp[i]=Math.max(dp[i], dp[i-1]);
            }

        
        
         return dp[n];
    }

    

    public static void main(String[] args) {
        int[][] rides = {{1,6,1},
                        {3,10,2},
                        {10,12,3},
                        {11,12,2},
                        {12,15,2},
                        {13,18,1}};
        int n=20;

        System.out.println(maxTaxiEarnings(n, rides));

    }
}
