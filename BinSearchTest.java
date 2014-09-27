public class BinSearchTest
{
	public static void main (String args[]) 
	{
		String[] a = { "ape", "cat", "dingo", "dog", "giraffe", "horse",
						"mouse", "newt", "quail", "yak", "zebra" };
		String result = binarySearch(a, args[0], 0, a.length);
		
		System.out.println("got: " + result );
	}
	public static String binarySearch(String[] a, String target, int first, int last)
	{
		System.out.println("binarySearch called with first=" + first + " last=" + last);
		int mid = (first+last)/2;
		
		if(target.compareTo( a[mid] ) == 0 )
		{
			return "+" + mid;
		}
		else if(target.compareTo ( a[mid] ) < 0 )
		{
			return binarySearch( a, target, first, mid - 1);
		}
		else if(target.compareTo( a[mid] ) < 0)
		{
			return binarySearch( a, target, mid+1, last);
		}
		
	}
}

