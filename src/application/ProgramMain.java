package application;



import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import chess.ChessMatch;

public class ProgramMain {

	public static void main(String[] args) {

//		ChessMatch chessMatch = new ChessMatch();
//		UI.printBoard(chessMatch.getPieces());
		

		String[] teste ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		for(int i = 0; i < teste.length; i++) {
			teste[i] = teste[i].toUpperCase();
			System.out.println(teste[i]);
		}
	}

}
