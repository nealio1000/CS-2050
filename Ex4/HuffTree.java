public class HuffTree
{
public String word;
public int freq;
public HuffTree kidL;
public HuffTree kidR;


public HuffTree()
{
word = "";
freq = 0;
}

public HuffTree(String w, int f)
{
word = w;
freq = f;
}

public HuffTree(HuffTree f, HuffTree s)
{
	word = "";
	freq = f.freq + s.freq;
	kidL = f;
	kidR = s;
}
public String getWord()
{
return word;
}





































}
