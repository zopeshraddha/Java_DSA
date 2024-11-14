package com.demo.java.dsa.samples;

public class LinkMain {
	public int key;
	   public int data;
	   public LinkMain next;

	   public LinkMain(int key, int data){
	      this.key = key;
	      this.data = data;
	   }

	   public void display(){
	      System.out.print("{"+key+","+data+"}");
	   }
}
