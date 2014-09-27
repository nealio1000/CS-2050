import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Ex3 extends Basic
{
	public static void main(String[] args)
	{
		// example: hard-coded location and size of window:
		Ex3 a = new Ex3(" The Cruel and Spiteful Text Editor", 0, 
											0, 800, 600);
	}

	// instance variables for the application:
	// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	private EditableList text;
	private int current;
	private String fileName;
	private String temp;
	private String cursor;
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	public Ex3( String title, int ulx, int uly, int pw, int ph )
	{
		super(title,ulx,uly,pw,ph);

		// code to initialize instance variables before animation begins:
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		text = new EditableList();
		
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		fileName = FileBrowser.chooseFile( true );
     
		if( fileName.equals( "" )  )
		{// make empty list
		}
		else //fill list
		{
			try
			{
				Scanner input = new Scanner( new File( fileName ) );
				while(input.hasNext())
				{
					String a = input.nextLine();
					System.out.println(a);
					text.add(a);
				}
			}
			catch(Exception e)
			{
				System.out.println("You done goofed! " + e );
			}
		}
		
		// code to finish setting up entire window
		// (change Color as desired):
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		setBackgroundColor( new Color( 100, 60, 200 ) );
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 
		// code to set up camera(s)
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		cameras.add( new Camera( 20, 70, 700, 500, 0, 100, 0, 
						 new Color( 255, 255, 255) ) );
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		//------------------------------------------------------------------
		current = text.size()-10;
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
		cam.setColor(Color.black);
		
		int x = 5;
		int	y = 50;
		int cursorX = 2;
		int cursorY = 30;
		String cursor = "-->";
		cam.drawText(cursor, cursorX, cursorY);
		for (int i = current + 10; i > current - 10;i--)
		{
			if(i >=0 && i < text.size())
			{
				cam.drawText( text.get(i), x, y);	
			}
			y-=2;
		}
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	}

	public void keyTyped( KeyEvent e )
	{
		char key = e.getKeyChar();
    
		// code to change instance variables depending 
		// on which standard key was typed (pressed and released):
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		if( ' '<=key && key<='~' )
		{
			String currentLine = text.get(current);
			String s = Character.toString(key);
			text.toString();
			currentLine += s;
			text.set(currentLine);
			System.out.println("The current line is: " 
									+ text.get(current));
		}
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	}

	public void keyPressed( KeyEvent e )
	{
		int code = e.getKeyCode();

		// code to change instance variables depending 
		// on which special key was pressed:
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		if (code == KeyEvent.VK_DOWN) //user presses down
		{
			String a = "";
			if(current == 0 && !text.get(current).equals(""))
			{
				text.add(a);
				text.remove();
				text.up();
				current--;
				System.out.println("The current line is: " 
										+ text.get(current));
			}
			
			if(current > 0)
			{
				text.up();
				current--;
				System.out.println("The current line is: " 
										+ text.get(current));
			}
		}
		if (code == KeyEvent.VK_UP) //user presses up
		{
			if(current < text.size() - 1)
			{
				text.down();
				current++;
				System.out.println("The current line is: " 
										+ text.get(current));
			}
		}
		if (code == KeyEvent.VK_ENTER) //user presses enter
		{
			if(current <= text.size() && current >= 0)
			{
				text.insert(current+2, "" );
				text.down();
				current++;
				System.out.println("The current line is: " 
										+ text.get(current));
			}
		}
		if (code == KeyEvent.VK_BACK_SPACE ) //user presses backspace
		{
			String currentLine = text.get(current);
			if(currentLine.length() == 0 && current >= 0)
			{
				text.remove();
				current--;
				text.up();
				System.out.println("The current line is: " 
										+ text.get(current));
			}
			if(currentLine.length() > 0)
			{
				currentLine = currentLine.substring(0, currentLine.length() - 1);
				text.set(currentLine);
				System.out.println("The current line is: " + 
										currentLine);
			}
		}
		if (code == KeyEvent.VK_ESCAPE)  //user presses escape
		{
			fileName =  FileBrowser.chooseFile( false );
			try
			{
				PrintWriter output = new PrintWriter(new File( fileName) );

				for( int  k=text.size()-1; k>=0; k-- )
				{
					output.println( text.get( k ) );
				}           
          
				output.close();         
			}     
			catch( Exception f )
			{
				System.out.print( "You done goofed! " + f );
			}

			System.exit(0);
		}
	}	 
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
