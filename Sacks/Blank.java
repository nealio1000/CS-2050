import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class Blank extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    Blank a = new Blank("   ", 0, 0, 600, 400);

  }

  // instance variables for the application:
  // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

  // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

  public Blank( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    // code to finish setting up entire window
    // (change Color as desired):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


    setBackgroundColor( new Color( 128, 128, 200 ) );
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
    // code to set up camera(s)
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

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

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending 
    // on which standard key was typed:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending 
    // on which special key was typed:
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
