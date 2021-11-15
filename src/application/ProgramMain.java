package application;

import boardgame.Board;
import chess.ChessMatch;

public class ProgramMain {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
		
	}

}
