
/**
 * CSCI 1913
 * Lab 9
 * @author kin Chan
 * partner Changmeng Xu
 */
class AssociationList<Key, Value>
{
    private class Node
    {
        private Key key;
        private Value value;
        private Node next;
        private Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    
    private Node first;
    
    public AssociationList()
    {
        first = new Node(null,null, first);
    }
    
    public Value get(Key key)
    {
        Node temp = first.next;
        while(temp!= null)
        {
            if (isEqual(key, temp.key))
            {
                return temp.value;
            }
            else
            {
                temp = temp.next;
            }
        }
        throw new IllegalArgumentException(" no such key.");

    }
    
    private boolean isEqual(Key leftKey, Key rightKey)
    {
        if ((leftKey == null) || (rightKey == null))
        {
            return leftKey == rightKey;
        }
        else
        {
            return leftKey.equals(rightKey);
        }
    }
    
    
    public boolean isIn(Key key)
    {
        Node temp = first.next;
        
        while(temp!= null)
        {
            if (isEqual(key, temp.key))
            {
                return true;
            }
            else
            {
                temp = temp.next;
            }
        }
        return false;
    }

    public void put(Key key, Value value)
    {
        Node temp = first.next;
        

        while(temp!= null)
        {
            if (isEqual(key, temp.key))
            {
                temp.value = value;
                break;
            }
            else
            {
                temp = temp.next;
            }
        }

        Node NewTemp = new Node(key, value, first.next);
        first.next = NewTemp;

    }
}

//
//  Tests for CSci 1913 Lab 9
//  James Moen
//  27 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by ASSOCIATION LIST's
//  methods, so that the program can continue to run even if a method fails.
//  We still haven't talked about TRY-CATCH'es in lecture yet.
//
//  Each test has a comment that shows what it should print and how many points
//  it is worth, for a total of 30 points.

//  HOGWARTS.  The Hogwarts dating service, again. This is the last time you'll
//  see it in this course.

class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String [] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    list.put("Harry",     "Ginny");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put(null,        "Wormtail");

    System.out.println(list.isIn("Harry"));      //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.put("Ron",   "Hermione");
    list.put("Albus", "Gellert");
    list.put(null,    null);

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get("Albus"));       //  Gellert       2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.
    System.out.println(list.get(null));          //  null          2 points.
  }
}