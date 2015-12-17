package src.main.java;

public class Flowchar1 {

	public static void main(String[] args) {
		kadai1();
	}

	public static void kadai1() {

		for (int k = 1; k <= 100; k++) {

			if (k % 15 == 0) {
				System.out.println("Fizzbazz");
			}
			else if (k % 3 == 0) {
				System.out.println("Fizz");
			}
			else if (k % 5 == 0) {
				System.out.println("bazz");
			}
			else {
				System.out.println(k);
			}

		}

	}
    
}