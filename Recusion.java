import java.util.Arrays;

public class Recusion {
   static int count=0;
    static void print(){
       
        System.out.println("Recursion..."+ count++ );
      
    }

    static int sum(int n){
        if (n==0) {
            return 0;
        }

        return n+sum(n-1);
    }

    static  String word="a";
    public static char kthCharacter(int k) {
       
        int n=word.length();
        if(n>=k) return word.charAt(k-1);
        for (int i = 0; i < n; i++) {
            word+=(char)(word.charAt(i)+1);
            
        }
  

        return kthCharacter(k);

        
    }

    public static char findKthBit(int n, int k) {
        int len=(int)Math.pow(2, n)-1;

        return recu(len, k);
        
    }
    public static char recu(int len,int k){

        if (len==1) {
            return '0';
        }
        int half=len/2;
        int mid=half+1;
        if (mid==k) {
            return '1';
        }else if (k<mid) {
           return recu(half, k);
        }else{
            char ans=recu(half, 1+len-k);
            return (ans=='0')?'1':'0'; 
           
        }
    }

    public static void reverseArray(int[] arr){
        int left=0, right=arr.length-1;
        while (left<=right) {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArrayUsingRec(int[] arr,int i,int n){
        
        if (i>=n/2) {
            return;
        }
        int temp=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        reverseArrayUsingRec(arr, i+1, n);
                
    }

    public static boolean checkingPolldromeUsingRec(String str,int i,int n){
        if (i>=n/2)  return true;
            
        if (str.charAt(i)!=str.charAt(n-i-1)) {
           return false;
        }
    

        return checkingPolldromeUsingRec(str,i+1,n);
    }
    
    static int mod=1000000007;
    public  static int monkeyMove(int n) {
        
        return (int)((pow(2, n)-2)+mod)%mod;
                
            }
                    
                
                
                
            
    private static int pow(int x, int y) {
                int res=1;
                while (y>0) {
                    if(y%2==1){
                        res=(res*x)%mod;
                    }
                    x=(x*x)%mod;
                    y=y/2;
                }
                return res;
        }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color==image[sr][sc]) {
            return image;
        }
        DFS(image,sr,sc,color,image[sr][sc]);
         return image;
        }
                    
            private static void DFS(int[][] image, int row, int col, int newcolor, int oldcolor) {
                if(row>=image.length || row<0 || col>=image[0].length || col<0 || image[row][col]!=oldcolor) return;
                image[row][col]=newcolor;
                DFS(image, row-1, col, newcolor, oldcolor);
                DFS(image, row+1, col, newcolor, oldcolor);
                DFS(image, row, col-1, newcolor, oldcolor);
                DFS(image, row, col+1, newcolor, oldcolor);
            }

            public boolean isToeplitzMatrix(int[][] matrix) {
                int element=matrix[0][0];
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        if(i==j && matrix[i][j]!=element) return false;
                    }
                    
                }

                return true;
        
            }
        
            public static void main(String[] args) {
    
        System.out.println(monkeyMove(4));
    



}
}
