/**
 * CSCI 1913
 * Lab 7 
 * @author Kin Chan
 * partner Changmeng Xu
 **/

package Map;

class Map <Key, Value>
{
	private Key[] keys;
	private Value[] values;
	private int count;	//record how many elements of the arrays in use
	private int incValue;	//for using increment outside constructor
	
	public Map(int length)
	{
		if (length < 0)
		{
			throw new IllegalArgumentException("length must be greater than 0");
		}
		else
		{
			keys = (Key[]) new Object[length];		//create a new object array points to the origin array
			values = (Value[]) new Object[length];
			count = 0;
		}
	}
	
	public Map()
	{
		this(64);	//refer to constructor with two arguments
	}
	
	public Value get(Key key)	//return the value that is associated with key
	{
		if (where(key) != -1)
		{
				return values[where(key)];
		}
		else
		{
			throw new IllegalArgumentException("key is not found");
		}
	}
	
	private boolean isEqual(Key leftKey, Key rightKey)	//test if leftKey equal to rightKey
	{
		if (leftKey == null || rightKey == null)	//use == when testing null objects
		{
			return leftKey == rightKey;
		}
		return leftKey.equals(rightKey);	//use equals when testing non-null objects
	}
	
	public boolean isIn(Key key)	//Test if object in array keys is equal to key
	{
		boolean test = false;
		for (int i=0; i<= keys.length-1; i++)
		{
			if (test == false)
			{
				test = isEqual(keys[i],key);
			}
		}
		return test;
	}
	
	public void put(Key key, Value value)	//Associate key with value
	{
		if (where(key) != -1)
		{
			values[where(key)] = value;
		}
		else
		{
			if (count == keys.length-1)
			{
				throw new IllegalStateException("keys and values are full");
//				Key[] newK = (Key[]) new Object[keys.length];
//				Value[] newV = (Value[]) new Object[values.length];
//				for (int i=0; i <= keys.length-1; i++)
//				{
//					newK[i] = keys[i];
//					newV[i] = values[i];
//				}
//				keys = newK;
//				values = newV;
			}
			else
			{	
				keys[count] = key;
				values[count] = value;
				count += 1;
			}
		}
	}
	
	private int where(Key key)	//Search the array keys for an objects that is equal to key
	{
		for (int i=0; i<= keys.length-1; i++)
		{
			if (isEqual(keys[i],key))
			{
				return i;
			}
		}
		return -1;
	}
}

class Hogwarts
{

//  MAIN. Make an instance of MAP and test it.

  public static void main(String [] args)
  {
    Map<String, String> map;

    try
    {
      map = new Map<String, String>(-5);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No negatives");       //  No negatives  2 points.
    }

    map = new Map<String, String>(5);

    map.put("Harry",     "Ginny");
    map.put("Ron",       "Lavender");
    map.put("Voldemort", null);
    map.put(null,        "Wormtail");

    System.out.println(map.isIn("Harry"));      //  true          2 points.
    System.out.println(map.isIn("Ginny"));      //  false         2 points.
    System.out.println(map.isIn("Ron"));        //  true          2 points.
    System.out.println(map.isIn("Voldemort"));  //  true          2 points.
    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Joanne"));     //  false         2 points.

    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Lavender      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(map.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");          //  No Joanne     2 points.
    }

    map.put("Ron",   "Hermione");
    map.put("Albus", "Gellert");
    map.put(null,    null);

    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Albus"));      //  true          2 points.

    System.out.println(map.get("Albus"));       //  Gellert       2 points.
    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Hermione      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  null          2 points.

    try
    {
      map.put("Draco", "Pansy"); 
    }
    catch (IllegalStateException minnesota)
    {
      System.out.println("No Draco");           //  No Draco      2 points.
    }
  }
}
