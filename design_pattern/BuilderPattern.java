package design_pattern;

public class BuilderPattern {
	public static class Builder{
		private String name;
		private Integer number;
		
		public Builder withName(final String name){
			this.name = name;
			
			return this;
		}
		
		public Builder withNumber(final int number){
			this.number = number;
			
			return this;
		}
		
		public BuilderPattern build(){
			if(null == name || null == number)
				throw new IllegalStateException("cannot create BuilderPattern");
			
			return new BuilderPattern(name, number);
		}
	}
	
	private String name;
	private Integer number;
	
	private BuilderPattern(String name, Integer number){
		this.name = name;
		this.number = number;
	}
	

}
