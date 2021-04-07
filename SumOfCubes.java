/*The purpose of this program is to write a program which finds the smallest number (excluding 1) whose sum of cubes of digits are equal to that number. The program should print the number you found as output.
 * Mustafa Yanar 150118048
 */
public class Pro3_1_150118048 {

	public static void main(String[] args) 
	{
		//Firstly,create a variable
		int theTestNumber=1;
		//An infinite loop to try all positive numbers one-by-one until you find the smallest number whose sum of cubes of digits are equal to that number
		for(;true;) 
		{
		int total=0;
		//Assign one variable not to lose the number the system tried
		int temp=theTestNumber;
		//Separate all digits of the number and add values of the digits 
		while(theTestNumber>0) {
			int theDigitsOfNumber=(int)(theTestNumber%10);
			total+=Math.pow(theDigitsOfNumber, 3);
			theTestNumber/=10;		
		}
		//if the system find a number , it will stop
		if(total==temp && total!=1) {
			//The first number the system find is the smallest number whose sum of cubes of digits are equal to that number.
			System.out.println("The smallest number (excluding 1) whose sum of cubes of digits are equal to that number is "+temp);
			break;
			}
		//Add 1 to the number the system tested .
		theTestNumber=temp+1;
		}
	}
}
