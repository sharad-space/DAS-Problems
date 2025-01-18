public class Comsumer extends Thread {

Company c;
Comsumer(Company c){
this.c=c;

}

public void run(){
    while (true) {
        this.c.consume_item();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
}
