import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
        // Fail-fas and fail-safe iterator
        // ArrayList<Integer> list=new ArrayList<>();
        List<Integer> list=new CopyOnWriteArrayList();
        list.add(1000);
        list.add(2000);
        list.add(3000);
      Iterator<Integer> it=list.iterator();
      while (it.hasNext()) {
        System.out.println("Element :"+ it.next());
        list.add(4000);
      }

      Iterator<Integer> itr=list.iterator();
      while (itr.hasNext()) {
        System.out.println("Element :"+ itr.next());
       
      }
  
  


    }

}
