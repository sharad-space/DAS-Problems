public class Mail {
    public static void main(String[] args) {
        Company comp=new Company();
        Producer p=new Producer(comp);
        Comsumer c=new Comsumer(comp);
        p.start();
        c.start();
    }

}
