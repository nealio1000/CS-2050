import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class Ex1 extends Basic
{
	public static void main(String[] args)
	{
    // example: hard-coded location and size of window:
    Ex1 a = new Ex1(" The Cruel and Spiteful Text Editor  ", 0, 0, 800, 600);

	}

	// instance variables for the application:
	// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	private OurArrayList textList;
	private String currentLine;
	private String fileName;
	private double x, y;
	private int index;
	private int currentIndex;
	private String line1;
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	public Ex1( String title, int ulx, int uly, int pw, int ph )
	{
		super(title,ulx,uly,pw,ph);

		// code to initialize instance variables before animation begins:
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		textList = new OurArrayList();
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		// load file here:
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		
			int lines = 0;
			try
			{
				Scanner input = new Scanner(new FileReader("test.txt"));
				
					while (input.hasNext()) 
					{
						String a = input.nextLine();
						textList.add(a);
						lines++;
					}
					System.out.println(lines + " lines found");
			}
			catch(Exception e)
			{
				System.out.println("You done goofed! " + e );
			}  

			currentIndex = 0;
			currentLine(currentIndex);
			line1 = textList.get(currentIndex);
			
			x = 5;
			y = 40;
			//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
	
			// code to finish setting up entire window
			// (change Color as desired):
			// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		
			setBackgroundColor( new Color( 100, 128, 200 ) );
		
			// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
			// code to set up camera(s)
			// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
			cameras.add( new Camera( 20, 50, 700, 500, 0, 100, 0, 
                     new Color( 255, 255, 255) ) );
			// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  
			//------------------------------------------------------------------
			// start up the animation:
			super.start();
		}
	
	public void currentLine(Integer currentIndex)
	{
		currentLine = textList.get(currentIndex);
		
		System.out.println("The Current Line is: " + currentLine);
	}
	public void step()
	{
		// code to choose a camera, activate it,
		// change instance variables as needed,
		// and display things in the camera
		// (need this chunk of code for each camera)
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		Camera cam = cameras.get(0);
		int i;
		cam.activate();
		cam.setColor(Color.black);
		for (i = 0 ; i < textList.size() ; i++)
		{
			cam.drawText( textList.get(i), x, y-i*3);
		}
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	}

	public void keyTyped( KeyEvent e )
	{
		char key = e.getKeyChar();
		
		// code to change instance variables depending 
		// on which standard key was typed (pressed and released):
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		if( ' '<=key && key<='~' ) //user typed in ascii (THIS CODE WILL LIKELY SCREW UP THE TEXT WHEN TYPING, BEWARE!!)
		{
			Camera cam = cameras.get(0);
			cam.shiftRegion (0,-0.05);
			textList.add("");
			line1="";
			currentIndex++;
		}
        
        textList.add(currentIndex, line1);
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	}

	public void keyPressed( KeyEvent e )
	{
		Camera cam = cameras.get(0);
		int code = e.getKeyCode();
		
    
		// code to change instance variables depending 
		// on which special key was pressed:
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
		if (code == 40) //user presses down
		{
			if(currentIndex <= textList.size())
			{
				cam.shiftRegion (0,-0.05);
				currentLine(currentIndex += 1);
			}
		}
		if (code==38) //user presses up
		{
			if(currentIndex > 0)
			{
				cam.shiftRegion (0,0.05);
				currentLine(currentIndex -= 1);
			}	
			
        }
        if (code == 10) //user presses enter
        {  
			textList.add(currentIndex, "\n");  
        }
        if (code == 27)  //esc
		{
			System.exit(0);
		}  
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	}
}
