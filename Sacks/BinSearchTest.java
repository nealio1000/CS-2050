public class BinSearchTest
{
  public static void main(String[] args)
  {
    String[] a = { "ape", "cat", "dingo", "dog", "giraffe",
                   "horse", "mouse", "newt", "quail", "yak", "zebra" };

    for( int k=0; k<a.length; k++ )
      System.out.println( k + ": " + a[k] );

    String result = binarySearch( a, args[0], 0, a.length-1 );

    System.out.println("got: " + result );
  }

  // must have first<=last
  //  Code based on the invariant:  a[first-1]<=target<=a[last+1]
  //           where these quantities make sense
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
    {// target < a[mid]

      if( first == last-1 )
      {// down to 2 items and target was in the first half
        return "-" + first;
      }
      else
        return binarySearch( a, target, first, mid-1 );

    }

    else if( target.compareTo( a[mid] ) > 0 )
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

  
}
