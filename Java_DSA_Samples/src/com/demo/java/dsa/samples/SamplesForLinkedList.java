package com.demo.java.dsa.samples;

import java.util.LinkedList;

public class SamplesForLinkedList {
	public static void main(String[] args) {
		 LinkedList<String> lList = new LinkedList<String>();
	      lList.add("1");
	      lList.add("2");
	      lList.add("3");
	      lList.add("4");
	      lList.add("5");
	      System.out.println("LinkedList is : " +lList);
	      lList.subList(2, 4).clear();
	      System.out.println("LinkedList is : " +lList);
	   }
	
	private LinkMain first;

	   // create an empty linked list 
	   public SamplesForLinkedList(){
	      first = null;
	   }
	 //insert link at the first location
	   public void insertFirst(int key, int data){
	      //create a link
	      LinkMain link = new LinkMain(key,data);
	      //point it to old first node
	      link.next = first;
	      //point first to new first node
	      first = link;
	      System.out.println("LinkedList - InsertFirst : "+first);
	   }

	   //delete first item
	   public LinkMain deleteFirst(){
	      //save reference to first link
	      LinkMain tempLink = first;
	      //mark next to first link as first 
	      first = first.next;
	      //return the deleted link
	      return tempLink;
	   }

	   //display the list
	   public void display(){
	      //start from the beginning
	      LinkMain current = first;
	      //navigate till the end of the list
	      System.out.print("***[ ");
	      while(current != null){
	         //print data
	         current.display();
	         //move to next item
	         current = current.next;
	         System.out.print(" ");
	      }
	      System.out.print(" ]");
	   }

	   //find a link with given key
	   public LinkMain find(int key){
	      //start from the first link
	      LinkMain current = first;

	      //if list is empty
	      if(first == null){
	         return null;
	      }
	      //navigate through list
	      while(current.key != key){
	         //if it is last node
	         if(current.next == null){
	            return null;
	         }else{
	            //go to next link
	            current = current.next;
	         }
	      }      
	      //if data found, return the current Link
	      return current;
	   }

	   //delete a link with given key
	   public LinkMain delete(int key){
	      //start from the first link
	      LinkMain current = first;
	      LinkMain previous = null;
	      //if list is empty
	      if(first == null){
	         return null;
	      }

	      //navigate through list
	      while(current.key != key){
	         //if it is last node
	         if(current.next == null){
	            return null;
	         }else{
	            //store reference to current link
	            previous = current;
	            //move to next link
	            current = current.next;             
	         }
	      }

	      //found a match, update the link
	      if(current == first) {
	         //change first to point to next link
	         first = first.next;
	      }else {
	         //bypass the current link
	         previous.next = current.next;
	      }    
	      return current;
	   }


	   //is list empty
	   public boolean isEmpty(){
	      return first == null;
	   }
	   
	   public int length(){
	      int length = 0;
	      for(LinkMain current = first; current!=null;
	         current = current.next){
	         length++;
	      }
	      return length;
	   }
	   
	   public void sort(){
	      int i, j, k, tempKey, tempData ;
	      LinkMain current,next;
	      int size = length();
	      k = size ;
	      for ( i = 0 ; i < size - 1 ; i++, k-- ) {
	         current = first ;
	         next = first.next;
	         for ( j = 1 ; j < k ; j++ ) {            
	            if ( current.data > next.data ) {
	               tempData = current.data ;
	               current.data = next.data;
	               next.data = tempData ;
		 
		           tempKey = current.key;
		           current.key = next.key;
		           next.key = tempKey;
	            }
	            current = current.next;
	           next = next.next;                        
	         }
	      }
	   }

	   public SamplesForLinkedList reverse() { 
		   SamplesForLinkedList reversedlist = new SamplesForLinkedList();
	      LinkMain nextLink = null;     
	      reversedlist.insertFirst(first.key, first.data);

	      LinkMain currentLink = first;       
	      // Until no more data in list, 
	      // insert current link before first and move ahead.
	      while(currentLink.next != null){
	         nextLink = currentLink.next;           
	         // Insert at start of new list.
	         reversedlist.insertFirst(nextLink.key, nextLink.data); 
	         //advance to next node
	         currentLink = currentLink.next;            
	      }      
	      return reversedlist;
	   }

	   public void concatenate(SamplesForLinkedList list){
	      if(first == null){
	         first = list.first;
	      }
	      if(list.first == null){
	         return;
	      }
	      LinkMain temp = first;

	      while(temp.next !=null) {
	         temp = temp.next;
	      }
	      temp.next = list.first;       
	   }
}
