package TH;
import java.util.*;
public class TreasureHunt {
	//LAST UPDATED 4/11/20
	private String Uname;
	private String difficulty;
	private int score;
	
	
	public TreasureHunt(String Uname, String difficulty, int score) {
		this.Uname = Uname;
		this.difficulty = difficulty;
		this.score = score;
	}
	
	public void setUname(String Uname) {
		this.Uname = Uname;
	}
	public String getUname() {
		return Uname;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	public static String[][] makeGrid(int row, int col, String difficulty) {
		String[][] grid = new String[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int v = 0; v < col; v++) {
				grid[i][v] = "*";
			}
		}
		
		if (difficulty.equals("easy")) {
			
			for (int g = 0; g < 3; g++) {
				int FPA = (int)(Math.random() * 5);
				int FPB = (int)(Math.random() * 5);
				
				grid[FPA][FPB] = "[  ]";
				try {grid[FPA][FPB + 1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA + 1][FPB] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA+1][FPB+1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
			}
			grid[2][2] = "☻";
		}
		
		if (difficulty.equals("medium")) {
			
			for (int g = 0; g < 2; g++) {
				int FPA = (int)(Math.random() * 6);
				int FPB = (int)(Math.random() * 6);
				
				grid[FPA][FPB] = "[  ]";
				try {grid[FPA][FPB + 1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA + 1][FPB] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA+1][FPB+1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
			}
			grid[2][2] = "☻";
		}
		
		if (difficulty.equals("hard")) {
			
			for (int g = 0; g < 2; g++) {
				int FPA = (int)(Math.random() * 7);
				int FPB = (int)(Math.random() * 7);
				
				grid[FPA][FPB] = "[  ]";
				try {grid[FPA][FPB + 1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA][FPB - 1] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA + 1][FPB] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
				try {grid[FPA - 1][FPB] = "[  ]";} 
				catch(ArrayIndexOutOfBoundsException e){}//System.out.print("--Bad index found. Skipping...--");
			}
			grid[3][3] = "☻";
		}
		
		boolean goodPlace = false;
		while (goodPlace == false) {
			int TrezA = (int)(Math.random() * row);
			int TrezB = (int)(Math.random() * col);
			
			if (grid[TrezA][TrezB] == "*") {
				grid[TrezA][TrezB] = "[$]";
				goodPlace = true;
			}
		}
		return grid;
	}
	
	public static int CalculateScore(int moves, int HP, String difficulty) {
		//EASY Mode: 500(for winning) + 2 * HP -1/2moves 
		//MEDIUM Mode: 600(for winning) + 2 * HP -moves
		//HARD Mode: 800(for winning) + 2 * HP -1/2moves 
		int SCORE = 0;
		
		if (difficulty.equals("easy")) {
			HP = HP * 2;
			moves = Math.round(moves / 2);
			SCORE = 500 + HP - moves;
		}
		
		if (difficulty.equals("medium")) {
			HP = HP * 2;
			SCORE = 600 + HP - moves;
		}
		
		if (difficulty.equals("hard")) {
			HP = HP * 2;
			moves = Math.round(moves / 2);
			SCORE = 800 + HP - moves;
		}	
		return SCORE;
	}
	
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
	
	public static int StartGame(int row, int col, int level, String difficulty) {
		int HP = 100;
		int moves = 0;
		int plrposA = 0;
		int plrposB = 0;
		boolean TrezFound = false;
		boolean GameOver = false;
		boolean PlrQuit = false;
		int SCORE = 0;
		Scanner keyboard = new Scanner(System.in);
		
		String[][] grid = new String[row][col];
		if (difficulty.equals("easy")) {
			plrposA = 2;
			plrposB = 2;
			grid = makeGrid(row, col, difficulty);
		} else if (difficulty.equals("medium")) {
			plrposA = 2;
			plrposB = 2;
			grid = makeGrid(row, col, difficulty);
		} else if (difficulty.equals("hard")) {
			plrposA = 3;
			plrposB = 3;
			grid = makeGrid(row, col, difficulty);
		}
		
		System.out.print("\n\n");
	
		while (GameOver == false && TrezFound == false && PlrQuit == false) {
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
					dir.equals("w") || dir.equals("a") || dir.equals("s") || dir.equals("d") || dir.equals("quit")) {
				//good input
			} else {
				while (true) {
					System.out.print("Type a Direction to move(north, south, east, or west / w, a, s, or d): ");
					dir = keyboard.nextLine().toLowerCase();
					if (dir.equals("north") || dir.equals("south") || dir.equals("easy") || dir.equals("west") || 
							dir.equals("w") || dir.equals("a") || dir.equals("s") || dir.equals("d") || dir.equals("quit")) {
						break;
					}
				}
			}
			
			//move the player depending on their input, enter 'quit' to return to main menu
			System.out.print("\n");
			if (dir.equals("north") || dir.equals("w")) {
				try {
					if (grid[plrposA-1][plrposB].equals("[$]")) {
						System.out.println("LEVEL COMPLETE! ☻[$]");
						System.out.println("Level Score: " + CalculateScore(moves, HP, difficulty));
						System.out.print("Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA-1][plrposB] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.println("You exploded! (*) You lose some Points!");
							System.out.print("Press Enter to advance.");
							String complete = keyboard.nextLine();
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
					System.out.println("It's too dangerous to leave the grid!");
				}
			}
			if (dir.equals("south") || dir.equals("s")) {
				try {
					if (grid[plrposA+1][plrposB].equals("[$]")) {
						System.out.println("LEVEL COMPLETE! ☻[$]");
						System.out.println("Level Score: " + CalculateScore(moves, HP, difficulty));
						System.out.print("Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA+1][plrposB] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.println("You exploded! (*) You lose some Points!");
							System.out.print("Press Enter to advance.");
							String complete = keyboard.nextLine();
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
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}	
			if (dir.equals("east") || dir.equals("d")) {
				try {
					if (grid[plrposA][plrposB+1].equals("[$]")) {
						System.out.println("LEVEL COMPLETE! ☻[$]");
						System.out.println("Level Score: " + CalculateScore(moves, HP, difficulty));
						System.out.print("Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA][plrposB+1] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.println("You exploded! (*) You lose some Points!");
							System.out.print("Press Enter to advance.");
							String complete = keyboard.nextLine();
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
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}
			if (dir.equals("west") || dir.equals("a")) {
				try {
					if (grid[plrposA][plrposB-1].equals("[$]")) {
						System.out.println("LEVEL COMPLETE! ☻[$]");
						System.out.println("Level Score: " + CalculateScore(moves, HP, difficulty));
						System.out.print("Press Enter to advance.");
						String complete = keyboard.nextLine();
						TrezFound = true;
					}
					if (grid[plrposA][plrposB-1] == "*") {
						System.out.println("You triggered a mine! -5 HP");
						HP -= 5;
						if (HP <= 0) {
							System.out.println("You exploded! (*) You lose some Points!");
							System.out.print("Press Enter to advance.");
							String complete = keyboard.nextLine();
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
					System.out.println(">CAUTION!< It's too dangerous to leave the grid!");
				}
			}
			
			if (dir.equals("quit")) {
				System.out.println("By quitting, you don't win any points from this level.");
				System.out.print("Are you sure?(y/n): ");
				String confirm = keyboard.nextLine().toLowerCase();
				if (confirm.equals("y")) {
					PlrQuit = true;
					break;
				}
			}
		}
		
		if (TrezFound == true) {
			SCORE = CalculateScore(moves, HP, difficulty);
			return SCORE;
		}
		if (GameOver == true) {
			if (difficulty.equals("easy")) {
				SCORE = CalculateScore(moves, HP, difficulty) -100;
				System.out.println("Level Score: " + SCORE);
			}
			if (difficulty.equals("medium")) {
				SCORE = CalculateScore(moves, HP, difficulty) -250;
				System.out.println("Level Score: " + SCORE);
			}
			if (difficulty.equals("hard")) {
				SCORE = CalculateScore(moves, HP, difficulty) -400;
				System.out.println("Level Score: " + SCORE);
			}
			return SCORE;
		}
		if (PlrQuit == true) {
			SCORE = 0;
			return SCORE;
		}
		System.out.println("We're sorry, something went wrong.");
		return 0;
	}
		
}
  
