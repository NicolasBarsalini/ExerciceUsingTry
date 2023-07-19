package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	
		System.out.println("Enter the account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.println(account);
			
		System.out.print("Enter a amount to withdraw: ");
		
		try {
			account.withdraw(sc.nextDouble());
			System.out.println("New balance: " + account.getBalance());
		}
		
		catch(DomainException e) {
			System.out.println("Withdraw error:" + e.getMessage());
		}
		
		sc.close();
		
	}

}
