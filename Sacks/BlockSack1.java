import java.util.ArrayList;
import java.awt.Color;

public class BlockSack1
{
  // instance variables:
  private ArrayList<Block> list;
  private int index;  // the index of the found block
  private int travPos;  // current position in the traversal

  // constructor(s):

  public BlockSack1()
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
    list.remove(index);
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

}
