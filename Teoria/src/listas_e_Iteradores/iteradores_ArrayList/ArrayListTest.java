package listas_e_Iteradores.iteradores_ArrayList;

import java.util.Iterator;



public class ArrayListTest {
  public static void main(String[] args) {
          ArrayList<String> c1= new ArrayList<String>();
          c1.add(0,"Red");
          c1.add(1,"Green");
          c1.add(2,"Black");
          c1.add(3,"White");
          c1.add(4,"Pink");
          System.out.println("Original array list: " + c1);
          System.out.println("Checking the above array list is empty or not! "+c1.isEmpty());
          Iterator<String> it1 = c1.iterator();
          Iterator<String> it2 = c1.iterator();
          while (it1.hasNext()){
              String tmp = it1.next();
              System.out.println("Color:"+tmp);
          }
         
          while (it2.hasNext()){
              it2.next();
              it2.remove();
          }
          System.out.println("Array list after remove all elements "+c1);   
          System.out.println("Checking the above array list is empty or not! "+c1.isEmpty());
   }
}