package lo02td4;
import java.util.*;


public class TestCollections {
	 public static void main(String[] args) {
	       Set<Integer> myHashSet ;
           myHashSet = new HashSet<Integer>();
           Set<Integer> newHashSet= new HashSet<Integer>();
           List<Integer> myArrayList;
           myArrayList = new ArrayList<Integer>();
           Map<Integer,Integer> myMap;
           myMap = new HashMap<Integer,Integer>();
           
           Integer a = new Integer(1);
           Integer b = new Integer(3);
           Integer c = new Integer(8);
           Integer d = new Integer(18);
           
           myHashSet.add(a);
           myHashSet.add(b);
           myHashSet.add(c);
           myHashSet.add(d);
           myHashSet.add(80);
           System.out.println(myHashSet);
           
           newHashSet.add(a);
           newHashSet.add(90);
           myHashSet.addAll(newHashSet);
           System.out.println(newHashSet);
           System.out.println(myHashSet);
           
           myArrayList.add(a);
           myArrayList.add(2);
           myArrayList.add(a);
           myArrayList.add(b);
           myArrayList.add(80);
           System.out.println(myArrayList);
           
           myMap.put(0,a);
           myMap.put(1,b);
           myMap.put(5,c);
           System.out.println(myMap);
                      
           Iterator<Integer> it = myArrayList.iterator();
           while(it.hasNext()) {
        	   System.out.println("L'element prochain est  " + it.next());
           }
           
           System.out.println("toArray " + myArrayList.toArray());
	 }
}
