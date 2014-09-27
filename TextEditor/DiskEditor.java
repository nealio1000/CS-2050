import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class DiskEditor extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    DiskEditor a = new DiskEditor("Disk Editor", 
                                    0, 0, 500, 500);

  }

  // instance variables for the application:
  // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
  private ArrayList<Disk> list;  // the list of all the disks
  private int current;  // the position in the list of the special disk
  private String fileName;  // the selected file name
  // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

  public DiskEditor( String title, int ulx, int uly, int pw, int ph ) 
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    list = new ArrayList<Disk>();
    // load file here:

    try
    {
      fileName = FileBrowser.chooseFile( true );
      Scanner input = new Scanner( new File( fileName ) );

      while( input.hasNext() )
      {
        double x, y, r;
        int red, green, blue;
        x = input.nextDouble();
        y = input.nextDouble();
        r = input.nextDouble();
        red = input.nextInt();
        green = input.nextInt();
        blue = input.nextInt();
        input.nextLine();
        list.add( new Disk( x, y, r, red, green, blue ) );
      }// loop to read lines of data

      input.close();
    }
    catch(Exception e)
    {
      System.out.println("something went wrong");
      System.exit(1);
    }

/*  originally hard-coded some disks:
    list.add( new Disk( 50, 50, 10, 255, 0, 0 ) );
    list.add( new Disk( 25, 40, 2, 0, 255, 0 ) );
    list.add( new Disk( 90, 90, 5, 255, 255, 0 ) );
*/
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    // code to finish setting up entire window
    // (change Color as desired):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


    setBackgroundColor( new Color( 0, 0, 0 ) );
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
    // code to set up camera(s)
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    cameras.add( new Camera( 20, 50, 400, 400, 0, 100, 0, 
                     new Color( 200, 200, 200 ) ) );

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
    //------------------------------------------------------------------
    // start up the animation:
    super.start();
  }

  public void step()
  {
    // code to choose a camera, activate it,
    // change instance variables as needed,
    // and display things in the camera
    // (need this chunk of code for each camera)
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    Camera cam = cameras.get(0);
    cam.activate();

    // draw all the disks:
    for( int k=0; k<list.size(); k++ )
    {
      if( k==current )
        list.get(k).draw( cam, true );
      else
        list.get(k).draw( cam, false );
    }

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending 
    // on which standard key was typed (pressed and released):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    if( key == 'r' )
    {
      list.get(current).changeColor( -8, 0, 0 );
    }
    else if( key == 'R' )
    {
      list.get(current).changeColor( 8, 0, 0 );
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending 
    // on which special key was pressed:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    
    if( code == KeyEvent.VK_LEFT )
    {
      if( current > 0 )
        current--;
    }
    else if( code == KeyEvent.VK_RIGHT )
    {
      if( current < list.size()-1 )
        current++;
    }

    else if( (code == KeyEvent.VK_BACK_SPACE ||
              code == KeyEvent.VK_DELETE 
             ) 
             && 
             list.size() > 0 
           )
    {
      list.remove( current );
      if( current == list.size() && list.size() > 0 )
        current--;
    }

    else if( code == KeyEvent.VK_ESCAPE )
    {
      try
      {
        PrintWriter output = new PrintWriter( new File( fileName ) );
      
        for( int k=0; k<list.size(); k++ )
        {
          output.println( list.get(k) );
        }

        output.close();
      }
      catch(Exception e1)
      {
        System.out.println("something went wrong");
        System.exit(1);
      }

    }

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyReleased( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending 
    // on which special key was released:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
  }
    
  public void mouseMoved(MouseEvent e)
  {
    super.mouseMoved(e);

    // code to respond to mouse motion:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mouseDragged(MouseEvent e)
  {
    super.mouseDragged(e);

    // code to respond to mouse motion with a button pressed:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mouseClicked(MouseEvent e)
  {
    super.mouseClicked(e);

    // code to respond to mouse click:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mousePressed(MouseEvent e)
  {
    super.mousePressed(e);

    // code to respond to mouse button press:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    list.add( new Disk( getMouseX(), getMouseY(), 2.5, 255, 255, 255 ) ); 
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mouseReleased(MouseEvent e)
  {
    super.mouseReleased(e);

    // code to respond to mouse button release:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mouseEntered(MouseEvent e)
  {
    super.mouseEntered(e);

    // code to respond to mouse entering window:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void mouseExited(MouseEvent e)
  {
    super.mouseExited(e);

    // code to respond to mouse exiting window:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

}
