import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class textEditor extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    textEditor a = new textEditor(" Happy Fun Text Editor  ", 20, 20, 1000, 800);

  }

  // instance variables for the application:
  // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
  private OurArrayList<String> textList;
  private int current;
  private String fileName;
 
  // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

  public textEditor( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
   textList = new OurArrayList<String>();
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     // load file here:
     try
    {
      
      Scanner input = new Scanner(new FileReader("test.txt"));
	  String line;
	  for(int i = 0; i < textList.size(); i++)
	  {
		  line = input.nextLine();
		  textList.add(line);
		  System.out.println(line);
	  }
      //while( input.hasNext() )
      //{
        
        //line = input.nextLine();
        //input.nextLine();
        //System.out.println(line);
        //textList.add( new String( line ) );
        
      //}// loop to read lines of data

      
    }
    catch(Exception e)
    {
      System.out.println("something went wrong");
      System.exit(1);
    }
    // code to finish setting up entire window
    // (change Color as desired):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


    setBackgroundColor( new Color( 100, 40, 200 ) );
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
    // code to set up camera(s)
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
      cameras.add( new Camera(30, 40, 900, 750, 0, 100, 0, 
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
    
    //for( int k=0; k<textList.size(); k++ )
    //{
      //if( k==current )
        //textList.get(k).draw( cam, true );
      //else
        //textList.get(k).draw( cam, false );
    //}
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending 
    // on which standard key was typed (pressed and released):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending 
    // on which special key was pressed:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyReleased( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending 
    // on which special key was released:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
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
