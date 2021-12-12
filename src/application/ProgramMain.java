package application;



import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import chess.ChessMatch;

public class ProgramMain {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
		
//		Board board = new Board(8, 8);
	}

}
