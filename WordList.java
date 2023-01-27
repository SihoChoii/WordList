public class WordList
{
    String[] words = {"",""};
    int count;

    public WordList()
    {
        count = 0; // Zero Words State
    }

    public int addWord(String word)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (words[i] == word) break;
            if (count >= words.length)
            {
                String[] temp = new String[words.length*2];
                for (int p = 0; p < words.length; p++) temp[i] = words[i];
                words = temp;
            } 
            if (count < words.length)
            {
                words[count] = word;
                count++;
            }
        }
        return count;
    }
    public void removeWord(String word)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (words[i] == word)
            {
                for (int p = 0; p < count - i; p++)
                {
                    if (p == words.length - 1) words[p] = "";
                    else words[p] = words[p+1];                    
                }
                count--;
            }
        }
    }
    public int findWord(String word)
    {
        for (int i = 0; i < words.length; i++)
        {
            if (words[i] == word) return i;
        }
        return -1;
    }

    // Copied Code
    public boolean equals(WordList other) 
    {
        if (this.count != other.count) 
        {
          return false;
        } 
        else 
        {
          for (int i = 0; i < this.count; i++) 
          {
            if (words[i] != other.words[i]) 
            {
              return false;
            }
          }
        }
        return true;
      }
      public String toString() 
      {
        String s = "There are " + count + " word" + ((words.length == 1)?"":"s") + " in the word list:\n";
        for (String w : words) 
        {
            s = s + w + "\n";
        }
        return s;
      }

      public static void main(String[] args) 
      {
        WordList wl = new WordList();
        wl.addWord("Dog");
        System.out.print(wl);
        wl.addWord("Dog");
        System.out.print(wl);
        wl.removeWord("Dog");
        wl.addWord("Cat");
        wl.addWord("Fish");
        wl.addWord("Horse");
        System.out.print(wl);
        if (wl.findWord("Cat") >= 0)
          System.out.println("Cat is in the word list");
        if (wl.findWord("Dog") >= 0)
          System.out.println("Dog is in the word list");
        WordList myList = new WordList();
        myList.addWord("Cat");
        myList.addWord("Horse");
        myList.addWord("Fish");
        if (wl.equals(myList))
          System.out.println("The two lists are the same");
      }
}
