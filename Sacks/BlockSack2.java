/*  implement the sack ADT by
   using an ArrayList and being
   a little clever on remove
*/

import java.util.ArrayList;
import java.awt.Color;

public class BlockSack2
{
  // instance variables:
  private ArrayList<Block> list;
  private int index;  // the index of the found block
  private int travPos;  // current position in the traversal

  // constructor(s):

  public BlockSack2()
  {
    list = new ArrayList<Block>();
  }

  // given a key, return true if the block with that key
  // is in the sack, false if not
  // (leave the block special so we can get or remove it)
  public boolean find( Key key )
  {
    for( int k=0; k<list.size(); k++ )
    {
      Key temp = list.get(k).getKey();
      if( temp.x==key.x && temp.y==key.y )
      {
        index = k;
        return true;
      }
    }

    return false;

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

  // add the given block to the sack
  public void add( Block b )
  {
    list.add( b );
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

  // "unit testing" of sack:
  public static void main(String[] args)
  {
    BlockSack2 sack = new BlockSack2();
    show( sack );
    sack.debug("After building the empty sack:");

    sack.add( new Block( new Key(3,7), "lava" ) );
    sack.debug("sack after adding (3,7):");
    
    sack.find( new Key(3,7) );
    sack.debug("after finding (3,7):");

    Block b = sack.get();
    System.out.println("we got the block: " + b );

    sack.remove();
    sack.debug("sack after removing (3,7):");

    // add your own further testing!

  }

  private static void show( BlockSack2 sack )
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

}
