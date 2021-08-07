package Method2;

import java.util.Scanner;

public class Converter2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to converter program! "
				+ "\n You can convert a number from decimal to binary and vise-versa");
		System.out.println("Enter a choosen option in number form");
		System.out.println("1. From decimal to binary");
		System.out.println("2. From binary to decimal");
		int option = 0;
		option = scanner.nextInt();
		while(option != 1 && option != 2) {
			System.out.println("Please enter a correct option number");
			option = scanner.nextInt();
		}
		
		if(option == 1) {
			System.out.println("Enter a number that you want to convert (up to 34359738367)");
			int number = scanner.nextInt();
			ConvertToBinary obj1 = new ConvertToBinary(number);
		} else {
			System.out.println("Enter a binary a number that you want to convert");
			int number = scanner.nextInt();
			ConvertFromBinary obj1 = new ConvertFromBinary(number);
		}
	}

}

class ConvertToBinary {
	private int orig_dec = 0;
	ConvertToBinary(int number) {
		orig_dec = number;
		findBytes(number);
	}
	
	private void findBytes(int dec) {
		int temp_dec = dec;
		int remainder [] = new int[findMaxHalfDivision(dec)];
		int j = 0;
		do {
			remainder[j] = temp_dec % 2;
			temp_dec /= 2;
			j++;
		}
		while (temp_dec / 2 != 0);
		remainder[remainder.length - 1] = temp_dec % 2;
		temp_dec /= 2;
		
		showResult(remainder);
	}
	
	private int findMaxHalfDivision (int number) {
		int j = 0;
		do { 
			j++;
			number /= 2;
		} while (number / 2 != 0);
		number /= 2;
		return ++j;
	}
	
	private void showResult(int byn[]) {
		System.out.print(orig_dec + " converted to binary = ");
		for ( int i = byn.length - 1; i >= 0; i-- ) {
			System.out.print(byn[i]);
		}
	}
}

class ConvertFromBinary {
	private int orig_byn = 0;
	ConvertFromBinary(int byn) {
		orig_byn = byn;
		findDecimals(orig_byn);
	}
	
	private void findDecimals(int byt) {
		String temp = Integer.toString(byt);	// converting integer to an array of numbers
		int[] byts = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
		    byts[i] = temp.charAt(i) - '0';
		}
		int total = 0;
		for (int i : byts) {
			total = total * 2 + i;
		}
		showResult(total);
	}
	
	private void showResult(int decimal) {
		System.out.println(orig_byn + " converted to decimal = " + decimal);
	}
}
