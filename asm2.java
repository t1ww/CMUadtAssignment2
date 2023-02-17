import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class asm2 {
    // counters
    static int charactersC = 0;
    static int palindromeC = 0;
    static int tokenC = 0;
    static int emoticonC = 0;
    static int newLineC = 0;
    static String totalTime;
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        //
        File f = new File("input1.txt");
        Scanner scan = new Scanner(f);
        while(scan.hasNextLine()){
            String dataLine = scan.nextLine();
            StringTokenizer token = new StringTokenizer(dataLine, " ");
            while(token.hasMoreTokens()){
                String tempTok = token.nextToken();
                //count characters
                charactersC += tempTok.length();
                //count emoticon
                emoticonC += countEmoticon(tempTok);
                //count palindromes
                palindromeC += countPalin(tempTok);
                //count token
                tokenC++;
            }

            //count nextline
            newLineC++;
        }
        // runtimer
        long endTime   = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("#0.00");
        totalTime = formatter.format((endTime - startTime) / 20000000d);
        // output
        System.out.println(toStrings());
        scan.close();
        Success();
    }

////// METHODS

    // palindrome
    static boolean checkPalin(String word)
    {
        int n = word.length();
        word = word.toLowerCase();
        for (int i=0; i<n; i++,n--)
           if (word.charAt(i) != word.charAt(n - 1))
              return false;      
        return true;
    }
     
    // Function to count palindrome words
    static int countPalin(String str)
    {       
        // to check last word for palindrome
        str = str + " ";
         
        // to store each word
        String word = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
             
            // extracting each word
            if (ch != ' ')
                word = word + ch;
            else {
                if (checkPalin(word))
                    count++;
                word = "";
            }
        }
         
        return count;
    }

    //emoticon
    static boolean checkEmoticon(String str){
        //list of all emoticon
        String[] emoticons = {":D",":)","c:"};
        //
        for (int i=0; i<emoticons.length; i++){
            if(str.equals(emoticons[i])){
                System.out.println(str);
                return true;
            }
        }
        return false;
    }
    static int countEmoticon(String str){
        int count = 0;
        if (checkEmoticon(str))
            count++;    
        return count;
    }
    
    //

////// output

    public static String toStrings(){
        return  "Total # Character count: " + charactersC + "\n" +
                "Total # Palindrome found: " + palindromeC + "\n" +
                "Total Number of tokens: " + tokenC +"\n" +
                "Total Number of emoticon: " + emoticonC + "\n" +
                "Total # of new line: " + newLineC + "\n" +
                "The longest and average token size token" + "\n" +
                "Total time to execute this program " + totalTime + " secs"
        ;
    }
    public static void Success(){
        //program end
        System.out.println("\n///////////////////////////////////////");
        System.out.println("/////////program terminated successfully");
        System.out.println("//////////////////////////////////////////");
    }
}