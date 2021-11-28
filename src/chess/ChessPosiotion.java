package chess;

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
	
}
