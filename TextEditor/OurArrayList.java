public class OurArrayList
{
  // instance variables:
  private int n;  // the number of items in the list
  private String[] a;  // the array that holds the items in
                       // consecutive order starting from 0

  // build 10 spaces arbitarily
  public OurArrayList()
  {
    n = 0;
    a = new String[10];
  }

  // build the requested number of spaces
  // Assume: initCap>0
  public OurArrayList( int initCap )
  {
    n = 0;
    a = new String[initCap];
  }

  // append s to the end of the list
  void add( String s )
  {
    if( n == a.length )
      expand();

    a[n] = s;
    n++;
  }

  // insert s at position index,
  // shifting items to make room
  // Assume: 0<=index and index<=n
  void add( int index, String s )
  {
    if( n == a.length )
      expand();

    for(int k=n-1; k>=index; k-- )
    {
      a[ k+1 ] = a[ k ];
    }

    a[index] = s;

    n++;
  }

  // remove all the items from the list
  void clear()
  {
    n = 0;
  }

  // return the item stored at the given index
  // Assume: 0<=index and index<n
  String get( int index )
  {
    return a[index];
  }

  // remove the item at position index
  // Assume:  0<=index and index<n
  void remove( int index )
  {
    for( int k=index+1; k<n; k++ )
    {
      a[k-1] = a[k];
    }

    n--;
  }
 
  // replace the item in position index by s
  // Assume:  0<=index and index<n
  void set( int index, String s )
  {
    a[index] = s;
  }

  // return the number of items in the list
  int size()
  {
    return n;    
  }

  // when need more space---to do add---make
  // new array twice as big and switch to using it
  private void expand()
  {
    // make b be an array twice as big as a
    String[] b = new String[ 2*a.length ];

    // copy meaningful elements in a to b
    for( int k=0; k<n; k++ )
    { 
      b[k] = a[k];
    }

    // switch to using b instead of a
    a = b;

System.out.println("called expand, now physical size is "
                    + a.length );
  }

  public static void main(String[] args)
  {
    OurArrayList x = new OurArrayList(3);

    x.add( "a" );
    x.add( "b" );
    x.add( "c" );
    x.add( "d" );

    System.out.println("after adding: " + x );
    System.out.println("there are " + x.size() + " items in the list");

    x.add( 0, "A" );
    x.add( x.size()/2, "B" );
    x.add( x.size()-1, "C" );
    x.add( x.size(), "D" );

    System.out.println("after inserting: " + x );
    System.out.println("there are " + x.size() + " items in the list");
 
/*
    x.add( x.size()+1, "E" );

    System.out.println("after inserting: " + x );
    System.out.println("there are " + x.size() + " items in the list");
*/

    x.remove( 0 );
    x.remove( 4 );
    x.remove( x.size()-1 );
    System.out.println("after removing: " + x );
    System.out.println("there are " + x.size() + " items in the list");

    x.set( 0, "Hello!" );
    x.set( 3, "cat" );
    x.set( x.size()-1, "Bye" );
    System.out.println("after sets, " + x );

    System.out.println("items got are: " + x.get(0) + " " + x.get(2) );

    x.clear();
    System.out.println("after clear, " + x );

    x.add( "what?" );
    System.out.println("sanity check: " + x );
  }

  public String toString()
  {
    String temp = "[ ";
    for( int k=0; k<n; k++ )
    {
      if( k<n-1 )
        temp += a[k] + ", ";
      else
        temp += a[k] + " ";
    }
    return temp+"]";
  }

}
