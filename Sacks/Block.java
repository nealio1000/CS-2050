import java.awt.Color;

public class Block
{
  private Key key;
  private String kind;

  public Block( Key keyIn, String kindIn )
  {
    key = new Key( keyIn.x, keyIn.y );
    kind=kindIn;
  }

  public Key getKey()
  {
    return key;
  }
 
  public String getKind()
  {
    return kind;
  }

  public void draw( Camera cam )
  {
    if( kind.equals("player" ) )
      cam.setColor( Color.blue );
    else if( kind.equals("lava") )
      cam.setColor( Color.red );
    else if( kind.equals("food") )
      cam.setColor( Color.green );
    
    cam.fillRect( key.x-0.5, key.y-0.5, 0.9, 0.9 );
  }

  public void move( int dx, int dy, BlockSack3 sack )
  {
    sack.find( key );
    sack.remove();
    sack.add( new Block( key, "lava" ) );
    key.x += dx;
    key.y += dy;
    sack.add( this );
  }

  public int compareTo( Block other )
  {
    Key mine=this.getKey(), yours=other.getKey();
    if( mine.y == yours.y )
    {
      return mine.x - yours.x;
    }
    else
      return mine.y - yours.y;
  }

  public String toString()
  {
    return "(" + key.x + "," + key.y + ";" + kind + ")";
  }

}
