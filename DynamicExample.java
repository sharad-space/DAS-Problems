public class DynamicExample {
    public static int facc(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        
        return dp[n]=facc(n-1, dp)+facc(n-2, dp);

    }

    // using tablation approach
    public static int f(int n,int[] dp){
        if(n<=1) return n;
        for (int i = 2; i <=n; i++) {
            dp[i]=f(i-1,dp)+f(i-2,dp);
        }
    return dp[n];
    }

    public static long maxPoints(int[][] points) {
       long maxPoints=0;
       long[][] dp=new long[points.length][points[0].length];
       for (int i = 0; i < points[0].length; i++) {
            dp[0][i]=points[0][i];
       }
       for (int i = 1; i <points.length; i++) {
        for (int j = 0; j < points[0].length; j++) {
            long max=0;
            for (int k = 0; k <points[0].length; k++) {
                max=Math.max(max, dp[i-1][k]-Math.abs(j-k));
                
            }
            dp[i][j]=max+points[i][j];
            
        }
        
       }

       for (int i = 0; i < dp[dp.length-1].length; i++) {
        maxPoints=Math.max(maxPoints, dp[dp.length-1][i]);

        
       }
        return maxPoints;
        
    }

    public int minDistance(String word1, String word2) {
        if(word1.length()==0 && word2.length()==0) return 0;
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();
        if(word1.charAt(0)==word2.charAt(0)) return minDistance(word1.substring(1), word2.substring(1));
        int insert=1+minDistance(word1, word2.substring(1));
        int delete=1+minDistance(word1.substring(1), word2);
        int replace=1+minDistance(word1.substring(1), word2.substring(1));

        return Math.max(insert, Math.max(replace, delete));

        
    }

    public static int getMaxPathSum(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxi=Math.max(maxi, solve(n-1,i,matrix));
        }

        return maxi;
    }
            
        
    private static int solve(int i, int j, int[][] matrix) {

            if(j<0 || j>=matrix[0].length) return Integer.MIN_VALUE;
            if(i==0) return matrix[0][j];
            
            int u=matrix[i][j]+solve(i-1, j, matrix);
            int ld=matrix[i][j]+solve(i-1, j-1, matrix);
            int rd=matrix[i][j]+solve(i-1, j+1, matrix);

            return Math.max(u, Math.max(ld, rd));
    }
        
    public static void main(String[] args) {
        
        // int[] dp=new int[11];
        int prev=1;
        int prev1=0;
        for (int i = 2; i <1; i++) {
            int curr=prev+prev1;
            prev1=prev;
            prev=curr;
        }

        System.out.println(prev);
        

        
    }


}
