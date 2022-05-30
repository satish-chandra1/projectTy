package com.crm.practice;

import org.testng.reporters.jq.Main;

public interface A {
public void m();
public void m1();
}
class B implements A{

	@Override
	public void m() {
		System.out.println("Hi");
		
	}

	@Override
	public void m1() {
		System.out.println("Hello");
		
	}
	public static void main(String[] args) {
		A a=new B();
		
		B b=(B)a;
		
	}

}
