import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Ex1 extends Basic
{
  public static void main(String[] args)
  {
    Ex1 a = new Ex1("Basic Text Editor", 0, 0, 880, 580);
  }
  private String theLine;
  private double x, y, middleOfScreen;
  private WList<String> strings = new WList();
  private String fileName;
  private int selectedLine;
  private double distanceLine;
  private int firstTimeFlag = 1;
  private int offEndFlag = 0;
  
  public Ex1( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);
    // code to initialize instance variables before animation begins:
    fileName = FileBrowser.chooseFile( true );
    if( fileName.equals( "" ) )
    {
        // make an empty list
    }   
    else
    {
        int lines = 0;
        try
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                while (reader.readLine() != null) 
                {
                    lines++;
                }
            }
        }
        catch(Exception e)
        {
        }
        if( fileName.equals( "" ) )
        {
        }
        else
        {
            try
            {
                Scanner input = new Scanner( new File( fileName ) );
                for (int i=0; i <= lines; i++)
                {
                    String a = input.nextLine();
                    strings.append(a);
                }
            }
            catch(Exception e)
            {
                System.out.println("Oops: " + e );
            }  
        }
    }
    x = 5;  y = 48.5;

    // code to finish setting background window:
   
  
    setBackgroundColor( new Color( 64, 64, 64 ) );

    // code to set up camera(s)
  
  
    cameras.add( new Camera( 20, 50, 400, 420, 0, 100, 0, new Color( 255, 255, 255 ) ) );
    cameras.add( new Camera( 20, 490, 740, 50, 0, 50, 0, new Color( 0, 0, 0 ) ) );
    // start up the animation:
    
    super.start();
    
  }
  public void step()
  {
    // code to update the world and display the world:
    Camera cam = cameras.get(0);
    if( x > cam.getRegionWidth() )
    {
      x = 1;
    }
    cam.activate();
    cam.setColor( Color.black );
    for (int i = 0 ; i < strings.size() ; i++)
    {
		
        cam.drawText( strings.get(i), x, y-i*5 );
    }
    middleOfScreen = cam.getRegionBottom()+cam.getRegionHeight()/50 + 5;
    double nearestDistance = 100000;
    int nearestString = 0;
    for (int i = 0 ; i < strings.size(); i++){
        double distance = Math.abs(middleOfScreen+i*5);
        if (distance <= nearestDistance) 
        {
            nearestString = i;
            nearestDistance = distance;
            distanceLine=middleOfScreen+i*5 + 5;
        }
        selectedLine = nearestString;
    }
    offEndFlag = 0;
    cam.setColor( Color.black );
    cam.getRegionHeight();
    if (middleOfScreen<-2.9-5*strings.size()+10)
    {
        offEndFlag = 1;
        cam.setColor( Color.red );
    }

    cam.fillTri(0, -0.5+cam.getRegionBottom()+cam.getRegionHeight()/2 , 
                0, 5.5+cam.getRegionBottom()+cam.getRegionHeight()/2, 3,
                cam.getRegionBottom()+cam.getRegionHeight()/2+2.5);
                
    if (firstTimeFlag==1)
    {
        cam.shiftRegion (0,-0.04761904761904761904761904761905);
        firstTimeFlag=0;
    }
    theLine = strings.get(selectedLine);
    //
    cam = cameras.get(1);
    cam.activate();

    double cx = cam.getRegionLeft()+ cam.getRegionWidth()/2;
    double cy = cam.getRegionBottom() + cam.getRegionHeight()/2;
    
    cam.setFont( new Font( "Geneva", Font.PLAIN, 14 ) );
    cam.setColor( Color.white );
    cam.drawCenteredText( fileName, cx, cy );
    if (offEndFlag == 1 && strings.size() ==0)
    {
        strings.append("");
    }
  }
  public void keyTyped( KeyEvent e )
  {

    //to add characters
    char key = e.getKeyChar();
    if( ' '<=key && key<='~' ) //user typed in ascii
    {
        if (offEndFlag ==1)
                {
                    Camera cam = cameras.get(0);
                    //cam.shiftRegion (0,-0.04761904761904761904761904761905);
                    strings.append("");
                    theLine="";
                    selectedLine++;
                }
        String temp = Character.toString(key);
        strings.toString();
        theLine += temp;
        strings.replace(selectedLine, theLine);
    }
  }
  public void keyPressed( KeyEvent e )
  {
    Camera cam = cameras.get(0);
    int code = e.getKeyCode();
                    System.out.println(code);
    if (code==40) //down
    {
        if (distanceLine>5)
        {

            cam.shiftRegion (0,-0.04761904761904761904761904761905);
        }
    }
    if (code==38) //up
    {
        if (middleOfScreen < 2.0)
        {
            cam.shiftRegion (0,0.04761904761904761904761904761905);
        }
    }
    if (code == 10) //enter
    {
        strings.insert(selectedLine, "");
    }
    
    if (code == 8) //backspace
         { 
            if (theLine.length()==0)
            {
                if (offEndFlag==1)
                {
                    cam.shiftRegion (0,0.04761904761904761904761904761905);
                }
                if (strings.get(selectedLine).equals(""))
                {
                    strings.remove(selectedLine);    
                }
                else
                {
                    strings.remove(selectedLine);
                }
            }
            else
            {
                theLine = theLine.substring(0, theLine.length() - 1);
                strings.replace(selectedLine, theLine);
            }
         }      
         
    if (code == 27)  //esc
     {
      if( save() )
        System.exit(0);
    }
    if (code == 27) // esc2 exits program without save, if blank file is opened
    { System.exit(0);
    }
    
  }
      private boolean save()
  {
    try{
      PrintWriter output = new PrintWriter( new File( fileName ) );
      
      for( int k=0; k<strings.size(); k++ )
      {
        output.println( strings.get(k) );
      }

      output.close();
      return true;
    }
    catch(Exception e)
    {
      System.out.println("Oops: " + e );
      return false;
    }
   
  }
}
