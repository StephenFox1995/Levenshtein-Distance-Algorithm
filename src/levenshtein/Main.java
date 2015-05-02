package levenshtein;

public class Main {
	public static void main(String[] args) {
				
		String a = "Today, it was sunny";
		String b = "Today, it was raining";
		
		int distance = (int)EditDistance.minimumEditDistance(a, b);
		
		System.out.println(distance);
		
		
		
	}
}
