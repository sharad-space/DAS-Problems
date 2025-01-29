public class HouseRobber {
    public static int rob(int[] nums) {
        int ans=0;
        // [2,3,2,5,6]
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return nums[0]>=nums[1]?nums[0]:nums[1];
        if(n==3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int firstHouse=solve(nums,0,n-2);
        int lastHouse=solve(nums,1,n-1);
        return Math.max(firstHouse, lastHouse);
                
    }
        
        private static int solve(int[] nums, int i, int j) {
                int first=nums[i];
                int second=Math.max(first,nums[i+1]);
                int maxLoot=0;
                for (int k = i+2; k <=j; k++) {
                    maxLoot=Math.max(first+nums[i], second);
                    first=second;
                    second=maxLoot;
                    
                }

            return maxLoot;    
        }
        
            public static void main(String[] args) {
        int[] arr={2,3,2,5,6};
        System.out.println(rob(arr));
    }
    
}
