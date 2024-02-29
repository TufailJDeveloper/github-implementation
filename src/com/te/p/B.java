package com.te.p;

public class B extends A{
	int i;
	void childMethod() {
		System.out.println("B method");
	}
	void callParent() {
		super.parentM();
	}

}
