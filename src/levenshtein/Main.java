package levenshtein;

public class Main {
	public static void main(String[] args) {
		
		Matrix2D matrix = new Matrix2D(10, 10);
		
		for(int i = 0; i < matrix.getRowAmount(); i++) {
			for(int j = 0; j < matrix.getColAmount(); j++) {
				System.out.println(i + j);
				matrix.setCellValue(i, j, 1);
			}
		}
		
		matrix.toString();
	}
}
