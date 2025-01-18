public class Expections {

    public static void main(String[] args) {
        int[] arr=new int[5];
        System.out.println("Hello guys");
        // try {
        //     int a=3/0;
        //     System.out.println(arr[0]);
        
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     System.exit(0);
        // }finally{
        //     System.out.println("Namasate India...");
        // }
        // System.out.println("Bye guys");
        try {
            getNum(arr);
        } catch (Exception e) {
           System.out.println("Expection is catched");
        }
    
    }

    static int getNum(int[] arr) throws ArithmeticException{
        return arr[9];
    }

}
