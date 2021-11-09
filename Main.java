import java.util.Scanner;
class Main {
  public String getGreeting()
  {
    return "hey i'm mathy and i'm 16. what's up?";
  }
  public String getResponse(String statement)
   {
      String response = "";
      if (statement.length() == 0)
      {
         response = "helloooo u there?";
         Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponse(z);
      }
      else if(isQuestion(statement))
      {
        response = getRandomResponseQuestion();
      }
      else if (findKeyword(statement, "good") >= 0)
      {
        response = "well good for you i guess";
      }
      else if (findKeyword(statement, "bad") >= 0)
      {
        response = "don't really care but feel better soon";
      }
    
       else
         {
            response = getRandomResponse();
         }
      
      return response;
   }
   public String getResponseName(String statement)
   {
     String response = "";
     if (statement.length() == 0)
      {
         response = "i asked what ur name was";
         Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseName(z);
      }
      else if(isQuestion(statement))
      {
        response = getRandomResponseQuestion();
      }
      else{
        response = "nice to meet you " +statement + " !!" ;
      }
      return response;
   }
   public String getResponseSchool(String statement)
   {
     String response = "";
     if (statement.length() == 0)
      {
         response = "helloooo u there?";
         Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseSchool(z);
      }
    else if(isQuestion(statement))
      {
        response = getRandomResponseQuestion();
      }
    else if (findKeyword(statement, "good") >= 0
      || findKeyword(statement, "easy") >= 0
      ||findKeyword(statement, "fun") >= 0
      || findKeyword(statement, "fine") >= 0
      || findKeyword(statement, "okay") >= 0)
      {
        response = "that's good ig. keep up the hard work";
      }
    else if (findKeyword(statement, "hard") >= 0
      || findKeyword(statement, "boring") >= 0
      ||findKeyword(statement, "difficult") >= 0
      || findKeyword(statement, "bad") >= 0
      || findKeyword(statement, "don't like") >= 0)
      {
        response = "u slacker! go do ur late assignments";
      }
    else 
    {
      response = getRandomResponse();
    }
    return response;
   }
   
   public String getResponseSubject(String statement)
   {
     String response = "";
     if (statement.length() == 0)
      {
         response = "bro type something";
         Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseSubject(z);
      }
      else if(isQuestion(statement))
      {
        response = getRandomResponseQuestion();
      }
    else if (findKeyword(statement, "math") >= 0)
      {
        response = "i HATE math.. it all started when my mother named me mathy...";
      }
    else if (findKeyword(statement, "english") >= 0)
      {
        response = "great! my fav book is the dictionary";
      }
      else if (findKeyword(statement, "history") >= 0)
      {
        response = "i don't like history because it's too hard to remember people. like what's the deal with royalty naming everyone George, Henry, or Elizabeth?";
      }
    else 
    {
      System.out.println("im sorry, what did u mean by \"" + statement + "\"?" + " do u like math, english, or history?");
      Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseSubject(z);
      }
      return response;
   }

public String getResponseTest(String statement)
{
  String response = "";
     if (statement.length() == 0)
      {
         response = "don't leave me in the dust. How did u do?";
         Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseTest(z);
      }
      else if(isQuestion(statement))
      {
        response = getRandomResponseQuestion();
      }
    else if (findKeyword(statement, "A") >= 0
    || findKeyword(statement, "good") >= 0
    || findKeyword(statement, "B") >= 0
    || statement.indexOf("ok") >=0)
      {
        response = "ok neeeeerd. U need to tutor me cuz i completely bombed :(";
      }
    else if (findKeyword(statement, "bad") >= 0
    || findKeyword(statement, "C") >= 0
    || findKeyword(statement, "D") >= 0
    || findKeyword(statement, "F") >=0
    || findKeyword(statement, "terrible") >= 0)
      {
        response = "HA! i got an A ;P TAKE THE L";
      }
    else 
    {
      System.out.println("im sorry, what did u mean by \"" + statement + "\"?" + " what grade did u get?");
      Scanner sc = new Scanner(System.in);
      String z = sc.nextLine();
      response = getResponseTest(z);
      }
      return response;
  
}

public boolean isQuestion(String statement)
{
  return statement.indexOf("?") >= 0;
}
   
   private int findKeyword(String statement, String goal, int startPos)
   {
      String phrase = statement.trim();
      //  The only change to incorporate the startPos is in the line below
      int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

      //  Refinement--make sure the goal isn't part of a word
      while (psn >= 0)
      {
         //  Find the string of length 1 before and after the word
         String before = " ", after = " ";
         if (psn > 0)
         {
            before = phrase.substring (psn - 1, psn).toLowerCase();
         }
         if (psn + goal.length() < phrase.length())
         {
            after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
         }

         //  If before and after aren't letters, we've found the word
         if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
         && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
         {
            return psn;
         }

         //  The last position didn't work, so let's find the next, if there is one.
         psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

      }

      return -1;
   }

   /**
    * Search for one word in phrase.  The search is not case sensitive.
    * This method will check that the given goal is not a substring of a longer string
    * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
    * @param statement the string to search
    * @param goal the string to search for
    * @return the index of the first occurrence of goal in statement or -1 if it's not found
    */
   public int findKeyword(String statement, String goal)
   {
      return findKeyword (statement, goal, 0);
   }

   /**
    * Pick a default response to use if nothing else fits.
    * @return a non-committal string
    */
   private String getRandomResponse()
   {
      final int NUMBER_OF_RESPONSES = 4;
      double r = Math.random();
      int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
      String response = "";

      if (whichResponse == 0)
      {
         response = "i was kidding. i don't really care ^^";
      }
      else if (whichResponse == 1)
      {
         response = "well that's interesting";
      }
      else if (whichResponse == 2)
      {
         response = "i don't really know what to say to that";
      }
      else if (whichResponse == 3)
      {
         response = "You don't say.";
      }

      return response;
   }
   public String getRandomResponseQuestion()
   {
     final int NUMBER_OF_RESPONSES = 4;
      double r = Math.random();
      int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
      String response = "";

      if (whichResponse == 0)
      {
         response = "i don't know!! google it";
      }
      else if (whichResponse == 1)
      {
         response = "i'm not really sure how to answer that";
      }
      else if (whichResponse == 2)
      {
         response = "man idk...";
      }
      else if (whichResponse == 3)
      {
         response = "i'm stumped, ask me something else.";
      }
      return response;
   }


  public static void main(String[] args) {
    Main main3 = new Main();
    Scanner sc = new Scanner(System.in);
    System.out.println(main3.getGreeting());
    String statement = sc.nextLine();

             System.out.println("Response: " + main3.getResponse(statement));
    System.out.println("what's ur name?");
    String d = sc.nextLine();
    System.out.println("Response: " + main3.getResponseName(d));
    System.out.println("how's school");
    String s = sc.nextLine();
    System.out.println("Response: " + main3.getResponseSchool(s));
    System.out.println("on the subject about school, what is ur fave subject?");
    String b = sc.nextLine();
    System.out.println("Response: " + main3.getResponseSubject(b));
    System.out.println("How did you do on ur last math test?");
    String f = sc.nextLine();
    System.out.println("Response: " + main3.getResponseTest(f));
    System.out.println("it was ok talking to u i guess....i'm gonna go cry over math. cya");
    
  }
  
  
}