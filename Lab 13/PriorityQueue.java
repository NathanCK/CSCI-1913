/**
 *
 * @author nathanchan
 */
class PriorityQueue<Base>  
{  
  private class Node  
  {  
    private Base object;  
    private int  rank;  
    private Node left;  
    private Node right;  
  
    private Node(Base object, int rank)  
    {  
      this.object = object;  
      this.rank = rank;  
      left = null;  
      right = null;  
    }  
  }  
  
  private Node root;  //  Root node of the BST.  
  
  public PriorityQueue()
  {
      root = new Node(null,-1);
  }
  
  public Base dequeue()
  {
      if (isEmpty())
      {
          throw new IllegalStateException("Empty!");
      }
      else
      {
          Node temp1 = root.right;
          Node temp2 = root;
          while(true)
          {
              if (temp1.left == null)
              {
                if (temp2.left == temp1)
		{
                    temp2.left = temp1.right;
                    return temp1.object;
                }
		else
		{
                    temp2.right = temp1.right;
                    return temp1.object;
		}
              }
              else
              {
                    temp2 = temp1;
                    temp1 = temp1.left;
              }
          }
      }
  }
  
  public void enqueue(Base object, int rank)
  {
      if (rank<0)
      {
          throw new IllegalArgumentException("Illegal Numbers Entered (Negative). ");
      }
      else
      {
          Node temp = root;
          
          while(true)
          {
              if (rank >= temp.rank)
              {
                 if(temp.right == null)
                 {
                     temp.right = new Node(object, rank);
                     break;
                 }
                 else
                 {
                     temp = temp.right;
                 }
              }
              else
              {
                  if(temp.left == null)
                  {
                      temp.left = new Node(object, rank);
                      break;
                  }
                  else
                  {
                      temp = temp.left;
                  }
              }
          }
      }
  }
  
  public boolean isEmpty()
  {
      return ((root.left==null) && (root.right==null));
  }


          
  
}

//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.

class Snobbery
{

//  MAIN. Queue them up.

  public static void main(String[] args)
  {
    PriorityQueue<String> queue = new PriorityQueue<String>();

    System.out.println(queue.isEmpty());  //  true        2 points

    try
    {
      System.out.println(queue.dequeue());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("Blimey!");      //  Blimey!     2 points
    }

    queue.enqueue("Lancelot",  5);
    queue.enqueue("Fawlty",    7);
    queue.enqueue("Elizabeth", 0);
    queue.enqueue("Charles",   1);
    queue.enqueue("Turing",    7);

    try
    {
      queue.enqueue("Zeus", -100);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No gods!");     //  No gods!    2 points
    }

    System.out.println(queue.isEmpty());  //  false       2 points

    System.out.println(queue.dequeue());  //  Elizabeth   2 points
    System.out.println(queue.dequeue());  //  Charles     2 points
    System.out.println(queue.dequeue());  //  Lancelot    2 points
    System.out.println(queue.dequeue());  //  Turing      2 points
    System.out.println(queue.dequeue());  //  Fawlty      2 points

//  It's OK if Fawlty comes out before Turing, but both must come out last.

    System.out.println(queue.isEmpty());  //  true        2 points.
  }

}
