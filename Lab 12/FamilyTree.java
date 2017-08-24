/**
 * CSCI 1913    
 * Lab 12
 * @author Kin Chan
 */


class FamilyTree
{
	private class Node
	{
		private String name;
		private Node father;
		private Node mother;
		
		private Node(String name, Node father, Node mother)
		{
			this.name=name;
			this.father=father;
			this.mother=mother;
		}
	}
	
	private Node root;
	
	public FamilyTree(String ego)
	{
		root=new Node(ego,null,null);	
	}
	
	private Node find(String name)	
        {
		return find(name, root);	
	}
	
	private Node find(String name, Node root)	
	{
		if(root!=null)
		{
			if(name.equals(root.name))
			{
				return root;
			}
			else
			{
				if (find(name, root.father) == null)
					return find(name, root.mother);
				if (find(name, root.mother) == null)
				{
					return find(name, root.father);
				}
			}
		}
		return null;

	}
	
	public void addParents(String ego, String father, String mother)
	{
		if(find(ego )== null)
		{
			throw new IllegalArgumentException("No that Node");
		}
		else
		{
			Node temp = find(ego);
			temp.father=new Node(father,null,null);
			temp.mother=new Node(mother,null,null);
		}
	}
	
	public boolean isDescendant(String ego, String ancestor)
	{
		if(find(ego) ==null || find(ancestor)==null)	
		{
			return false;
		}
		else
		{
			return isDescendant(find(ego),find(ancestor));
		}
	}
	
	private boolean isDescendant(Node root, Node ancestor)	
	{
		if(root!=null)
		{
			if(root!=ancestor)
			{
				return isDescendant(root.father,ancestor)||isDescendant(root.mother,ancestor);
			}
			else 
				return (root == ancestor);
		}
		else
		{
			return false;
		}
	}
}

//  POTTERY. Driver class, for testing. Each comment shows a point value (for a
//  total of 40 points) and what it should print.

class Pottery
{

//  MAIN. Harry Potter and the Hairier Pottery.

  public static void main(String [] args) 
  {
    FamilyTree family = new FamilyTree("Al");

    family.addParents("Al",    "Harry",  "Ginny");
    family.addParents("Harry", "James",  "Lily" );
    family.addParents("Ginny", "Arthur", "Molly");

    try
    {
      family.addParents("Joanne", "Peter", "Anne");
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne.");  //  2 No Joanne.
    }

    System.out.println(family.isDescendant("Joanne", "Joanne"));  //  2 false

    System.out.println(family.isDescendant("Al", "Al"));          //  2 true
    System.out.println(family.isDescendant("Al", "Harry"));       //  2 true
    System.out.println(family.isDescendant("Al", "Ginny"));       //  2 true
    System.out.println(family.isDescendant("Al", "James"));       //  2 true
    System.out.println(family.isDescendant("Al", "Lily"));        //  2 true
    System.out.println(family.isDescendant("Al", "Arthur"));      //  2 true
    System.out.println(family.isDescendant("Al", "Molly"));       //  2 true
    System.out.println(family.isDescendant("Al", "Joanne"));      //  2 false

    System.out.println(family.isDescendant("Harry", "Harry"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Al"));       //  2 false
    System.out.println(family.isDescendant("Harry", "James"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Lily"));     //  2 true
    System.out.println(family.isDescendant("Harry", "Ginny"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Arthur"));   //  2 false
    System.out.println(family.isDescendant("Harry", "Molly"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Joanne"));   //  2 false

    System.out.println(family.isDescendant("Ginny", "Arthur"));   //  2 true
    System.out.println(family.isDescendant("Arthur", "Ginny"));   //  2 false
  }  
}