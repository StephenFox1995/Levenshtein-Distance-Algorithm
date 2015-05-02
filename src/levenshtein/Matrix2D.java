package levenshtein;

class Matrix2D {
	
	private int rowAmount;
	private int colAmount;
	private float[][] cells;
	
	
	// @param rows: The  number of rows for the matrix.
	// @param cols: The  number of columns for the matrix. 
	public Matrix2D(int rows, int cols) {		
		this.rowAmount = rows;
		this.colAmount = cols;
		this.cells = new float[rows][cols];
	}


	// Factory Methods.
	
	// @param a : Matrix2D object.
	// @param b : Matrix2D object.
	// @return Matrix2D: A new Matrix2D object with a and b added together.
	public static Matrix2D add(Matrix2D a, Matrix2D b) {
		
		int cols = a.getColAmount();
		int rows = a.getRowAmount();
		
		Matrix2D c = new Matrix2D(rows, cols);
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				c.setCellValue(row, col, 
						a.getCell(row, col) + b.getCell(row, col));
				
			}
		}
		return c;
	}
	
	
	
	
	// @param a : Matrix object.
	// @param b : Matrix object.
	// @return MAtrix2D: A new Matrix2D object with a and b added together.
	public static Matrix2D mult(Matrix2D a, Matrix2D b) {
		
		int cols = a.getColAmount();
		int rows = a.getRowAmount();
		
		Matrix2D c = new Matrix2D(rows, cols);
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				c.setCellValue(row, col, 
						a.getCell(row, col) * b.getCell(row, col));
				
			}
		}
		return c;
	}



	
	
	
	// Accessor methods.
	
	// @return int: The number of rows within the matrix.
	public int getRowAmount() {
		return rowAmount;
	}
	
	
	// @return int: The number of columns within the matrix.
	public int getColAmount() {
		return colAmount;
	}
	
	
	
	// @param row: The index of the row.
	// @param col: The index of the column.
	// @param value: The value to set at the row-col index.
	public void setCellValue(int row, int col, float value) {
		cells[row][col] = value;
	} 
	
	
	
	// @param row: The index of the row.
	// @param col: The index of the column.
	// @return float: The value held at the desired index within the matrix.
	public float getCell(int row, int col) {
		return cells[row][col];
	}
	
}