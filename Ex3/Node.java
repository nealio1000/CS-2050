public class Node
{
  public static int nextId = 0;

  private int id;

  public String data;
  public Node next;

  public Node( String s )
  {
    nextId++;
    id = nextId;

    data = s;
    // next = null;   // but objects have all IV's set to 0
  }

  public String toString()
  {
    return "[" + data + "](" + id + ")";
  }

}
