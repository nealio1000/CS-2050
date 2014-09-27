import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class BlockGame2 extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    BlockGame2 a = new BlockGame2("Exciting Food Game", 0, 0, 600, 600);

  }

  // instance variables for the application:
  // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
  Block player;
  BlockSack2 sack;

  // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

  public BlockGame2( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    int xSize = 100;

    sack = new BlockSack2();
    player = new Block( new Key(xSize/2,xSize/2), "player" );
    sack.add( player );


    Random rng = new Random();

    int count = 0;
    int k;
    for( k=0; count<99; k++ )
    {
      Key temp = new Key( rng.nextInt(xSize), rng.nextInt(xSize) ); 
      if( ! sack.find( temp ) )
      {
        sack.add( new Block( temp, rng.nextInt(2)==1 ? "food" : "lava"  ) );   
        count++;
      }
    }
    System.out.println("Had to try " + k + " spots" );

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    // code to finish setting up entire window
    // (change Color as desired):
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


    setBackgroundColor( new Color( 128, 128, 200 ) );
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
    // code to set up camera(s)
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    cameras.add( new Camera( 5, 30, 500, 500, 0, 100, 0, Color.white ) );

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
    
    sack.initForTraverse();
    while( sack.hasNext() )
    {
      sack.next().draw( cam );
    }

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

    if( code == KeyEvent.VK_LEFT )
      move( player, -1, 0 );
    else if( code == KeyEvent.VK_RIGHT )
      move( player, 1, 0 );
    else if( code == KeyEvent.VK_DOWN )
      move( player, 0, -1 );
    else if( code == KeyEvent.VK_UP )
      move( player, 0, 1 );

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  }

  private void move( Block block, int dx, int dy )
  {
    if( sack.find( new Key( block.getKey().x + dx, block.getKey().y + dy ) ) )
    {// depending on the kind of block, eat it or die
      Block temp = sack.get();
      if( temp.getKind().equals( "lava" ) && 
          block.getKind().equals("player")
        )
      {// die
        System.exit(1);
      }
      else if( temp.getKind().equals( "food" ) &&
               block.getKind().equals("player")
             )
      {// eat the food
        // later:  make the player happier
        sack.remove();
        block.move( dx, dy, sack );
      }
    }
    else
    {
      block.move( dx, dy, sack );
    }
  }// move

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
