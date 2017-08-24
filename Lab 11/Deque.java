/**
 *
 * CSCI 1913
 * Lab11
 * @author Kin Chan
 */
class ObservationDeque
{

//  MAIN. Test the DEQUE on various example arguments.

  public static void main(String [] args)
  {
    Deque<String> deque = new Deque<String>();

    System.out.println(deque.isEmpty());       // true                2 points.

    try
    {
      System.out.println(deque.dequeueFront());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
    }

    try
    {
      System.out.println(deque.dequeueRear());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
    }

//  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
//  like a stack.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.isEmpty());       //  false              2 points.

    System.out.println(deque.dequeueRear());   //  C                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
//  like a queue.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.dequeueFront());  //  A                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the front makes the DEQUE act
//  like a stack.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueFront());  //  C                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
//  like a queue.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueRear());   //  A                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.
  }
}



class Deque<Base>
{
    private class Node
    {
        private Base object;
        private Node left;
        private Node right;
        private Node(Base object, Node left, Node right)
        {
            this.object=object;
            this.left=left;
            this.right=right;
        }
    }
    private Node head;
    
    public Deque()
    {
        head = new Node(null,null,null);
        head.left=head;
        head.right=head;
    }
    
    public void enqueueFront(Base object)
    {
        Node temp = head;
	      while (true)
	      {
	    	     if (isEmpty())
		         {
		    	    Node tempRight = new Node(object, temp, temp);
		    	    temp.left = tempRight;
		    	    temp.right = tempRight;
		    	    return;
		         }
		         else
		         {
			    	 Node tempRight = new Node(object, temp, temp.right);
			    	 temp.right = tempRight;
			    	 tempRight.right.left = tempRight;
			    	 return;
		         }
	          
	      }
        
    }
    
    public void enqueueRear(Base object)
    {
          Node temp = head;
	      while (true)
	      {
	    	     if (isEmpty())
		         {
		    	    Node tempLeft = new Node(object, temp, temp);
		    	    temp.left = tempLeft;
		    	    temp.right = tempLeft;
		    	    return;
		         }
		         else
		         {
			    	 Node tempLeft = new Node(object, temp.left, temp);
			    	 temp.left = tempLeft;
			    	 tempLeft.left.right = tempLeft;
			    	 return;
		         }
	          
	      }
    }
    
    public Base dequeueFront()
    {
    	  if (isEmpty())
      	  {
      		  throw new IllegalStateException("Queue is empty.");
      	  }
        	
        	Node tempRight = head.right;
    		Node temp = head;
    		 
    		 while (true)
    		 {
    		     if (temp.right == tempRight)
    		     {
    				temp.right = tempRight.right;
    				tempRight.right.left = temp;
    				return tempRight.object;
    			 }

    		 }
    	
    
    }
    
    public Base dequeueRear()
    {
    	
    	if (isEmpty())
  	  {
  		  throw new IllegalStateException("Queue is empty.");
  	  }
    	
    	Node tempLeft = head.left;
		Node temp = head;
		 
		 while (true)
		 {
		     if (temp.left == tempLeft)
		     {
				temp.left = tempLeft.left;
				tempLeft.left.right = temp;
				return tempLeft.object;
			 }

		 }
    }
    
    public boolean isEmpty()
    {
        return ((head.left == head) && (head.right == head));
    }
    
}
