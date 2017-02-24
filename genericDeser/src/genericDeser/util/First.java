
package genericDeser.util;


public class First {
	
	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;
	
	public First()
	{
		
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result
				+ ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float
				.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

	
	
	
	
	public int getIntValue() {
		return IntValue;
	}

	public void setIntValue(int iIn) {
		IntValue = iIn;
	}

	public float getFloatValue() {
		return FloatValue;
	}

	public void setFloatValue(float fIn) {
		FloatValue = fIn;
	}

	public short getShortValue() {
		return ShortValue;
	}

	public void setShortValue(short shIn) {
		ShortValue = shIn;
	}

	public String getStringValue() {
		return StringValue;
	}

	public void setStringValue(String stIn) {
		StringValue = stIn;
	}
	
	
	
	
	
	

}
