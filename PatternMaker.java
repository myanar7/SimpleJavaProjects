/* The purpose of this program is to write a program that prompts the user to enter an integer number (N) and a character then displays the following (2N+1)-by-(2N+1) diamond pattern
 * Mustafa Yanar  150118048 
 */
import java.util.Scanner;
public class Pro3_2_150118048 {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String symbolOfEmpty=". ";
		//Create a variable for the input of the user.
		int integerEnter;
		System.out.print("Enter a number: ");
    	integerEnter=input.nextInt();
    	//Create a loop to repeat if user enters character more than one.
    	while(true) {
    	System.out.print("Enter a character: ");
		//Enter a character for diamond pattern.
    	String characterEnter=input.next();
    	int amountOfChar=1;
    	int integerControl=integerEnter;
		if((characterEnter.length()-1)<1) {
		//Create a nested loops to design diamond pattern. 
			for(int i=0; i<2*integerEnter+2;i++){
		int x;
		//Create an if-else to organize the numbers of character in one line.
		//increase numbers of the character until half of diamond pattern.
		if(i<=integerEnter-1){
			for(x=0; x<integerControl;x++)
			System.out.print(symbolOfEmpty);
			for(int y=0	; y<amountOfChar;y++)
			System.out.print(characterEnter+" ");
			for(x=0; x<integerControl;x++)
			System.out.print(symbolOfEmpty);
			integerControl--;
			amountOfChar+=2;
			System.out.println("");
		//Reduce numbers of the character after half of diamond pattern.		
		}else if(i>=integerEnter+1){
			for(x=0; x<integerControl;x++)
			System.out.print(symbolOfEmpty);
			for(int y=0	; y<amountOfChar;y++)
			System.out.print(characterEnter+" ");
			for(x=0; x<integerControl;x++)
			System.out.print(symbolOfEmpty);
			integerControl++;
			amountOfChar-=2;
			System.out.println("");
			}
		  }
		 //if the character that user entered is valid, print a diamond pattern with properties is entered by user.
		 break;
		 //if the character that user entered is invalid, print "Try Again" and enter valid an input.
		}else
			  System.out.println("Invalid input. You should enter only one character. Try Again!");
	}
  }
}