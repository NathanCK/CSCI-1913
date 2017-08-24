/*
* CSCI 1913
* Project 2
* Name: Kin Chan
*/

//
//  SORTY LIST. Skeleton program for CSci 1913 Project 2.
//
//    James Moen
//    07 Apr 17
//

//  SORTY LIST. A linked list of INT's that can be efficiently sorted.

class SortyList
{

//  NODE. A node in a singly linked linear list of INT's.

  private class Node
  {
    private int  key;   //  The INT.
    private Node next;  //  The next NODE in the list, or NULL.

//  Constructor. Make a NODE with KEY and NEXT.

    private Node(int key, Node next)
    {
      this.key  = key;
      this.next = next;
    }
  }

  private Node head;   //  Head NODE.
  private Node first;  //  First NODE in a list of NODEs.

//  SORTY LIST. Constructor. Make a list of NODEs that holds the INT arguments.
//  Also make a HEAD node for SORT to use.

  public SortyList()
  {
    head = new Node(0, null);
  }

  public SortyList(int first, int ... rest)
  {
    Node last = new Node(first, null);
    this.first = last;
    for (int index = 0; index < rest.length; index += 1)
    {
      last.next = new Node(rest[index], null);
      last = last.next;
    }
    head = new Node(0, null);
  }

//  SORT. Sort the list whose first NODE is FIRST. We can't make more NODEs but
//  we can change the NEXT slots of the existing NODEs.

  public SortyList sort()
  {
    first = sort(first);
    return this;
  }

//  Sort the list UNSORTED without making any new NODE's, and return the sorted
//  list.

  private Node sort(Node unsorted)
  {
      if(unsorted==null||unsorted.next==null)
      {
          return unsorted;
      }
      else
      {
          Node left = null;
          Node right = null;
          Node tempL = unsorted;
          int count = 1;
          if ((unsorted == null)||(unsorted.next == null))
          {
              return unsorted;
          }
          else
          {
              while(unsorted !=null)
              {
                    if((count % 2) == 0)
                    {
                      tempL = right;
                      right = unsorted;
                      unsorted = unsorted.next;
                      right.next = tempL;
                      tempL = unsorted;
                      count ++;

                    }
                    else
                    {
                      tempL = left;
                      left = unsorted;
                      unsorted = unsorted.next;
                      left.next = tempL;
                      tempL = unsorted;
                      count ++;
                    }
              }
          left = sort(left);
          right = sort(right);
          Node merged =head;
          while(left!=null && right!=null)
          {
            if(left.key<=right.key)
            {
              merged.next=left;
              merged=left;
              left=left.next;
            }
            else
            {
              merged.next=right;
              merged=right;
              right=right.next;
            }
          }
          if(left==null)
          {
              merged.next = right;
          }
          else 
          {
              merged.next = left;
          }
          
          return head.next;
          }
       }
  }

//  TO STRING. Turn FIRST into a string for printing. If the list is empty then
//  the string is "[]". Otherwise it's "[K₁, K₂ ..., Kⱼ]" where the K's are the
//  KEYS from FIRST, in order of appearance.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    if (first != null)
    {
      Node temp = first;
      builder.append(temp.key);
      temp = temp.next;
      while (temp != null)
      {
        builder.append(", ");
        builder.append(temp.key);
        temp = temp.next;
      }
    }
    builder.append(']');
    return builder.toString();
  }

//  MAIN. Test SORTY LIST by running it on a few examples.

  public static void main(String[] args)
  {
    System.out.println(new SortyList()                            .sort());
    System.out.println(new SortyList(0)                           .sort());
    System.out.println(new SortyList(1, 0)                        .sort());
    System.out.println(new SortyList(2, 1, 0)                     .sort());
    System.out.println(new SortyList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).sort());
    System.out.println(new SortyList(5, 8, 4, 9, 0, 1, 2, 3, 7, 6).sort());
  }
}