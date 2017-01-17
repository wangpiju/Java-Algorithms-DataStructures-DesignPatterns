package algorithms;

public class Reverse {

	public static void main(String[] args) {
		
		System.out.println(inPlaceReverse("jason"));
	}
	
	//normal reverse, but waste space
	public static String reverse(String s){
		final StringBuilder builder = new StringBuilder(s.length());
		
		for(int i = s.length() - 1; i >= 0; i--){
			builder.append(s.charAt(i));
		}
		
		return builder.toString();
	}
	
	//improvement
	public static String inPlaceReverse(String s){
		final StringBuilder builder = new StringBuilder(s);
		
		for(int i=0; i < (builder.length() / 2); i++){
			final char tmp = builder.charAt(i);
			final int otherEnd = builder.length() - i - 1;
			builder.setCharAt(i, builder.charAt(otherEnd));
			builder.setCharAt(otherEnd, tmp);
		}
		
		return builder.toString();
	}

}
