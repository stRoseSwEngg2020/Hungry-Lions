package TH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ConnectionOfDatabase extends TreasureHunt{
	//LAST UPDATED 4/11/20
	
	public ConnectionOfDatabase(String Uname, String difficulty, int score) {
		super(Uname, difficulty, score);
	}

	public static Connection getConnection(TreasureHunt Tester) throws ClassNotFoundException, SQLException{
		
		String connectionURL = "jdbc:mysql://localhost:3306/school_work?serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connectionURL, "duncanm935", "");
		
		PreparedStatement sqlStatement;
		String sqlQuery = "";
		
		if (Tester.getDifficulty() == "easy") {
			//if the player chose easy mode, their score will be uploaded to the easy mode score table
			sqlQuery = "INSERT INTO EasyScores(username, score) VALUES(" + Tester.getUname() + ", " + Tester.getScore() + ")";
		}
		if (Tester.getDifficulty() == "medium") {
			sqlQuery = "INSERT INTO MediumScores(username, score) VALUES(" + Tester.getUname() + ", " + Tester.getScore() + ")";;
		}
		if (Tester.getDifficulty() == "hard") {
			sqlQuery = "INSERT INTO HardScores(username, score) VALUES(" + Tester.getUname() + ", " + Tester.getScore() + ")";;
		}
		if (Tester.getDifficulty() != "easy" && Tester.getDifficulty() != "medium" && Tester.getDifficulty() != "hard") {
			System.out.println("ERROR! Could not cennect to database! (Input Error)");
		}
		
		try {
			sqlStatement = ConnectionOfDatabase.getConnection(Tester).prepareStatement(sqlQuery);
			//sqlStatement.setString(1, Tester.getScore)
			
			if(sqlStatement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Your new score was added to the leaderboard!");
			}
		} catch (SQLException ex) {
			System.out.println("ERROR! Could not cennect to database! (Exception fired)");
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		String choice = "";
		Scanner keyboard = new Scanner(System.in);
		int Scorelvl1 = 1;//default values
		int Scorelvl2 = 1;
		int Scorelvl3 = 1;
		int TotalScore = 0;
		
		TreasureHunt Tester = new TreasureHunt("someone", "default", 0);
		//connect to database to find the player's real ID and place it in first parameter
		
		do {
			System.out.println("\t**Treasure Hunt!**");
			System.out.println("-Select a Number-");
			System.out.println("1: PLAY\n2: TUTORIAL\n3: END");
			System.out.print(">");
			choice = keyboard.nextLine();

			if (choice.equals("1")) {
				Scorelvl1 = 0;
				Scorelvl2 = 0;
				Scorelvl3 = 0;
				System.out.println("\nSelect Difficulty: ");
				System.out.println("1: EASY\n2: MEDIUM\n3: HARD");
				int diffi = keyboard.nextInt();
				if (diffi == 1) {
					Tester.setDifficulty("easy");
					Scorelvl1 = StartGame(5,5,1, "easy");
					if (Scorelvl1 != 0) {
						Scorelvl2 = StartGame(5,5,2, "easy");
						if (Scorelvl2 != 0) {
							System.out.println("\n(!!)FINAL LEVEL(!!)");
							Scorelvl3 = StartGame(5,6,3, "easy");
							if (Scorelvl3 != 0) {
								System.out.println("\n\n\tGAME OVER!\n");
							}
						}
					}
					TotalScore = Scorelvl1 + Scorelvl2 + Scorelvl3;
					System.out.println("Final Score: " + TotalScore + "\n\n");
					Tester.setScore(TotalScore);
					Tester.getConnection(Tester);
				}
				
				if (diffi == 2) {
					Tester.setDifficulty("medium");
					Scorelvl1 = StartGame(6,6,1, "medium");
					if (Scorelvl1 != 0) {
						Scorelvl2 = StartGame(6,6,2, "medium");
						if (Scorelvl2 != 0) {
							System.out.println("\n(!!)FINAL LEVEL(!!)");
							Scorelvl3 = StartGame(6,7,3, "medium");
							if (Scorelvl3 != 0) {
								System.out.println("\n\n\tGAME OVER!\n");
							}
						}
					}
					TotalScore = Scorelvl1 + Scorelvl2 + Scorelvl3;
					System.out.println("Final Score: " + TotalScore + "\n\n");
					Tester.setScore(TotalScore);
					Tester.getConnection(Tester);
				}
				
				if (diffi == 3) {
					Tester.setDifficulty("hard");
					Scorelvl1 = StartGame(7,7,1, "hard");
					if (Scorelvl1 != 0) {
						Scorelvl2 = StartGame(7,7,2, "hard");
						if (Scorelvl2 != 0) {
							System.out.println("\n(!!)FINAL LEVEL(!!)");
							Scorelvl3 = StartGame(7,8,3, "hard");
							if (Scorelvl3 != 0) {
								System.out.println("\n\n\tGAME OVER!\n");
							}
						}
					}
					TotalScore = Scorelvl1 + Scorelvl2 + Scorelvl3;
					System.out.println("Final Score: " + TotalScore + "\n\n");
					Tester.setScore(TotalScore);
					Tester.getConnection(Tester);
				}
				
			} else if (choice.equals("2")) {
				System.out.println("\n\nTUTUROIAL: \n" + 
						"You are an explorer trying to find long lost treasure underground.  \n" + 
						"You must traverse a 2-D grid until you find the treasure or run out of health points.  \n" + 
						"You start each level with 100 HP.\n" + 
						"☻ marks where you are currently standing on the grid\n" + 
						"* mines are scattered all over the grid and are invisible to you.  You will lose HP if you hit one.\n" + 
						"A mine space turns into a free space after you land on it.\n" + 
						"[  ] marks a free space.  You can traverse these without losing health.\n" + 
						"[$] the treasure is hidden, so the space it is in is invisible. THE TREASURE WON'T BE HIDDEN IN A FREE SPACE\n" + 
						"Enter 'north', 'south', 'east', or 'west' to move.  You can also enter 'w', 's', 'd', or 'a' to move in the respective direction.\n" +
						"Enter 'quit' to stop playing and return to the menu.\n\n");
				}
			if (choice.equals("3")) {
				break;
			}
		} while (true);

		System.out.print("Thanks for Playing! ☻[$]");
	}
	
}
