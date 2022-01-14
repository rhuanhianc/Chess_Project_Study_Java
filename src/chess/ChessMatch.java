package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;
import boardgame.Piece;

public class ChessMatch {
	
	private Board board;
	private int turn;
	private Color currentPlayer;
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	public int getTurn(){
		return turn;
	}
	public Color getCurrentPlayer(){
		return currentPlayer;
	}
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0;j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	public boolean[][] possibleMoves(ChessPosiotion sourcePostion) {
		Position position = sourcePostion.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	public ChessPiece perfomChessMove(ChessPosiotion sourcePosition, ChessPosiotion targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece) capturedPiece;
	}

	private void validateSourcePosition(Position source) {
		if(!board.thereIsAPiece(source)) {
			throw new ChessException("There is no piece on source position");
		}
		if(currentPlayer != ((ChessPiece)board.piece(source)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if(board.piece(source).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the piece on source position");
		}
	}
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The target position is occupied by the same color");
		}
	}
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosiotion(column, row).toPosition());
	}
	private void nextTurn(){
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	private void initialSetup() {
		placeNewPiece('b', 6,new Rook(board, Color.WHITE));
		placeNewPiece('e', 8,new King(board, Color.BLACK));
		placeNewPiece('e', 1,new King(board, Color.WHITE));
		placeNewPiece('d', 8,new Rook(board, Color.BLACK));
		placeNewPiece('d', 1,new Rook(board, Color.WHITE));
		

	}
}
