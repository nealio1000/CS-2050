import java.util.Scanner;
import java.awt.Color;

public class Disk
{
	public static Color currentLineColor = Color.red;

	// instance variables:
	private double x, y;  // center=(x,y)
	private int red, green, blue;

	public Disk( double xIn, double yIn, int redIn, int greenIn, int blueIn )
	{
		x = xIn;
		y = yIn;
		red = redIn;
		green = greenIn;
		blue = blueIn;
	}

	public void draw( Camera cam, boolean special )
	{
		cam.setColor( new Color( red, green, blue ) );

		if( special )
		{
			cam.setColor(currentLineColor );
			  
		}
	}

	public void changeColor( int dred, int dgreen, int dblue )
	{
		red = change( red, dred );
		green = change( green, dgreen );
		blue = change( blue, dblue );
	}

	// given a value for x in [0,255], add dx, but make
	// sure it stays in [0,255] 
	private int change( int x, int dx )
	{
		x += dx;

		if( x < 0 )
			x = 0;
		else if( x > 255 )
			x = 255;

		return x;
	}

	public String toString()
	{
		return x + " " + y + " " + red + " " + green + " " + blue;
	}
}
