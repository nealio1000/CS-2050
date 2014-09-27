public class DLLNode
{
  public static int nextId = 0;

  private int id;

  public DLLNode prev;
  public String data;
  public DLLNode next;

  public DLLNode( String s )
  {
    nextId++;
    id = nextId;

    data = s;
    // prev, next = null;   // but objects have all IV's set to 0
  }

  public String toString()
  {
    return "[" + id + ": " + prev.id + "," + data + "," + next.id + "]";
  }

}
