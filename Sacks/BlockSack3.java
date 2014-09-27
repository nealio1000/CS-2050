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
	
	//*********** Binary Search Method from class ********************
	public static String binarySearch( String[] a, String target,
                                       int first, int last )
	{
		System.out.println("binarySearch called with first=" + first + 
                   " last=" + last);

		if( first == last )
		{
			if( target.equals( a[first] ) )
				return "+" + first;
			else if( target.compareTo( a[first] ) < 0 )
				return "-" + first;
			else if( target.compareTo( a[first] ) > 0 )
				return "-" + (first+1);
		}

		int mid = (first+last)/2;

		if( target.compareTo( a[mid] ) == 0 )
		{
			return "+" + mid;
		}

		else if( target.compareTo( a[mid] ) < 0 )
		{
			// target < a[mid]

			if( first == last-1 )
			{
				// down to 2 items and target was in the first half
				return "-" + first;
			}
			else
				return binarySearch( a, target, first, mid-1 );

		}

		else if( target.compareTo( a[mid] ) > 0 )
		{
			// a[mid] < target
			return binarySearch( a, target, mid+1, last );
		}

		else
		{
			System.out.println("this shouldn't happen!");
			System.exit(2);
			return "42";
		}
	}
	//*************** End of Binary Search *****************************
	
	public boolean find( Key key ) //needs to be done
	{
		return true;
	}
	
	
	public void add( Block b ) //Needs to be tweaked to use BinSearch
	{
		list.add( b );
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
		// baddish idea---is O(n):    list.remove(index);
		list.set( index, list.get(list.size()-1) );
		list.remove( list.size()-1 );
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
	public static void main (String[] args)
	{
	}
}

