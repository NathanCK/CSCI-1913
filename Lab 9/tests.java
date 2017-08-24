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
