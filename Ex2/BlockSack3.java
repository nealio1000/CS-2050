/*  implement the sack ADT by
   using an ArrayList and being
   a little clever on remove
*/

import java.util.ArrayList;
import java.awt.Color;

public class BlockSack3
{
	// instance variables:
	private ArrayList<Block> list;
	private int index;  // the index of the found block
	private int travPos;  // current position in the traversal
	// constructor(s):

	public BlockSack3()
	{
		list = new ArrayList<Block>();
	}

	// given a key, return true if the block with that key
	// is in the sack, false if not
	// (leave the block special so we can get or remove it)
	public boolean find( Key key )
	{
		Block b = new Block(key, "");
		String a = binarySearch(list, b, 0, list.size()-1);
		if (a.charAt(0) == '-')
			return false;
		index = Math.abs(Integer.parseInt(a));	
		return true;
	}

	// assuming a successful find has been done,
	// return a reference to the found block
	public Block get()
	{
		return list.get(index);  
	}
  
	// assuming a successful find has been done,
	// remove the found block
	public void remove()
	{
		if (list.size() == 0)
			return;
		list.set(index, list.get(list.size() - 1));
		list.remove(list.size() - 1);
	}

	// add the given block to the sack
	public void add( Block b )
	{
		Key key = b.getKey();
		if(list.size() == 0)
		{
			list.add( b );
		}
		else
		{
			String a = binarySearch(list, b, 0, list.size() - 1);
			index = Math.abs(Integer.parseInt(a));	
			if(a.charAt(0) == '+') //block found, insert after found block
			{
				list.add(index+1, b);
			}
		
			else//block not found, insert at index
				list.add(index, b);
		}
		
	}
  
	public void initForTraverse()
	{
		travPos = 0;
	}

	public boolean hasNext()
	{
		return travPos < list.size();
	}

	public Block next()
	{
		Block temp = list.get(travPos);
		travPos++;
		return temp;
	}

	private void debug(String message)
	{
		System.out.println(message);
		System.out.print("<");
		for(int k=0; k<list.size(); k++ )
			System.out.print( list.get(k) );
		System.out.println(">");
		System.out.println("index: " + index + " travPos: " + travPos );
		System.out.println();
	}

	private static void show( BlockSack3 sack )
	{
		System.out.print("[" );
		sack.initForTraverse();
		while( sack.hasNext() )
		{
			Block b = sack.next();
			System.out.print( b );
		}
		System.out.println( "]");
	}
	public static String binarySearch( ArrayList<Block> a, Block target,
                                       int first, int last )
	{
		System.out.println("binarySearch called with first=" + first + 
								" last=" + last);
		
		//only one item in the list
		if( first == last )
		{
			if( target.equals( a.get(first) ) )
				return "+" + first;
			else if( target.compareTo( a.get(first)) < 0 )
				return "-" + first;
			else if( target.compareTo( a.get(first)) > 0 )
				return "-" + (first+1);
		}

		int mid = (first+last)/2;
		
		//target found
		if( target.compareTo( a.get(mid)) == 0 )
		{
			return "+" + mid;
		}

		else if( target.compareTo( a.get(mid)) < 0 )
		{// target < a.get(mid)

			if( first == last-1 )
			{// down to 2 items and target was in the first half
				return "-" + first;
			}
			else
				return binarySearch( a, target, first, mid-1 );
		}

		else if( target.compareTo( a.get(mid)) > 0 )
		{// a[mid] < target
			return binarySearch( a, target, mid+1, last );
		}

		else
		{
			System.out.println("this shouldn't happen!");
			System.exit(2);
			return "42";
		}
	}
	// "unit testing" of sack:
	public static void main(String[] args)
	{
		BlockSack3 sack = new BlockSack3();
		
		sack.add( new Block( new Key(3,9), "lava" ) );
		sack.add( new Block( new Key(1,0), "lava" ) );
		sack.add( new Block( new Key(0,4), "lava" ) );
		sack.add( new Block( new Key(500,7), "lava" ) );
		sack.add( new Block( new Key(8,1), "lava" ) );
		sack.add( new Block( new Key(2,4), "lava" ) );
		sack.add(new Block(new Key(50, 50), "food"));
		sack.add( new Block( new Key(7,65), "lava" ) );
		sack.add( new Block( new Key(0,0), "food" ) );
		sack.add(new Block( new Key(-5,5),"food"));
				
		if(sack.find( new Key(1,1) ))
		{
			sack.debug("after finding (1,1):");
		}
		if(sack.find( new Key(50,50) ))
		{
			sack.debug("after finding (50,50):");
		}

		Block b = sack.get();
		System.out.println("we got the block: " + b );

		sack.remove();
		sack.debug("sack after removing (50,50):");
	}
}
