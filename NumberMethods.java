/*In this assignment, the main purpose is to write a program that asks the user to enter two positive integer values: startval, and endval. The program will then find all numbers that fall between startval and endval according to menu that you will prepare.
 * Mustafa Yanar-150118048
 */
import java.util.Scanner;
public class Pro4_150118048 {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		// An variable to control system whether we want to work again or don't.
		char controllerAfterExecuted='y';
		//Enter the numbers you want to find numbers between 
		System.out.print("Enter the starting value: ");
        int number1 = input.nextInt();
        System.out.print("Enter the ending value: ");
        int number2 = input.nextInt();
		// An boolean to control to the System
        boolean controllerForAnotherSelection=true;
		//System will execute again until the user enter numbers that is positive.
        if(number1<0 || number2<0) {
			controllerForAnotherSelection=false;
			System.out.println("\nERROR! Please enter positive numbers. \n");
		//System ask to enter the valid numbers
			while(!controllerForAnotherSelection) {
			System.out.print("Enter the starting value: ");
	        number1 = input.nextInt();
	        System.out.print("Enter the ending value: ");
	        number2 = input.nextInt();
	        if(number1<0 || number2<0) {
	        	System.out.println("\nERROR! Please enter positive numbers. \n");
	        	 controllerForAnotherSelection=false;
	        }else
	        	controllerForAnotherSelection=true;
		}
		}
		//Swap if the number1 is greater than number2, system will executed as the numbers between the number2 to number1
		 if(number1>number2) {
	        	int temp=number1;
	        	number1=number2;
	        	number2=temp;
	        }
		 //One loop to execute again and again until the user enter "0"
		while(controllerForAnotherSelection) {
		System.out.println("1. Prime Numbers between: " + number1 + " and " + number2);
	    System.out.println("2. Perfect Numbers between: " + number1 + " and " + number2);
	    System.out.println("3. Fibonacci Numbers between: " + number1 + " and " + number2);
		System.out.println("4. Woodal Numbers between: " + number1 + " and " + number2);
		System.out.println("5. Tau Numbers between: " + number1 + " and " + number2);
		System.out.println("6. Smith Numbers between: " + number1 + " and " + number2);
		System.out.print("Please enter your menu choice (0 for exit): ");
		//Select you want to find numbers
		int menuSelection = input.nextInt();
        switch(menuSelection) {
        //System find Prime Numbers between number1 and number2
        case 1:
        	System.out.println();
        	primeNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)\n");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 2:
        	//System find Perfect Numbers between number1 and number2
        	System.out.println();
        	perfectNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 3:
        	//System find Fibonacci Numbers between number1 and number2
        	System.out.println();
        	fibonacciNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 4:
        	//System find Woodall Numbers between number1 and number2
        	System.out.println();
        	woodallNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 5:
        	//System find Tau Numbers between number1 and number2
        	System.out.println();
        	tauNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 6:
        	//System find Smith Numbers between number1 and number2
        	System.out.println();
        	smithNumbers(number1,number2);
        	//System ask the user to execute again for another execution
        	System.out.println("\nDo you want to find new numbers?(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        	break;
        case 0:
        	//System will exit.
        	System.out.println();
        	controllerForAnotherSelection=false;
        	System.out.println("\nThank you for choosing us, Have a nice day!!");
        	break;	
        default:
        	System.out.println();
        	System.out.println("\nYou should enter a number from 0 to 6.Please enter a valid input\n");
        	break;
        }
        while(controllerForAnotherSelection) {
        //If the user enter 'y' or 'Y' , loop will continue
        if(controllerAfterExecuted=='y'||controllerAfterExecuted=='Y') {
        	System.out.println("------------------------------------------");
        	controllerForAnotherSelection=true;
        	break;
        }
        //If the user enter 'n' or 'N' , loop will break and system will stop
        else if(controllerAfterExecuted=='n'||controllerAfterExecuted=='N') {
        	controllerForAnotherSelection=false;
        	System.out.println("\nThank you for choosing us, Have a nice day!!");
        	break;
        }
        //If the user does not enter "no" or "yes", System ask the user to enter "no" or "yes"
        else {
        	System.out.println("Your input's invalid(Y/N)");
        	controllerAfterExecuted=input.next().charAt(0);
        
        }
		}
       }
  }
	public static void primeNumbers(int number1,int number2) {
		//Prime Number Method
		//One array to store the values of all numbers between number1 and number2
		int[] primeNumbersArray= new int[number2-number1+1];
		//ifNoNumber is a control variables if there is no number between number1 and number2
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			//Assign '0' to values of arrays of all numbers
			primeNumbersArray[i-number1]=0;
			//Test the numbers is divisible different numbers except itself and 1
			for(int j=2;j<i+1;j++) {
				if(i%j==0)
					break;
				//if the number is prime , its value increase 1
				primeNumbersArray[i-number1]++;
			}
		}
		//if the number is a prime number then,its value is equal to (number-2)
		for(int i=number1;i<number2+1;i++) {
			if(primeNumbersArray[i-number1]==(i-2)) {
				ifNoNumber++;
				System.out.print(i+" ");
			}
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Prime Numbers found between "+number1+" and "+number2);
	}
	public static void perfectNumbers(int number1,int number2) {
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			int total=0;
			int tempOfNumber1=number1;
			//Sum divisors of the number
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					tempOfNumber1/=j;
					total+=j;
				}
			}
			//if the number is a number equal to the sum of all its proper divisors , it is a perfect number
			if(total==i && i!=0) {
				System.out.print(i+" ");
				ifNoNumber++;
			}
			
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Perfect Numbers found between "+number1+" and "+number2);
	}
	public static void fibonacciNumbers(int number1,int number2) {
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			//some temp to store the numbers previous
			int tempFirst=0,tempSecond=1,total=0;
			//Sum of previous fibonacci numbers 
			for(int j=0;j<i;) {
				total=tempFirst+tempSecond;
				tempFirst=tempSecond;
				tempSecond=total;
				j=total;
			}
			//if the number is a fibonacci number, the system will print this message
			if(total==i) {
				System.out.print(i+" ");
				ifNoNumber++;
			}
			
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Fibonacci Numbers found between "+number1+" and "+number2);
		
	}
	public static void woodallNumbers(int number1,int number2) {
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			int total=0;
			//assume that the number is 'n', ((2^n)*n)-1)
			for(int j=1;total<i;j++) {
				total=(int)(Math.pow(2, j)*j)-1;
			}
			//if this formula equal to the number then it is woodall number
			if(total==i&&i!=0) {
				ifNoNumber++;
				System.out.print(i+" ");
				
			}
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Woodall Numbers found between "+number1+" and "+number2);
	}
	public static void tauNumbers(int number1,int number2) {
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			int total=0;
			//sum the numbers of divisors
			for(int j=1;j<i+1;j++) {
				if(i%j==0)
				total++;
			}
			//if the sum can divide the number then it is Tau Numbers
			if(total!=0&&i%total==0) {
				System.out.print(i+" ");
				ifNoNumber++;
			}
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Tau Numbers found between "+number1+" and "+number2);
	}
	public static void smithNumbers(int number1, int number2) {
		int ifNoNumber=0;
		//One for loop to test all numbers between number1 and number2 whether is a prime number or not.
		for(int i=number1;i<number2+1;i++) {
			int tempOfNumber=i;
			int totalPrimes=0;
			//One loop to calculate to the sum of digits of divisors 
			for(int j=2;j<=tempOfNumber&&i!=j;) {
				if(tempOfNumber%j==0) {
					int tempOfPrimes=j;
					while(tempOfPrimes>0) {
						totalPrimes+=(tempOfPrimes)%10;
						tempOfPrimes/=10;
					}
					tempOfNumber/=j;
				}else
					j++;	
			}
			//One loop to calculate to the sum of digits of the number
			tempOfNumber=i;
			int totalNumberDigits=0;
			while(tempOfNumber>0) {
				totalNumberDigits+=(tempOfNumber)%10;
				tempOfNumber/=10;
			}
			//if the sums of the digits are equal, then it is smith number
			if(totalNumberDigits==totalPrimes&& i!=0) {
				System.out.print(i+" ");
				ifNoNumber++;
			}
		}
		//if there is no number between number1 and number2, system will print this message
		if(ifNoNumber==0)
			System.out.println("\nNo Smith Numbers found between "+number1+" and "+number2);
	}
}
