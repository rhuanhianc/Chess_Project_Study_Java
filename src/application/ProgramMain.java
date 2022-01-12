package application;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosiotion;
import java.util.Scanner;
import chess.ChessException;


public class ProgramMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true){		
		try{
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosiotion source = UI.readChessPosition(sc);
			System.out.println();
			System.out.print("Target: ");
			ChessPosiotion target = UI.readChessPosition(sc);
			ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
		}catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}

		}
	}
//		Board board = new Board(8, 8);
	}


