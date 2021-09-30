import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5
{
	public static int TOTAL_QUEENS = 8;
	private int[][] board;
	private int[] queenPositions;

	public static void main(String[] args) 
	{

		boolean climb = true;
		int climbCount = 0;
		P5 board = new P5 ( new int[TOTAL_QUEENS][TOTAL_QUEENS], new int[8]);
			board.placeQueens();
			System.out.println("Trial #: " + (climbCount+1));
			System.out.println("Original board:");
			board.printBoard();
			System.out.println("# pairs of queens attacking each other: " + board.h() + "\n");

			int localMin = board.h();
			boolean best = false;
	
			int[] bestQueenPositions = new int[8];

			for (int j = 0; j < board.board.length; j++) 
			{
				System.out.println("Iterating through Column " + j + ":");
				best = false;
				for (int i = 0; i < board.board.length; i++) 
				{
					if (i != board.queenPositions[j]) 
					{
						board.moveQueen(i, j);
						board.printBoard();
						System.out.println();
						if (board.h() < localMin) 
						{
							best = true;
							localMin = board.h();
						System.out.println("# pairs of queens attacking each other(board below):" + localMin);
							bestQueenPositions[j] = i;
						}

						board.resetQueen(i, j);
					}	
				}
				
				board.resetBoard(j);
				if (best) 
				{
					board.placeBestQueen(j, bestQueenPositions[j]);
					System.out.println("Best board found for this iteration: ");
					board.printBoard();
					System.out.println("# pairs of queens attacking each other: " + board.h() + "\n");
				} 
				else 
				{
					System.out.println("No better board found.");
					board.printBoard();
					System.out.println("# pairs of queens attacking each other: "	+ board.h() + "\n");
				}
			}


			if (board.h() == 0)
				climb = false;

			climbCount++;

			if (climbCount == 6) 
			{
				climb = false;
			}
			System.out.println("Done in " + (climbCount-1) + " restarts.");
	}

	public P5(int[][] board, int[] positions) 
	{
		this.board = board;
		this.queenPositions = positions;

	}

	private int[] generateQueens() 
	{
		List<Integer> startState = new ArrayList<Integer>();
		
		Scanner in = new Scanner(System.in);
		int value;
		System.out.println("Enter 8 row nos (0-7) of queens to be placed"+"\n"+ 
		"Queens will be placed in every column at the row no specified. ");
		for (int i = 0; i < TOTAL_QUEENS; i++) 
		{
			value = in.nextInt();
			startState.add(value);
		}
		int[] Positions = new int[TOTAL_QUEENS];
		for (int i = 0; i < startState.size(); i++) 
		{
			Positions[i] = startState.get(i);
		}
		in.close();
		return Positions;
	}

	public void placeQueens() {
		queenPositions = generateQueens();
		for (int i = 0; i < board.length; i++) {
			board[queenPositions[i]][i] = 1;
		}
	}

	public void placeQueens2() 
	{
		for (int i = 0; i < board.length; i++) 
		{
			board[queenPositions[i]][i] = 1;
		}
	}

	public int h() 
	{
		int totalPairs = 0;
		// checking rows
		for (int i = 0; i < board.length; i++) {
			ArrayList<Boolean> pairs = new ArrayList<Boolean>();
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == 1) 
				{
					pairs.add(true);
				}

			}
			if (pairs.size() != 0)
				totalPairs = totalPairs + (pairs.size() - 1);
		}

		int rows = board.length;
		int cols = board.length;
		int maxSum = rows + cols - 2;

		for (int sum = 0; sum <= maxSum; sum++) 
		{
			ArrayList<Boolean> pairs = new ArrayList<Boolean>();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (i + j - sum == 0) {
						if (board[i][j] == 1) {
							pairs.add(true);
						}
					}
				}

			}
			if (pairs.size() != 0)
				totalPairs = totalPairs + (pairs.size() - 1);
		}

		int pairs = checkMirrorDiagonal();

		return totalPairs + pairs;
	}
	
	private int checkMirrorDiagonal() 
	{

		int[] b1 = { board[7][0] };
		int[] b2 = { board[7][1], board[6][0] };
		int[] b3 = { board[7][2], board[6][1], board[5][0] };
		int[] b4 = { board[7][3], board[6][2], board[5][1], board[4][0] };
		int[] b5 = { board[7][4], board[6][3], board[5][2], board[4][1], board[3][0] };
		int[] b6 = { board[7][5], board[6][4], board[5][3], board[4][2], board[3][1], board[2][0] };
		int[] b7 = { board[7][6], board[6][5], board[5][4], board[4][3], board[3][2], board[2][1], board[1][0] };
		int[] b8 = { board[7][7], board[6][6], board[5][5], board[4][4], board[3][3], board[2][2], board[1][1], board[0][0] };
		int[] b9 = { board[6][7], board[5][6], board[4][5], board[3][4], board[2][3], board[1][2], board[0][1] };
		int[] b10 = { board[5][7], board[4][6], board[3][5], board[2][4],board[1][3], board[0][2] };
		int[] b11 = { board[4][7], board[3][6], board[2][5], board[1][4],board[0][3] };
		int[] b12 = { board[3][7], board[2][6], board[1][5], board[0][4] };
		int[] b13 = { board[2][7], board[1][6], board[0][5] };
		int[] b14 = { board[1][7], board[0][6] };
		int[] b15 = { board[0][7] };

		int totalPairs = 0;

		totalPairs += checkMirrorHorizontal(b1);
		totalPairs += checkMirrorHorizontal(b2);
		totalPairs += checkMirrorHorizontal(b3);
		totalPairs += checkMirrorHorizontal(b4);
		totalPairs += checkMirrorHorizontal(b5);
		totalPairs += checkMirrorHorizontal(b6);
		totalPairs += checkMirrorHorizontal(b7);
		totalPairs += checkMirrorHorizontal(b8);
		totalPairs += checkMirrorHorizontal(b9);
		totalPairs += checkMirrorHorizontal(b10);
		totalPairs += checkMirrorHorizontal(b11);
		totalPairs += checkMirrorHorizontal(b12);
		totalPairs += checkMirrorHorizontal(b13);
		totalPairs += checkMirrorHorizontal(b14);
		totalPairs += checkMirrorHorizontal(b15);
		return totalPairs;
	}

	public void moveQueen(int row, int col) 
	{
		board[queenPositions[col]][col] = 2;
		board[row][col] = 1;

	}

	private int checkMirrorHorizontal(int[] b) 
	{
		int totalPairs = 0;
		ArrayList<Boolean> pairs = new ArrayList<Boolean>();
		for (int i = 0; i < b.length; i++) 
		{
			if (b[i] == 1)
				pairs.add(true);
		}
		if (pairs.size() != 0)
			totalPairs = (pairs.size() - 1);
		return totalPairs;
	}

	public void resetQueen(int row, int col) 
	{
		if (board[row][col] == 1)
			board[row][col] = 0;
	}

	public void resetBoard(int col) {

		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == 2)
				board[i][col] = 1;
		}
	}

	public void placeBestQueen(int col, int queenPos) 
	{

		for (int i = 0; i < board.length; i++) 
		{
			if (board[i][col] == 1)
				board[i][col] = 2;

		}
		board[queenPos][col] = 1;
		for (int i = 0; i < board.length; i++) 
		{
			if (board[i][col] == 2)
				board[i][col] = 0;

		}
	}

	public void printBoard() 
	{
		for (int i = 0; i < board.length; i++) 
		{
			for (int j = 0; j < board[i].length; j++) 
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
