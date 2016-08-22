package com.jbilling.framework.pageclasses;

public final class Test {

	public static void main(String[] args) {

		System.out.println("inside Main Method");
	}

	public static void mainOne(String[] args) {
		System.out.println("inside MainOne Method");
	}

	public static void staticOne() {
		System.out.println("inside staticOne Method");
	}

	static {

		System.out.println("inside staticTwo Method");

	}

	public void add() {
		int a = 1;
		int b = 2;
		int c = a + b;
		System.out.println("Adding" + c);
	}
}
