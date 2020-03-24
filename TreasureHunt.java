import java.util.*;
public class TreasureHunt {
	//ArrayIndexOutOfBoundsException
	
	public static void printGrid(String grid[][], int row, int col) {
		/*
		 * for (int p = 0; p < col; p++) { for (int q = 0; q < row; q++) {
		 * System.out.printf("|%4s ", grid[p][q]); } System.out.print("|\n"); }
		 */
		for (int l = 0; l < col; l++) {
			System.out.print("+-----");
		}
		System.out.print("+\n");		
		for (int p = 0; p < row; p++) {
			for (int q = 0; q < col; q++) {
				
				if (grid[p][q] == "[  ]") {
					System.out.printf("|%4s ", grid[p][q]);
				} 
				if (grid[p][q] == "☻") {
					System.out.printf("|%4s ", grid[p][q]);
				} 
				if (grid[p][q] == "*") {
					System.out.printf("|%4s ", " ");
				}
				if (grid[p][q] == "[$]") {
					System.out.printf("|%4s ", " ");
				}
			}
			System.out.print("|\n");
			for (int l = 0; l < col; l++) {
				System.out.print("+-----");
			}
			System.out.print("+\n");
			//|     |     |     |     |     |
			//+-----+-----+-----+-----+-----+
		}
		
	}
	
	public static boolean StartGame(int row, int col, int level) {
		//int row = 5;
		//int col = 5;
		//int level = 1;
		int HP = 100;
		int moves = 0;
		boolean TrezFound = false;
		boolean GameOver = false;
		Scanner keyboard = new Scanner(System.in);
		String[][] grid = new String[row][col];
		int plrposA = 2;
		int plrposB = 2;
		
		for (int i = 0; i < row; i++) {
			for (int v = 0; v < col; v++) {
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
			try {grid[FPA][FPB + 1] = "[  ]";} 
			catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
			try {grid[FPA + 1][FPB] = "[  ]";} 
			catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
			try {grid[FPA+1][FPB+1] = "[  ]";} 
			catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
		}
		grid[plrposA][plrposB] = "☻";
		
		boolean goodPlace = false;
		while (goodPlace == false) {
			int TrezA = (int)(Math.random() * 5);
			int TrezB = (int)(Math.random() * 5);
			
			if (grid[TrezA][TrezB] == "*") {
				grid[TrezA][TrezB] = "[$]";
				goodPlace = true;
			}
		}
	
		while (GameOver == false && TrezFound == false) {
			//CHECKS & PRIORITY:
			//0 - Input is valid
			//1 - The player stepped out of bounds (handle exception)
			//2 - The player found the treasure
			//3 - The player stepped on a mine
			//4 - The player stepped on a free space
			System.out.println("LEVEL " + level + ", HP: " + HP + ", Moves: " + moves);
			printGrid(grid, row, col);
			System.out.print("-> ");
			String dir = keyboard.nextLine().toLowerCase();
			
			if (dir.equals("north") || dir.equals("south") || dir.equals("easy") || dir.equals("west") || 
					dir.equals("w") || dir.equals("a") || dir.equals("s") || dir.equals("d")) {
				//good input
			} else {
				while (true) {
					System.out.print("Type a Direction to move(north, south, east, or west / w, a, s, or d): ");
					dir = keyboard.nextLine().toLowerCase();
					if (dir.equals("north") || dir.equals("south") || dir.equals("easy") || dir.equals("west") || 
							dir.equals("w") || dir.equals("a") || dir.equals("s") || dir.equals("d")) {
						break;
					}
				}
			}
				
			
			//move the player depending on their input, enter 'quit' to return to main menu
			System.out.print("\n");
			if (dir.equals("north") || dir.equals("w")) {
				try {
					if (grid[plrposA-1][plrposB].equals("[$]")) {
						System.out.print("LEVEL COMPLETE! ☻[$]\n Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA-1][plrposB] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.print("You exploded! (*) Game Over!\n Press Enter to retrun to the menu.");
							String failure = keyboard.nextLine();
							GameOver = true;
						} else {
							grid[plrposA-1][plrposB] = "☻";
							grid[plrposA][plrposB] = "[  ]";
							plrposA -= 1;
							moves += 1;
						}
					}
					if (grid[plrposA-1][plrposB] == "[  ]") {
						System.out.println("You travel north into a free space.");
						grid[plrposA-1][plrposB] = "☻";
						grid[plrposA][plrposB] = "[  ]";
						plrposA -= 1;
						moves += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					//plrposA -= 1;
					//grid[plrposA][plrposB] = "☻";
					System.out.println("It's too dangerous to leave the grid!");
				}
			}
			if (dir.equals("south") || dir.equals("s")) {
				try {
					if (grid[plrposA+1][plrposB].equals("[$]")) {
						System.out.print("LEVEL COMPLETE! ☻[$]\n Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA+1][plrposB] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.print("You exploded! (*) Game Over!\n Press Enter to retrun to the menu.");
							String failure = keyboard.nextLine();
							GameOver = true;
						} else {
							grid[plrposA+1][plrposB] = "☻";
							grid[plrposA][plrposB] = "[  ]";
							plrposA += 1;
							moves += 1;
						}
					}
					if (grid[plrposA+1][plrposB] == "[  ]") {
						System.out.println("You travel south into a free space.");
						grid[plrposA+1][plrposB] = "☻";
						grid[plrposA][plrposB] = "[  ]";
						plrposA += 1;
						moves += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					//plrposA -= 1;
					//grid[plrposA][plrposB] = "☻";
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}	
			if (dir.equals("east") || dir.equals("d")) {
				try {
					if (grid[plrposA][plrposB+1].equals("[$]")) {
						System.out.print("LEVEL COMPLETE! ☻[$]\n Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA][plrposB+1] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.print("You exploded! (*) Game Over!\n Press Enter to retrun to the menu.");
							String failure = keyboard.nextLine();
							GameOver = true;
						} else {
							grid[plrposA][plrposB+1] = "☻";
							grid[plrposA][plrposB] = "[  ]";
							plrposB += 1;
							moves += 1;
						}
					}
					if (grid[plrposA][plrposB+1] == "[  ]") {
						System.out.println("You travel south into a free space.");
						grid[plrposA][plrposB+1] = "☻";
						grid[plrposA][plrposB] = "[  ]";
						plrposB += 1;
						moves += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					//plrposA -= 1;
					//grid[plrposA][plrposB] = "☻";
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}
			if (dir.equals("west") || dir.equals("a")) {
				try {
					if (grid[plrposA][plrposB-1].equals("[$]")) {
						System.out.print("LEVEL COMPLETE! ☻[$]\n Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA][plrposB-1] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.print("You exploded! (*) Game Over!\n Press Enter to retrun to the menu.");
							String failure = keyboard.nextLine();
							GameOver = true;
						} else {
							grid[plrposA][plrposB-1] = "☻";
							grid[plrposA][plrposB] = "[  ]";
							plrposB -= 1;
							moves += 1;
						}
					}
					if (grid[plrposA][plrposB-1] == "[  ]") {
						System.out.println("You travel south into a free space.");
						grid[plrposA][plrposB-1] = "☻";
						grid[plrposA][plrposB] = "[  ]";
						plrposB -= 1;
						moves += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					//plrposA -= 1;
					//grid[plrposA][plrposB] = "☻";
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}
		}
		
		if (TrezFound == true) {
			return true;
		}
		if (GameOver == true) {
			return false;
		}
		System.out.println("We're sorry, something went wrong");
		return false;
	} 
		
		 
	
	public static void main(String[] args) {
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		
		while (choice != 3){
			System.out.println("\t**Treasure Hunt!**");
			System.out.println("1: PLAY\n2: TUTORIAL\n3: END");
			choice = keyboard.nextInt();

			if (choice == 1) {
				System.out.println("Select Difficulty: ");
				System.out.println("1: EASY\n2: MEDIUM\n3: HARD");
				int diffi = keyboard.nextInt();
				if (diffi == 1) {
					if (StartGame(5,5,1) == true) {
						if (StartGame(5,5,2) == true) {
							System.out.println("\n(!!)FINAL LEVEL(!!)");
							if (StartGame(5,6,3) == true) {
								System.out.println("\n\n\tYOU WIN! ☻[$][$][$]\n Press Enter to retrun to the menu.");
								String complete = keyboard.nextLine();
							}
						}
					}
					;//easy mode only for now, add more difficulties later
				}
				
			} else if (choice == 2) {
				System.out.println("TUTUROIAL: \n" + 
						"You are an explorer trying to find long lost treasure underground.  \n" + 
						"You must traverse a 2-D grid until you find the treasure or run out of health points.  \n" + 
						"You start each level with 100 HP.\n" + 
						"☻ marks where you are currently standing on the grid\n" + 
						"* mines are scattered all over the grid and are invisible to you.  You will lose HP if you hit one.\n" + 
						"A mine space turns into a free space after you land on it.\n" + 
						"[  ] marks a free space.  You can traverse these without losing health.\n" + 
						"[$] marks where the treasure is hidden.  This space is also invisible. THE TREASURE WONT BE HIDDEN IN A FREE SPACE\n" + 
						"Enter 'north', 'south', 'east', or 'west' to move.  You can also enter 'w', 's', 'd', or 'a' to move in the respective direction.\n");
				
				}
		}


		System.out.print("Thanks for Playing! ☻[$]");
	}
}
  
