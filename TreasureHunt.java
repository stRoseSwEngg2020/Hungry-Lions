import java.util.*;
public class TreasureHunt {
	//ArrayIndexOutOfBoundsException
	
	public static void printGrid(String grid[][], int row, int col) {
		
//		String blankGrid[][] = new String[row][col];
//		
//		for (int p = 0; p < col; p++) {
//			
//			for (int q = 0; q < row; q++) {
//				if (grid[p][q] == "[  ]") {
//					blankGrid[p][q] = "[  ]";
//				} else {
//					blankGrid[p][q] = " ";
//				}
//				System.out.printf("|%4s ", blankGrid[p][q]);
//			}
//			System.out.print("|\n");
//		}
		
		System.out.print("\n\n");
		for (int i = 0; i < col; i++) {
			
			for (int v = 0; v < row; v++) {
				System.out.printf("|%4s ", grid[i][v]);
			}
			System.out.print("|\n");
		}
	}
	
	public static void StartGame() {
		int row = 5;
		int col = 5;
		int HP = 100;
		  
		String[][] grid = new String[row][col];
		
		for (int i = 0; i < col; i++) {
			for (int v = 0; v < row; v++) {
				if (grid[i][v] == "☻" || grid[i][v] == "[  ]") {
					continue;
				} else {
					grid[i][v] = "*";
				}
			}
		}
		
		
		for (int g = 0; g < 3; g++) {
			int FPA = (int)(Math.random() * 5);
			int FPB = (int)(Math.random() * 5);
			//System.out.println("\n" + FPA);
			//System.out.println(FPB);
			
			grid[FPA][FPB] = "[  ]";
			try {
				grid[FPA][FPB + 1] = "[  ]";
			} 
			catch(ArrayIndexOutOfBoundsException e){
				//System.out.print("--Bad index found. Skipping...--");
			}
			try {
				grid[FPA + 1][FPB] = "[  ]";
			} 
			catch(ArrayIndexOutOfBoundsException e){
				//System.out.print("--Bad index found. Skipping...--");
			}
			try {
				grid[FPA+1][FPB+1] = "[  ]";
			} 
			catch(ArrayIndexOutOfBoundsException e){
				//System.out.print("--Bad index found. Skipping...--");
			}
		}
		grid[2][2] = "☻";
		
		boolean goodPlace = false;
		while (goodPlace == false) {
			int TrezA = (int)(Math.random() * 5);
			int TrezB = (int)(Math.random() * 5);
			
			if (grid[TrezA][TrezB] == "*") {
				grid[TrezA][TrezB] = "[$]";
				goodPlace = true;
			}
		}
	
		printGrid(grid, row, col);
	} 
		
		 
	
	public static void main(String[] args) {
		//String choice = "";
		//Scanner keyboard = new Scanner(System.in);
		
//		while (choice != "end"){
//			System.out.println("PLAY	TUTORIAL	END");
//		}
		//System.out.println("EASY	MEDIUM    HARD");
		//System.out.print("Select Difficulty: ");
		//String diffi = keyboard.nextLine().toLowerCase();
		//☻

		StartGame();
		
	}
}
/*
 * TUTUROIAL: 
 * You are an explorer trying to find long lost treasure underground.  
 * You must traverse a 2-D grid until you find the treasure or run out of health points.  
 * You start each level with 100 HP.
 * "☻" marks where you are currently standing on the grid
 * "*" mines are scattered all over the grid and are invisible to you.  You will lose HP if you hit one.
 * A mine space turns into a free space after you land on it.
 * "[  ]" marks a free space.  You can traverse these without losing health.
 * "[$]" marks where the treasure is hidden.  This space is also invisible.
 * Enter 'north', 'south', 'east', or 'west' to move.  You can also enter 'w', 's', 'd', or 'a' to move in the respective direction.
 * */
