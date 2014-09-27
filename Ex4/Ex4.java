/* Program: Ex4 to implement a huffington tree
            in sorting an input text file by 
            word frequency and allowing the user
            to search for a word by entering a 
            huffington bin code.
            
            
   Written by: John Brown, Calvin Hicks, and Neal Friedman
                           12/10/13
                  
*/

import java.awt.*;
import java.util.*;
import java.io.*;

public class Ex4
{
//instance variables
   private static ArrayList<HuffTree> list = new ArrayList();//to hold incoming words
   private String fileName;
   private static int n;
   private static int freq;
   
//instance methods
   public void input()
   {
   System.out.println("Start of input()");
      try
      {
         fileName = FileBrowser.chooseFile( true );
         Scanner input = new Scanner( new File( fileName ) );
         HuffTree inNode;
         String inWord;//the token grabbed by scanner
         
         while( input.hasNext() )
         {
			inNode = new HuffTree();
            inNode.word = input.next();
            inNode.freq = input.nextInt();
            list.add(inNode);
            System.out.println("Nodes in List: " + inNode.getWord() + " " + inNode.freq);            
         }
                     
         // loop to read words and enter it into the list of words.
         
         input.close();
         
         System.out.println("input.close()");
      }
      catch(Exception e)
      {
         System.out.println("Something went wrong!");
         System.exit(1);
      }
   }

   private void display()
   {
      System.out.println("display() called successfully");
      for(int k = 0; k < list.size(); k++)
      {     
         System.out.println("This is the list: " + list.get(k).getWord() + " " + list.get(k).freq);
      }
   }

//Heapsort class is below because Java didn't want me to use ArrayList<HuffTree> as a param type.

   private static void displayHeap( int n )
   {
      for( int k=0; k<n; k++ )
      {
         System.out.print( list.get(k).freq + " " + list.get(k).getWord() + " " );
      }
      System.out.println();
   }

   public static void heapSort( int n )
   {
      heapify( n );
      sort( n );
   }

  // turn list.get(0)..list.get(a-1) into a heap with same items rearranged
   public static void heapify( int n )
   {
      for( int h=0; h<n; h++ )
      {// let list.get(h), as the new item, go into the heap by swapping up its branch
      
         int kid = h;  // current position of the item being swapped upward
         int parent;   // position of the parent of the kid
      
         while( kid != 0 )
         {
            parent = (kid-1)/2;
         
            if( list.get(kid).freq > list.get(parent).freq )
            {// kid beats parent, swap
               swap( kid, parent );
               kid = parent;
            }
            else
               break;
         }
      }
   
      System.out.print("after heapifying: " );
      displayHeap(n);
   }

  // repeatedly let the largest item move to the bottom
   public static void sort(  int n )
   {
      for( int bottom = n-1; bottom>0   ; bottom-- )
      {// swap list.get(0) and list.get(bottom), let new root item swap its way down
      
         System.out.println("when bottom= " + bottom );
         displayHeap( n );
      
         swap( 0, bottom );
      
         int parent = 0; // location of the dropping item
         int leftKid, rightKid;
         boolean done = false;
      
         while( parent >= 0 )  // what the heck?
         {// have at least one child
            leftKid = 2*parent + 1;   
            rightKid = 2*parent + 2; 
            System.out.println("inner loop with parent = " + parent + " left: " + 
               leftKid + " right: " + rightKid );
         
            if( leftKid >= bottom )
               parent = -1;
            else if( rightKid < bottom )
               parent = handle2Kids( parent, leftKid, rightKid );
            else
               parent = handle1Kid(  parent, leftKid );
         
         }// loop to let the root item drop
      }// move bottom from end to beginning
   
      System.out.print("after sorting: " );
      displayHeap(n);
   }// sort

   private static int handle2Kids(  int parent, int left, int right )
   {
      if( list.get(parent).freq >= list.get(left).freq && list.get(parent).freq >= list.get(left).freq )
         parent = -1;
      else if( list.get(left).freq >= list.get(left).freq )
      {
         swap( parent, left );
         parent = left;
      }
      else
      {
         swap( parent, right );
         parent = right;
      }
   
      return parent;
   }

   private static int handle1Kid(  int parent, int left )
   {
      if( list.get(parent).freq >= list.get(left).freq )
         parent = -1;
      else
      {
         swap(  parent, left );
         parent = left;
      }
   
      return parent;
   }

   private static void swap(  int x, int y )
   {
      HuffTree temp = list.get(x);
      list.set(x, list.get(y));
      list.set(y, temp);
   }

//HUFFITIZATION ENGAGE

	public void huffitizeMe()
	{
		while(list.size() > 1)
		{
			HuffTree first;
			HuffTree second;
			HuffTree third;
			first = list.get(0);
			list.remove(0);
			heapSort(list.size());
			second = list.get(0);
			list.remove(0);
			heapSort(list.size());
			third = new HuffTree(first, second);
			list.add(third);
			heapSort(list.size());
		}
	}
	public void traverse(HuffTree a)
	{
		
	}
	public static void main(String[] args)
	{
		Ex4 sirHuffington = new Ex4();
		sirHuffington.input();
		n = (list.size() - 1);

		sirHuffington.display();
		sirHuffington.heapSort(list.size());
		sirHuffington.displayHeap(list.size());
		sirHuffington.huffitizeMe();
		sirHuffington.displayHeap(list.size());
	}
}
