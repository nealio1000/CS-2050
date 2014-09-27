public class Heapsort
{

  public static void display( ArrayList a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a.get(k).freq + " " + a.get(k).getWord() + " " );
    System.out.println();
  }

  public static void heapsort( ArrayList<HuffTree> a, int n )
  {
    heapify( a, n );
    sort( a, n );
  }

  // turn a[0]..a[n-1] into a heap with same items rearranged
  public static void heapify( ArrayList<HuffTree> a, int n )
  {
    for( int h=0; h<n; h++ )
    {// let a[h], as the new item, go into the heap by swapping up its branch

      int kid = h;  // current position of the item being swapped upward
      int parent;   // position of the parent of the kid

      while( kid != 0 )
      {
        parent = (kid-1)/2;

        if( a.get(kid).freq > a.get(parent).freq )
        {// kid beats parent, swap
          swap( a, kid, parent );
          kid = parent;
        }
        else
          break;
         
      }
      
    }

    System.out.print("after heapifying: " );
    display(a,n);
  }

  // repeatedly let the largest item move to the bottom
  public static void sort( ArrayList<HuffTree> a, int n )
  {
    for( int bottom = n-1; bottom>0   ; bottom-- )
    {// swap a[0] and a[bottom], let new root item swap its way down

System.out.println("when bottom= " + bottom );
display( a, n );

      swap( a, 0, bottom );
      
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
          parent = handle2Kids( a, parent, leftKid, rightKid );
        else
          parent = handle1Kid( a, parent, leftKid );

      }// loop to let the root item drop
    }// move bottom from end to beginning

    System.out.print("after sorting: " );
    display(a,n);
  }// sort

  private static int handle2Kids( ArrayList<HuffTree> a, int parent, int left, int right )
  {
    if( a.get(parent).freq >= a.get(left).freq && a.get(parent).freq >= a.get(left).freq )
      parent = -1;
    else if( a.get(left).freq >= a.get(left).freq )
    {
      swap( a, parent, left );
      parent = left;
    }
    else
    {
      swap( a, parent, right );
      parent = right;
    }

    return parent;
  }

  private static int handle1Kid( ArrayList<HuffTree> a, int parent, int left )
  {
    if( a.get(parent).freq >= a.get(left).freq )
      parent = -1;
    else
    {
      swap( a, parent, left );
      parent = left;
    }

    return parent;
  }

  private static void swap( ArrayList<HuffTree> a, int x, int y )
  {
    HuffTree temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }

}
