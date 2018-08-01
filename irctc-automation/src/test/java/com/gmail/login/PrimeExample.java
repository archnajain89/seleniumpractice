package com.gmail.login;

public class PrimeExample {
	public static void main(String args[]) {
		int i, flag = 0;
		int n = 3;// it is the number to be checked
		//System.out.println(m);
		for (i = 2; i <= n/2; i++) {
				if (n % i == 0) {
					System.out.println(n + " is not a prime number");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(n + " is prime number");
			}
		} // end of else
	}
