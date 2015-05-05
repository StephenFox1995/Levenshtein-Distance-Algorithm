package levenshtein;

public class Main {
	public static void main(String[] args) {
				
		String a = "DIT";
		String b = "TIM";
		
		int distance = (int)EditDistance.minimumEditDistance(a, b);
		
		System.out.println(distance);
		
		
		
	}
}
