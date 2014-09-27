/*  This is a draft version of the class you need
for Ex3---you might need to fix errors!
*/

public class EditableList
{
	// IV's:
	private DLLNode head, cursor, tail;
	private int n;  // # of real lines stored

	public EditableList()
	{
		n = 0;
		head = new DLLNode( "dummy head node" );
		tail = new DLLNode( "dummy tail node" );
		head.next = tail;
		tail.prev = head;
		cursor = tail;    
	}

	// add the given string immediately before
	// the current line
	public void add( String s )
	{
		if(cursor == head)
		{
			//do nothing
		}
		else
		{
			DLLNode temp = new DLLNode( s );
			temp.prev = cursor.prev;
			temp.next = cursor;
			cursor.prev.next = temp;
			cursor.prev = temp;
			cursor = temp;
			n++;
		}
	}
	
	// remove the current line
	// (unless the current line is "off the end")
	public void remove()
	{
		if( cursor == tail )
		{
			// can't remove the dummy tail node
		}
		else
		{
			cursor.prev.next = cursor.next;
			cursor.next.prev = cursor.prev;
			cursor = cursor.next;
			n--;
		}
	}
	public void insert( int x, String s )
	{
		first();
		x--;
		for ( int i = x ; i > 0 ; i--)
		{
			down();
		}
		add(s);
  }
	// move the cursor back one line, but
	// don't ever let cursor point to dummy head node
	public void up()
	{
		cursor=cursor.prev;
	}

	// move the cursor ahead one line, but
	// don't move ahead from tail 
	public void down()
	{
		if(cursor == tail)
		{
			//do nothing
		}
		else
			cursor=cursor.next;
	}
	public void first()
	{
		cursor = head.next;
	}

	public void last()
	{
		cursor = tail.prev;
	}
	// return the line that is x spots away from
	// the current line, or null if there is no
	// such line
	public String get( int x )
	{
		first();
		for ( int i = x ; i > 0 ; i--)
		{
			if (cursor.next == null)
			{
				return null;
			}
			down();
		}

		return cursor.data;
	}
	public String get()
	{
		return cursor.data;
	}
	// replace the current line by s
	// except do nothing if cursor is
	// pointing to the dummy tail
	public void set( String s )
	{
		if(cursor == tail)
		{
			//do nothing
		}
		else
		{
			DLLNode temp = new DLLNode( s );
			temp = cursor;
			temp.data = s;
		}
	}
	public int size()
	{
		return n;
	}
}
