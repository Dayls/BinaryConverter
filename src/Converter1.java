import java.util.Scanner;
public class Converter1 {
	public static void main(String [] args) {
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
		}
		else {
			System.out.println("Enter a binary number that you want yo convert (up to 32 digits after 1)");
			int number = scanner.nextInt();
			char [] str = Integer.toString(number).toCharArray();
			ConvertFromBinary obj1 = new ConvertFromBinary(number);
		}
	}
}

class ConvertToBinary {
	private int orig_dec = 0;
	ConvertToBinary(int value) {
		orig_dec = value;
		findBytes(value);
	}
	
	private void findBytes(int dec) {
		final int maxValue = 31;
		int powerOfTwo [] = new int[maxValue];
		powerOfTwo[maxValue-1] = 1;
		
		for (int i = powerOfTwo.length - 2; i >= 0; i--) {
			powerOfTwo[i] = powerOfTwo[i + 1] * 2;
		}
		
		int temp_dec = dec;
		int j = 0;
		int binary [] = new int[maxValue];
		for (int byt : powerOfTwo) {
			if (temp_dec >= byt) {
				temp_dec -= byt;
				binary[j] = 1;
			}
			j++;
		}
		
		showAnswer(binary);
	}
	
	private void showAnswer(int[] binary) {
		System.out.print(orig_dec + " converted to binary = ");
		for (int i = 0; i < binary.length; i++) {
			if(binary[i] == 1) {
				for (int j = i; j < binary.length; j++) {
					System.out.print(binary[j]);
				}
				break;
			}
		}
	}
	
}

class ConvertFromBinary {
	private int orig_byn;
	ConvertFromBinary(int orig_bin) {
		this.orig_byn = orig_bin;
		findDecimals(orig_bin);
	}
	
	private void findDecimals(int byt) {
		final int maxValue = 31;
		int powerOfTwo [] = new int [maxValue];
		powerOfTwo[maxValue - 1] = 1;
		
		for (int i = powerOfTwo.length - 2; i >= 0; i--) {
			powerOfTwo[i] = powerOfTwo[i + 1] * 2;
		}
		
		String temp = Integer.toString(byt);	// converting integer to an array of numbers
		int[] byts = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
		    byts[i] = temp.charAt(i) - '0';
		}
		
		int j = 0;
		int decimal = 0;
		for (int i = maxValue - byts.length; i < maxValue; i++ ) {
			if(byts[j] == 1) {
				decimal += powerOfTwo[i];
			}
			j++;
		}
		System.out.println(decimal);
	}
	
	
}