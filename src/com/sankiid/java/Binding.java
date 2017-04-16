package com.sankiid.java;

class A {
	public void method() {
		System.out.println("A");
	}
}

class B extends A {
	public void method() {
		System.out.println("B");
	}
}

public class Binding {

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println();
		a.method();
	}
}
