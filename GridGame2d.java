/*The main purpose of this assignment is to write a two-dimensional Grid Game. In this game, there is a person and multiple items. Items placed into the cell randomly. Person start cell point is (0,0) and cell status is 2. The aim of this game is the person collects all the items with limited number of movement. The user will move the person in the game with the right (R), left (L), down (D) and up (U) keys
 * Mustafa Yanar --- 150118048
 */
import java.util.Scanner;
public class Pro5_1_150118048 {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		//Print entrance text and enter the the grid size
		int gridSize;
		System.out.println("WELCOME TO GRID GAME\n");
		//Repeat until the user enter valid inputs
		while(true) {
		System.out.print("Please enter the Grid size: ");
		gridSize=input.nextInt();
		if(gridSize>0)
			break;
		else
			System.out.println("Please review the input. The grid size should be greater than 0.");
		}
		System.out.println();
		System.out.println("--Hello "+gridSize+"x"+gridSize+" Grid Game--");
		//Create an array to store all positions of the objects
		int[][] areaOfGame= new int[gridSize][gridSize+2];
		//Create a loop to determine their statues
		for(int column=0; column<areaOfGame.length;column++) {
			for(int row=0;row<areaOfGame[column].length;row++) {
		//Assign 3,if the position is the edge position
				if(row==gridSize+1)
				areaOfGame[column][row]=3;
		//Assign 3,if the position is the edge position
				if(row==0)
				areaOfGame[column][row]=4;
		//Assign 0,if the position is inside of the area of game
				if(row<gridSize+1 && row>0)
					areaOfGame[column][row]=0;
			}
		}//Create two array to store the positions of the random items
		int[] x= new int[gridSize/2];
		int[] y= new int[gridSize/2];
		//Create items in random positions
		for(int i=0;i<gridSize/2;i++) {
			x[i]= (int)(Math.random()*gridSize-1);
			y[i]= (int)(Math.random()*gridSize+1);
			//Create controller whether item has same position with another item
			boolean control=true;
			for(int j=0;j<x.length;j++)
				if(((i|j)!=0 && y[i]==y[j] &&x[i]==x[j] && i!=j )|| (x[i]==0&&y[i]==1)) {
					control=false;
					break;
				}
			//ignore this item and create again if two item has same position
			if(control==false) {
				i--;
				continue;
			}//Assign 5 if there is no any problem
			areaOfGame[x[i]][y[i]]=5;
		}//Create two variable to store the position of the character
		int currentPositionX=0;
		int currentPositionY=1;
		//Assign 1 because of that the character statue is "1"
		areaOfGame[currentPositionX][currentPositionY]=1;
		//Create a variable to store remaining number of item
		int numberOfItem=0;
		//Create a char variable to get direction by user
		char move;
		//Create a loop that will execute again and again until the right of movement is over
		for(int i=(int)(gridSize*2.5);i>0;i--) {
			//Update the current position of character after the each repetition
			areaOfGame[currentPositionX][currentPositionY]=1;
			//Assign 0 to number of item
			numberOfItem=0;
			//Print the symbols of each position according to their statues to the console
			for(int column=0; column<areaOfGame.length;column++) {
				for(int row=0;row<areaOfGame[column].length;row++) {
					if(areaOfGame[column][row]==0)
						System.out.print(" ");
					if(areaOfGame[column][row]==1)
						System.out.print("X");
					if(areaOfGame[column][row]==5) {//increase one in case values of array in this position is "5"
						System.out.print("*");
						numberOfItem++;
						}
					if(areaOfGame[column][row]==3)
						System.out.println("|");
					if(areaOfGame[column][row]==4)
						System.out.print("|");
					if(areaOfGame[column][row]==2)
						System.out.print("+");
				}
			}//Print "You Won" and break loop if the number of item equals 0
			if(numberOfItem==0) {
				System.out.println("\n***You Won***");
				break;
			}//Print the remaining rights of movement and current position of the character
			System.out.println("Moves: "+i+"  Current Cell("+(currentPositionY-1)+","+currentPositionX+")");
			//Choose a direction to move character
			System.out.print("Choose Your Direction (R,L,U,D):");
			move= input.next().charAt(0);
			//Convert the letter entered to lower case to ignore the case of letter
			move=Character.toLowerCase(move);
			//Enter the 'x' to exit from the program
			if(move=='x') {
				System.out.println("---Game Over---");
				System.exit(0);
			}
			//Update the last position as '2' value
			areaOfGame[currentPositionX][currentPositionY]=2;
			//Decrease one to the sequence of the current position as horizontally if the input is 'l' and there is an item or empty in the new position
			if(move=='l' && (areaOfGame[currentPositionX][currentPositionY-1]==0||areaOfGame[currentPositionX][currentPositionY-1]==5))
				currentPositionY--;
			//increase one to the sequence of the current position as horizontally if the input is 'r' and there is an item or empty in the new position
			else if(move=='r'&& (areaOfGame[currentPositionX][currentPositionY+1]==0||areaOfGame[currentPositionX][currentPositionY+1]==5))
				currentPositionY++;
			else if(move=='u'&& currentPositionX-1!=-1)//Create a condition so that the character will not going to out of the area
				//Decrease one to the sequence of the current position as vertically if the input is 'u' and there is an item or empty in the new position
				if((areaOfGame[currentPositionX-1][currentPositionY]==0||areaOfGame[currentPositionX-1][currentPositionY]==5))
					currentPositionX--;
				//increase one the right of movement to ignore this time if the input is invalid input or there is value other than empty and item in the new position
				else {//Print "invalid input" to the top of the screen
					System.out.println("\nINVALID INPUT ! Please Enter to move (R,L,U,D) or exit (X) ");
					i++;
					}
			else if(move=='d'&&currentPositionX+1!=gridSize)//Create a condition so that the character will not going to out of the area
				//increase one to the sequence of the current position as vertically if the input is 'd' and there is an item or empty in the new position
				if((areaOfGame[currentPositionX+1][currentPositionY]==0||areaOfGame[currentPositionX+1][currentPositionY]==5))
					currentPositionX++;
				//increase one the right of movement to ignore this time if the input is invalid input or there is value other than empty and item in the new position
				else {//Print "invalid input" to the top of the screen
					System.out.println("\nINVALID INPUT ! Please Enter to move (R,L,U,D) or exit (X) ");
					i++;
					}
			//increase one the right of movement to ignore this time if the input is invalid input or there is value other than empty and item in the new position
			else {//Print "invalid input" to the top of the screen
				System.out.println("\nINVALID INPUT ! Please Enter to move (R,L,U,D) or exit (X) ");
				i++;
			}
		}//Print "Game Over" if rights of movement are over before you collect
		if(numberOfItem!=0) {
			System.out.println("\n---Game Over---");
		}
	}
}
