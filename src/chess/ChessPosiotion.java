package chess;

import boardgame.Position;

public class ChessPosiotion {
	
	private char column;
	private int row;
	
	public ChessPosiotion(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Errosr instanciando chess posrtion não esta um valor valido");
		}
		this.column = column;
		this.row = row;
	}
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	protected static ChessPosiotion fromPosition(Position position) {
		return new ChessPosiotion((char)('a' + position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString(){
		return "" + column + row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}

}
