/* implement the abstract "list"

  Implementing our own version of ArrayList<E>
*/
public class WList<E>
{
  // instance variables:
  private E[] items;  // array that holds the items
  private int n; // current # of items
  
  // construct an empty list
  public WList()
  {
    items = (E[]) new Object[ 8 ];
    n = 0;
  }
  public WList(int i)
   {
    items = (E[]) new Object[ i ];
    n = 0;
  }
  // add s to the end of this list
  public void append( E s )
  {
    if( n == items.length )
      enlarge();

    items[ n ] = s;
    n++;

  }

  // insert s into position p of this list
  // (shift all items over)
  public void insert( int p, E s )
  {
    if( p<0 || n<p )
    {
      System.out.println("illegal index " + p );
      System.exit(1);
    }

    if( n == items.length )
      enlarge();

    for( int k=n-1; k>=p; k-- )
    {
      items[ k+1 ] = items[ k ];
    }

    items[ p ] = s;
    n++;

  }

  private void enlarge()
  {
    // make a double-size array
    E[] temp = (E[]) new Object[ 2*items.length ];

    // copy all items to new array:
    for(int k=0; k<n; k++ )
    {
      temp[ k ] = items[ k ];
    }

    items = temp;
    
  }

  // get the item in position p
  public E get( int p )
  {
    if( p<0 || n-1 < p )
      return null;
    else
      return items[ p ];
  }
 
  // remove the item in position p
  public void remove( int p )
  {
    if( p<0 || n<=p )
    {
      System.out.println("illegal index " + p );
      System.exit(1);
    }

    for( int k=p+1; k<n; k++ )
    {
      items[ k-1 ] = items[ k ];
    }
   
    n--;
  }

  // replace the item in position p with s
  public void replace( int p, E s )
  {
    if( p<0 || n<=p )
    {
      System.out.println("illegal index " + p );
      System.exit(1);
    }
    else
    {
      items[ p ] = s;
    }
  }

  // return the number of items in the list
  public int size()
  {
    return n;
  }

  public String toString()
  {
    String s = "";
    for(int k=0; k<n; k++ )
      s += items[k].toString() + ",";
    return s;
  }

  public static void main(String[] args)
  {
    WList list = new WList();
        WList<String> list2 = new WList<String>();
        list2.append("bob");
        list2.append("bob");
        list2.append("bob");
        list2.append("bob");
    
    list.insert( 0, list2);
    list.insert( 0, "cat" );
    list.insert( 1, "dog" );
    list.insert( 2, "ocelot" );
    list.insert( 0, "ibex" );
    list.insert( 5, "gopher" );
   
    System.out.println( list );

    list.remove( 2 );
    list.remove( 4 );
    list.remove( 0 );

    System.out.println( list );

  }

}
