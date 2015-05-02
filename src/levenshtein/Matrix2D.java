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
		this.cells = new float[rowAmount][colAmount];
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
		
		int rows = a.getRowAmount();
		int cols = b.getColAmount();
		
		Matrix2D c = new Matrix2D(rows, cols);
		
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				
				float sum = 0.0f;
				
				for(int i = 0; i < cols; col++) {
					sum += a.getCell(row, i) * b.getCell(i, col);
				}
				c.setCellValue(row, col, sum);
			}
		}
		return c;
	}


	
	// Instance Methods
	
	
	// Adds another Matrix2D object to this instance.
	// @param b: The Matrix2D object to add to this instance.
	public void add(Matrix2D b) {
		
		int rows = b.getRowAmount();
		int cols = b.getColAmount();
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				setCellValue(row, col, getCell(row, col) + b.getCell(row, col));
				cells[row][col] = cells[row][col] + b.cells[row][col];
			}
		}
	}
	
	
	
	// Multiplies another Matrix2D object to this instance.
	// @param b: The Matrix2D object to multiply to this instance.
	public void mult(Matrix2D b) {
		
		int rows = b.getRowAmount();
		int cols = b.getColAmount();
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				
				float sum = 0.0f;
				
				for(int i = 0; i < cols; i++) {
					sum += getCell(row, i) * b.getCell(i, col);
				}
				setCellValue(row, col, sum);
			}
		}
	}
	
	
	
	
	// Identity Matrix representation of this instance. 
	public void indentity() {
		
		for(int row = 0; row < rowAmount; row++) {
			for(int col = 0; col < colAmount; col++) {
				setCellValue(row, col, (row == col) ? 1 : 0);
			}
		}
		
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
	
	
	
	// @return Returns: A 'Matrix Style' representation the Matrix2D.
	@Override
	public String toString() {
		String returnString = "";
		
		for(int row = 0; row < rowAmount; row++) {
			for(int col = 0; col < colAmount; col++) {
				returnString += getCell(row, col) + " ";
			}
			returnString += "\n";
		}
		return returnString;
	}
}