/**
 * CSCI 1913
 * Lab 10
 * @author Kin Chan
 */
class ArrayQueue<Base>
{
	private int     front;     
	private int     rear;      
	private Base [] objects;  

	public class Iterator
	{
		private int size;
		private int current;
		private Base[] elements;
		
		private Iterator(Base[] elements, int size)
		{
			this.elements = elements;
			this.size = size;
			current = front;
		}
		
		public boolean hasNext()
		{
			return ((!isEmpty()) && (current-1 <= size) && (elements[(current+1) % size] != null)) ;
		}
		
		public Base next()
		{
			if (!hasNext())
				throw new IllegalStateException("No elements anymore");
			else
				current+=1;
				return elements[(current) % size];
		}
		
	}
public ArrayQueue(int size)
	{
		if (size >= 1)
		{
			front = 0;
			rear = 0;
			objects = (Base []) new Object[size];
		}
		else
		{
			throw new IllegalArgumentException("Size must be at least one.");
		}
	}

	public boolean isEmpty()
	{
		return front == rear;
	}


	public boolean isFull()
	{
		return front == (rear + 1) % objects.length;
	}


	public void enqueue(Base object)
	{
		int nextRear = (rear + 1) % objects.length;
		if (front == nextRear)
		{
			throw new IllegalStateException("Queue is full.");
		}
		else
		{
			rear = nextRear;
			objects[rear] = object;
		}
	}


	public Base dequeue()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty.");
		}
		else
		{
			front = (front + 1) % objects.length;
			Base temp = objects[front];
			objects[front] = null;
			return temp;
		}
	}
	
	public Iterator iterator()
	{
		return new Iterator(objects,objects.length);
	}
}


//  QUETERATOR. Test ARRAY QUEUE's ITERATOR class. It's worth 20 points.

class Queterator
{

//  MAIN. Start execution here.

  public static void main(String [] args)
  {

//  Make an ARRAY QUEUE and enqueue some STRINGs.

    ArrayQueue<String> queue = new ArrayQueue<String>(4);

    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

//  Make a FIRST ITERATOR for QUEUE and use it to visit QUEUE's elements.

    ArrayQueue<String>.Iterator first = queue.iterator();
    while (first.hasNext())
    {
      System.out.println(first.next());    //  A B C one per line    5 points
    }

//  The iterator hasn't changed QUEUE.

    System.out.println(queue.isEmpty());   //  false                 1 point
    System.out.println(queue.dequeue());   //  A                     1 point
    System.out.println(queue.dequeue());   //  B                     1 point
    System.out.println(queue.dequeue());   //  C                     1 point
    System.out.println(queue.isEmpty());   //  true                  1 point

//  Let's enqueue more things to QUEUE.

    queue.enqueue("X");
    queue.enqueue("Y");
    queue.enqueue("Z");

//  Now make a SECOND ITERATOR for QUEUE. The FIRST one does not work any more,
//  because QUEUE has changed. Use SECOND to visit QUEUE's new elements.

    ArrayQueue<String>.Iterator second = queue.iterator();
    while (second.hasNext())
    {
      System.out.println(second.next());   //  X Y Z one per line    5 points
    }

//  The new iterator hasn't changed QUEUE either.

    System.out.println(queue.isEmpty());   //  false                 1 point
    System.out.println(queue.dequeue());   //  X                     1 point
    System.out.println(queue.dequeue());   //  Y                     1 point
    System.out.println(queue.dequeue());   //  Z                     1 point
    System.out.println(queue.isEmpty());   //  true                  1 point
  }
}