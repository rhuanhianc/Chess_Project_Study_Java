package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	

	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar Tabuleiro");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	public Piece piece(int row, int column) {
		if(!positionExists(row,column)) {
			throw new BoardException("Erro ao criar Tabuleiro");
		}
		return pieces [row] [column];
		
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro ao criar Tabuleiro");
		}
		return pieces[position.getRow()] [position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("J� tem pe�a");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		
		return row >=0 && row < rows && column >=0 &&  column < columns;
	}
	public Piece removePiece(Position position){
		if(!positionExists(position)){
			throw new BoardException("Erro ao remover peça");
		}
		if(piece(position) == null){
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	public boolean positionExists(Position position) {
	
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Erro ao criar Tabuleiro");
		}
		return piece(position)!= null;
	}

	public String retornarHello() {
		return "Hello, World!";
	}
}
