package thread;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author DuyLe
 */
public class tinhSum extends Thread {
	public int size;
	public int[] myArray;

	tinhSum(int size, int[] myArray) {
		this.size = size;
		this.myArray = myArray;
	}
	@Override
	public void run() {
		//caculate sum of array
		try {
			Thread.sleep(40);
			int sum = 0;
			for (int i = 0; i < size / 2; i++) {
				sum = sum + myArray[i];
				System.out.println("Number of thread : " + this.getName() + " = " + sum);
			}
			System.out.println("Sum of an array :" + sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//input : size of array
		System.out.println("Size of array : ");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] myArray = new int[size];

		//element of array
		System.out.println("Element of an array. example : 1 2 3 4 5 6");
		for (int i = 0; i < size; i++) {
			myArray[i] = s.nextInt();
		}
		System.out.println("Your array is : " + Arrays.toString(myArray));

		//split an array
		int[] myArray1 = Arrays.copyOfRange(myArray, 0, myArray.length / 2);
		int[] myArray2 = Arrays.copyOfRange(myArray, myArray.length / 2, myArray.length);
		System.out.println("The first of half array : " + Arrays.toString(myArray1));
		System.out.println("The second of half array  : " + Arrays.toString(myArray2));

		tinhSum t = new tinhSum(size, myArray1);		
		t.start();
		tinhSum t2 = new tinhSum(size, myArray2);
		t2.start();
	}
}
