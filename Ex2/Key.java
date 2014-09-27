public class Key
{
	public int x, y;

	public Key( int xIn, int yIn )
	{
		x=xIn; y=yIn;
	}

	public int compareTo( Key other )
	{
		if( y == other.y )
		{
			return x - other.x;
		}
		else
			return y - other.y;
	}	

	public boolean equals( Key other )
	{
		return compareTo( other ) == 0;
	}

	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
}
