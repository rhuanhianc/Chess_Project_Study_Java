package application;
import chess.Color;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosiotion;

public class UI {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";	
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public static ChessPosiotion readChessPosition(Scanner sc) {
		try{
		String s = sc.nextLine();
		char column = s.charAt(0);
		int row = Integer.parseInt(s.substring(1));
		return new ChessPosiotion(column, row);
		}catch(RuntimeException e) {
			System.out.println("Erro na leitura da posição");
			return null;
		}
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for(int i =0; i<pieces.length; i++) {
			System.out.print((8-i) + " ");
			for(int j = 0; j< pieces.length; j++) {
				printPiece(pieces[i][j],false);
				
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	}
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i =0; i<pieces.length; i++) {
			System.out.print((8-i) + " ");
			for(int j = 0; j< pieces.length; j++) {
				printPiece(pieces[i][j],possibleMoves[i][j]);	
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	public static void printPiece(ChessPiece piece, boolean background) {
		if(background){
			System.out.println(ANSI_BLUE_BACKGROUND);
		}
		if(piece == null) {
			System.out.print("  ");
		}
		else{
			if(piece.getColor() == Color.BLACK) {
				System.out.print(ANSI_BLACK + piece + ANSI_RESET);
			}
			else {
				System.out.print(ANSI_RED + piece+ ANSI_RESET);
			}
		}
	}

}
