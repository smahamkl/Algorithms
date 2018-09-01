package examples.collections.linkedlist;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class LinkedList1 {
	
	 public static void main(String args[]) 
     {
         LinkedList list = new LinkedList();
         list.add(new Integer(2));
         list.add(new Integer(8));
         list.add(new Integer(5));
         list.add(new Integer(1));
         Iterator i = list.iterator();
         Collections.reverse(list);
         //Collections.sort(list);
         Collections.shuffle(list);
         
	    while(i.hasNext())
	        System.out.print(i.next() + " ");
	    
	    AnotherMethod();
	    
	    HasSetSample();
	    
	    TreeSetSample();
     }
	 
     public static void AnotherMethod() 
     {
         LinkedList obj = new LinkedList();
         obj.add("A");
         obj.add("B");
         obj.add("C");
         obj.addFirst("D");
         obj.removeFirst();
         
         System.out.println(obj);
     }
     
     public static void HasSetSample() 
     {
        HashSet obj1 = new HashSet();
        obj1.add("3");
        obj1.add("9");
        obj1.add("1");
        obj1.add("4");
        obj1.add("8");
         
         System.out.println(obj1 + " " + obj1.size());
     }
     
     public static void TreeSetSample() 
     {
        TreeSet obj = new TreeSet();
         obj.add("3");
         obj.add("9");
         obj.add("1");
         obj.add("4");
         obj.add("8");
         
         System.out.println(obj + " " + obj.size());
     }
     
     
}
