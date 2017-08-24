/**
 * CSCI 1913
 * Lab 8
 * @author Kin Chan
 * Lab Partner: Changmeng Xu
 **/

class RunnyStack<Base>
{
	private class Run
    {
         private Base object;	
         private Run next;	
         private int length;
         
         private Run(Base object, Run next, int length)
         {
              this.object = object; 
              this.next = next;
              this.length = length;
         }
    }
	
	private Run top;
	private int count;	
	
	public RunnyStack()
	{
		top = new Run(null, null, 0);
		count =0 ;
	}
	
	public int depth()
	{
		return count;
	}
	
	public boolean isEmpty()	
	{
		return top.object == null;
	}
	
	private boolean isEqual(Base object, Base ob)
	{
		if (object == null || ob == null)
		{
			return object == ob;	
		}
		return object.equals(ob);	
	}
	
	public Base peek()	
	{
		if (isEmpty()) 
		{
			throw new IllegalStateException("Stack is empty.");
		} 
		else 
		{	
			return top.object;
		}
	}
	
	public void pop()	
	{
		if(isEmpty())
		{
			throw new IllegalStateException("Stack is empty.");
		}
		else
		{
			count--;
			top.length --;
			top = top.next;
		}
	}
	
	public void push(Base object)	
	{
		
		if (!isEmpty())
		{
			if(isEqual(object, top.object))
			{
				count++;
				top = new Run(object, top, top.length);
			}
			else
			{
				top = new Run(object, top, top.length);
				top.length++;
				count++;
			}
		}	
		else
		{
			top = new Run(object, top, top.length);	
			top.length ++;
			count ++;
		}
	}
	
	public int runs()	
	{
		return top.length;
	}
}

//
//  Tests for CSci 1913 Lab 8
//  James Moen
//  20 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails. We still
//  haven't talked about TRY-CATCH'es in the lectures yet.
//
//  Most tests have comments that show what they should print, and how many
//  points they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class RunnyTEST
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
 
    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}