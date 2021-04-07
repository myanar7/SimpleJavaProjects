/*The main purpose of this assignment is to write a program that tests whether a two-dimensional list has string
  keyword, either horizontally, vertically, or diagonally
 
 *Mustafa Yanar --- 150118048 
 */


import java.util.Scanner;
public class Pro5_2_150118048 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows;
		int columns;
		//Repeat until the user enter valid inputs
		while(true) {
		//Enter the columns and rows of the puzzle
		System.out.print("Enter the number of rows: ");
		rows=input.nextInt();
		System.out.print("Enter the number of columns: ");
		columns= input.nextInt();
		if(columns>0&&rows>0)
			break;
		else
			System.out.println("Please review your inputs.The numbers sould be greater than 0.");
		}
		//Create alphabet list to use in your puzzle 
		String[] arguments= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		//Create an array to store all letter in the puzzle
		String[][] puzzle=new String[rows][columns];
		//Assign random letter all the values of String array and print them respectively
		for(int row=0; row<puzzle.length;row++) {
			for(int column=0;column<puzzle[row].length;column++) {
				puzzle[row][column]=arguments[(int)(Math.random()*36)];
				System.out.print(puzzle[row][column]+" ");
			}
			System.out.println();
		}
		//Enter your keyword to find inside the puzzle
		System.out.print("\nPlease enter the keyword: ");
		String theWordEntered= input.next();
		//Create a controller to stop the system in case the keyword is found
		boolean control=false;
		//Convert all the letters of keyword from lower case to upper case
		theWordEntered=theWordEntered.toUpperCase();
		//Create two variable to store the position of letter that is same with head letter of keyword
		int positionX=0,positionY=0;
		//Scan the all puzzle to find whether the keyword provides one of the conditions or not
		for(int row=0; row<puzzle.length;row++) {
			for(int column=0;column<puzzle[row].length;column++) {
				if(puzzle[row][column].equals(Character.toString(theWordEntered.charAt(0)))) {
					//Store the position of letter that is same with head letter of keyword
					positionX=row;
					positionY=column;
					//Check that there is keyword to the right direction in puzzle
					if(controlWordToRight(theWordEntered,puzzle,positionX,positionY,columns)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the left direction in puzzle
					else if(controlWordToLeft(theWordEntered,puzzle,positionX,positionY)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the down direction in puzzle
					else if(controlWordToDown(theWordEntered,puzzle,positionX,positionY,rows)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the upward direction in puzzle
					else if(controlWordToUpper(theWordEntered,puzzle,positionX,positionY)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the right-down direction in puzzle
					else if(controlWordToCrossDown1(theWordEntered,puzzle,positionX,positionY,rows,columns)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the left-down direction in puzzle
					else if(controlWordToCrossDown2(theWordEntered,puzzle,positionX,positionY,rows,columns)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the right-upward direction in puzzle
					else if(controlWordToCrossUpper1(theWordEntered,puzzle,positionX,positionY,rows,columns)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}//Check that there is keyword to the left-upward direction in puzzle
					else if(controlWordToCrossUpper2(theWordEntered,puzzle,positionX,positionY,rows,columns)) {
						// if there is,controller returns true and the output is TRUE. Then loop breaks.
						control=true;
						System.out.println("\nTRUE");
						break;
					}
				}
			}
			//Break the loop if the keyword is found in puzzle
			if(control)
				break;
		}
		//Print "FALSE" if the controller never returns true
		if(control==false) {
			System.out.print("\nFALSE");
		}		
	}//Create controllers for each direction
	
	public static boolean controlWordToRight(String theWordEntered,String[][] puzzle, int row, int column,int columns) {
		//Check letters of the word to the right one-by-one
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(column+i>columns-1)
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row][column+i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToLeft(String theWordEntered,String[][] puzzle, int row, int column) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(column-i<0)
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row][column-i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToDown(String theWordEntered,String[][] puzzle, int row, int column,int rows) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row+i>rows-1) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row+i][column].equals(Character.toString(theWordEntered.charAt(i))))
				return false;
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToUpper(String theWordEntered,String[][] puzzle, int row, int column) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row-i<0) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row-i][column].equals(Character.toString(theWordEntered.charAt(i))))
				return false;	
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToCrossDown1(String theWordEntered,String[][] puzzle, int row, int column,int rows,int columns) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row+i>rows-1||column+i>columns-1) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row+i][column+i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;	
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToCrossUpper1(String theWordEntered,String[][] puzzle, int row, int column,int rows,int columns) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row-i<0||column-i<0) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row-i][column-i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;	
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToCrossDown2(String theWordEntered,String[][] puzzle, int row, int column,int rows,int columns) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row+i>rows-1||column-i<0) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row+i][column-i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;	
		}//Return true if the method never return false
	return true;
	}
	public static boolean controlWordToCrossUpper2(String theWordEntered,String[][] puzzle, int row, int column,int rows,int columns) {
		for(int i=0;i<theWordEntered.length();i++) {
			//Create a condition so that the program will not occur an error in case of the overflow of the array 
			if(row-i<0||column+i>columns-1) 
				return false;
			//Create an condition that is returning false in case the word is not provided in this direction
			if(!puzzle[row-i][column+i].equals(Character.toString(theWordEntered.charAt(i))))
				return false;	
		}//Return true if the method never return false
	return true;
	}
}