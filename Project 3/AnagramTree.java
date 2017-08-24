class AnagramTree
{
	private class TreeNode
	{
		private byte[] summary;
		private WordNode words;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(byte[] summary, String word)
		{
			this.summary = summary;
		    this.words = new WordNode(word);
		    this.left = null;
		    this.right = null;
		}
	}
	
	private class WordNode
	{
		private String word;
		private WordNode next;
		
		private WordNode(String word)
		{
			this.word = word;
			this.next = null;
		}	
		
		private WordNode(String word, WordNode next)
		{
			this.word = word;
			this.next = next;
		}	
	}
	
	private TreeNode head;
	
	public AnagramTree()
	{
		head = new TreeNode(null, null);
	}
	
	public void add(String word)
	{
		byte[] temp = stringToSummary(word);
		
		if (head.left == null)
		{
			head.left = new TreeNode(temp, word);
			return;
		}
		else
		{
				TreeNode subtree = head.left;
				
			    while (true)
			    {
				    if (compareSummaries(subtree.summary, temp) < 0)
				    {
					    if (subtree.left == null)
					    {
						    subtree.left = new TreeNode(temp, word);
						    return;
					    }
					    else
						    subtree = subtree.left;
				    }
				    else if (compareSummaries(subtree.summary, temp) > 0)
				    {
					    if (subtree.right == null)
					    {
						    subtree.right = new TreeNode(temp, word);
						    return;
					    }
					    else
						    subtree = subtree.right;
				    }
				    else
				    {
				    	if (!isIn(subtree.words, word))
					    {
				    		subtree.words = new WordNode(word, subtree.words);
					        return;
					    }
					    else
					    	return;
				    }
			    }
			}
		
	}
	
	private boolean isIn(WordNode w, String word) 
	{ 
		if (w.word == word)
		{
			return true;
		}
		WordNode temp = w;
		while (temp != null)
		{
			if (temp.word.equals(word))
				return true;
			else
				temp = temp.next;
		}
		return false;
		
	}
	
	//at least one helper for anagram

	
	  private void helper (TreeNode subtree)
	  {
	      if (subtree == null)
	    	  return;
	      
	      if(subtree.words.next != null)
	       {
	           WordNode temp = subtree.words;
	           while(temp != null)
	           {
	               System.out.print(temp.word + " ");
	               temp = temp.next;
	           }
	           System.out.println();
	       }

	      helper(subtree.left);
    	  helper(subtree.right); 
	  }
	
	public void anagrams()
	{
	    helper(head.left);
	}
	
	private int compareSummaries(byte[] left, byte[] right)
	{
		for (int i = 0; i < left.length; i++)
		{
			if (left[i] != right[i])
			{
				return (left[i] - right[i]);
			}
		}
		return 0;
	}
	
	private byte[] stringToSummary(String word)
	{
		byte[] sum = new byte[26]; 
		for (int i = 0; i < word.length(); i++)
		{
			int index = word.charAt(i) - 'a';
			sum[index]++;
		}
		return sum;
	}
	
}

class Anagrammer
{
	public static void main(String[] args)
	{
		AnagramTree atree = new AnagramTree();
	    Words words = new Words("/Users/Kin/Documents/Eclipse/CSCI 1913/src/project3kin/test.txt");
	    while (words.hasNext())
	    {
	      atree.add(words.next());
	    }

		atree.anagrams();
	
	}
}


///////////////////////////////////////////////////////////////////////////////////
/* Input file test.txt:
 * eat
 * ate
 * hello
 * world
 * java
 * tall
 * stall
 * acres
 * cares
 * scard
 * color
 * yes
 * sword
 * tea
 * costa
 * coast
 * going
 * words
 * order
 * cards
*/
//////////////////////////////////////////////////////////////////////////////////////
/* Tested result as follow:
 * tea ate eat 
 * cares acres 
 * cards scard 
 * coast costa 
 * words sword 
 */
