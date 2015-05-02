package levenshtein;

public class EditDistance {
	
	private static float min(float a, float b, float c) {
		
		if((a < b) && (a < c)) {
			return a;
		}
		if((b < a) && (b < c)) {
			return b;
		}
		return c;
	}
	
	
	// Returns the calculated distance from the two string 'needle' & 'haystack'
	public static float minimumEditDistance(String needle, String haystack) {
		
		int rows = needle.length() + 1;
		int cols = haystack.length() + 1;
		
		Matrix2D m = new Matrix2D(rows, cols);
		
		for(int row = 0; row < rows; row++) {
			m.setCellValue(row, 0, row);
		}
		for(int col = 0; col < cols; col++) {
			m.setCellValue(0, col, col);
		}
		
		
		for(int row = 1; row < rows; row++) {
			for(int col = 1; col < cols; col++) {
				if(haystack.charAt(col - 1) == needle.charAt(row - 1)) {
					
					m.setCellValue(row, col, m.getCell(row - 1, col - 1));
				} 
				else {
					float min = min(m.getCell(row - 1, col - 1), 
							m.getCell(row, col - 1), 
							m.getCell(row - 1, col));
					
					m.setCellValue(row, col, min + 1);
				}
			}
		}
		System.out.println("MATRIX:");
		System.out.println(m);
		return m.getCell(rows - 1, cols - 1);
	}
	
}
