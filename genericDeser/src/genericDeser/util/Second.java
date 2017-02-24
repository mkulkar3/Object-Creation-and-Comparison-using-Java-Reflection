package genericDeser.util;



public class Second {
	
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;
	
	
	public Second()
	{
		
	}


	public int getIntValue() {
		return IntValue;
	}


	public void setIntValue(int iIn) {
		IntValue = iIn;
	}


	public double getDoubleValue() {
		return DoubleValue;
	}


	public void setDoubleValue(double dIn) {
		DoubleValue = dIn;
	}


	public boolean isBooleanValue() {
		return BooleanValue;
	}


	public void setBooleanValue(boolean bIn) {
		BooleanValue = bIn;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		//System.out.println("in equals.......");
		
		
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
	
		/*System.out.println(other);
		System.out.println(this);*/
		
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double
				.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Second [IntValue=" + IntValue + ", DoubleValue=" + DoubleValue
				+ ", BooleanValue=" + BooleanValue + "]";
	}
	
	
	
	
	
	
	
	

}
