package com.app.controller;

public class TestClass {
	
	public static void main(String args[]) {
		A a=new A();
		B b =new B();
		A c=new B();
		// B d=new A();
		c.show();
		System.out.println(a.i);
		System.out.println(b.i);
		System.out.println(c.i);
	}

}

class A{	
	Integer i=5;
	
	public static void show() {
		System.out.println("Parent");
	}
}

class B extends A{	
	Integer i=20;
	
	public static void show() {
		System.out.println("Child show");
	}
	
	public void show1() {
		System.out.println("Child show 1");
	}
	
}
