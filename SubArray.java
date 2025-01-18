import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SubArray {

    public static void main(String[] args) {
        String s = "10101";
        int k = 1;
        System.out.println(countKConstraintSubstrings(s,k));
        
    }

    // Input: nums = [1,1,2,2,3,4,2,3], k = 6, x =  2

    // Output: [6,10,12]
    
    public static int[] findXSum(int[] nums, int k, int x) {

        int[] ans=new int[4];
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        int right=0,left=0,sum=0,n=nums.length;
        while (right<n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            if (right-left+1==k) {
                list2=new ArrayList<>();
            for (Integer elem : map.values()){
                list1.add(elem);
            
            }
            Collections.sort(list1);
            int size=list1.size()-1;
            for(int i=0;i<x;i++){
                list2.add(list1.get(size--));
            }
            left++;
            }
        right++;
        System.out.println(list2);

        }


        

        return ans;
        
    }

    public static int countKConstraintSubstrings(String s, int k) {
        // s = "10101", k = 1
        int ans=0;
        int n=s.length();
        for (int i = 0; i <n; i++) {
        int countOne=0,countZero=0;
     
        for (int j = i; j <n; j++) {
            if (s.charAt(j)=='1') {
                countOne++;
            }else{
                countZero++;
            }
            if (countOne<=k || countZero<=k) {
                ans++;
            }
            
        }  
        
    }

    return ans;
    }

}

