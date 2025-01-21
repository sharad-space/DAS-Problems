public class MinSpaceWastedKResizing {
    static int max=0;
    public static int maxProduct(String s) {
        char[] ch =s.toCharArray();
        dfs(ch,0,"","");
                return max;
            }
            
        
    private static void dfs(char[] ch, int i, String s1, String s2) {
        if(i>=ch.length) {
            if(isPalin(s1) &&isPalin(s2)){
                    max=Math.max(max, s1.length()*s2.length());
                }
            return;
            }
            dfs(ch, i+1, s1+ch[i], s2);
            dfs(ch, i+1, s1, s2+ch[i]);
            dfs(ch, i+1, s1, s2);

    }
                    
                    
    private static boolean isPalin(String str) {
        int i=0,j=str.length()-1;
        while (i<j) {
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;        
                
    }
            
            
    public static void main(String[] args) {
        System.out.println(maxProduct("bb"));
        
    }
    
}
