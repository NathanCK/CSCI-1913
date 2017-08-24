/**
 * CSCI 1913
 * lab 5
 * @author Kin chan
 * lab partner Changmeng Xu
 */
class Polygon  
{  
  private int[] sideLengths;  
  
  public Polygon(int sides, int ... lengths)  
  {  
    int index = 0;  
    sideLengths = new int[sides];  
    for (int length: lengths)  
    {  
      sideLengths[index] = length;  
      index += 1;  
    }  
  }  
  
  public int side(int number)  
  {  
    return sideLengths[number];  
  }  
  
  public int perimeter()  
  {  
    int total = 0;  
    for (int index = 0; index < sideLengths.length; index += 1)  
    {  
      total += side(index);  
    }  
    return total;  
  }  
}
class Rectangle extends Polygon
{
    public Rectangle(int a, int b)
    {
        super(4, a, b, a, b);
    }
    
    public int area()
    {
        return super.side(0)*super.side(1);
    }
    
    public int perimeter()
    {
        return super.perimeter();
    }
    
}

class Square extends Rectangle
{
    public Square(int a)
    {
        super(a,a);
    }
    
    public int area()
    {
        return super.area();
    }
    
    public int perimeter()
    {
        return super.perimeter();
    }
    
}

class Shapes
{
  public static void main(String[] args)
  {
    Rectangle wreck = new Rectangle(3, 5);

    System.out.println(wreck.side(0));      //  3   1 point.
    System.out.println(wreck.side(1));      //  5   1 point.
    System.out.println(wreck.side(2));      //  3   1 point.
    System.out.println(wreck.side(3));      //  5   1 point.
    System.out.println(wreck.area());       //  15  1 point.
    System.out.println(wreck.perimeter());  //  16  1 point.

    Square nerd = new Square(7);

    System.out.println(nerd.side(0));       //  7   1 point.
    System.out.println(nerd.side(1));       //  7   1 point.
    System.out.println(nerd.side(2));       //  7   1 point.
    System.out.println(nerd.side(3));       //  7   1 point.
    System.out.println(nerd.area());        //  49  1 point.
    System.out.println(nerd.perimeter());   //  28  1 point.
  }
}
