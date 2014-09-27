import java.util.Scanner;
import java.awt.Color;

public class Disk
{
  public static Color haloColor = Color.pink;

  // instance variables:
  private double x, y, r;  // center=(x,y), radius=r
  private int red, green, blue;

  public Disk( double xIn, double yIn, double rIn,
               int redIn, int greenIn, int blueIn )
  {
    x = xIn;
    y = yIn;
    r = rIn;
    red = redIn;
    green = greenIn;
    blue = blueIn;
  }

  public Disk( Scanner input )
  {
    x = input.nextDouble();
    y = input.nextDouble();
    r = input.nextDouble();
    red = input.nextInt();
    green = input.nextInt();
    blue = input.nextInt();
  }

  public void draw( Camera cam, boolean special )
  {
    cam.setColor( new Color( red, green, blue ) );
    cam.fillCircle( x, y, r );    

    if( special )
    {
      cam.setColor( haloColor );
      cam.drawCircle( x, y, 1.1*r );    
    }
  }

  public void changeSize( double dr )
  {
    r += dr;
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
    return x + " " + y + " " + r + " " + red + " " + green + " " + blue;
  }

}
