public class MaxCompatibilitySum {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] b=new boolean[mentors.length];
        
        return dfs(students,mentors,b,0 );
            }
        
        
    private int dfs(int[][] students, int[][] mentors, boolean[] b, int index) {
            int sum=0;
            if(index==students.length) return 0;
            for (int i = 0; i < mentors.length; i++) {
                    if(b[i]) continue;
                    int s=0;
                    for (int j = 0; j < mentors[0].length; j++) {
                        if(students[index][j]==mentors[i][j]) s++;
                    }
                    b[i]=true;
                    sum=Math.max(sum, s+dfs(students, mentors, b, index+1));
                    b[i]=false;
            }
            return sum;
            

        
    }
            public static void main(String[] args) {
        
    }
    
}
