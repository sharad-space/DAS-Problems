public class MyThread implements Runnable {

    public static void main(String[] args) {
        MyThread t=new MyThread();
        
        Thread thread=new Thread(t);
        thread.start();
    }
    
    public void run() {
        for (int i = 0; i <=10; i++) {
            System.out.println("The value of i "+i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        
    }


}

