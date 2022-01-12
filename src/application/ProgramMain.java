package application;



import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosiotion;
import java.util.Scanner;


public class ProgramMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true){
		UI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.print("Source: ");
		ChessPosiotion source = UI.readChessPosition(sc);
		System.out.println();
		System.out.print("Target: ");
		ChessPosiotion target = UI.readChessPosition(sc);
		ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
	}
//		Board board = new Board(8, 8);
	}

}
