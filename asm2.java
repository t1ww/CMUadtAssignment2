/*
 * @author Narongchai Rongthong
 * 652115013
 * written on 17/02/2023
 * https://github.com/t1ww
 */

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
    static int longestToken = 0;
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        //
        Scanner scan = new Scanner(new File("input1.txt"));
        while(scan.hasNextLine()){
            String dataLine = scan.nextLine();
            StringTokenizer token = new StringTokenizer(dataLine, " ");
            while(token.hasMoreTokens()){
                String tempTok = token.nextToken();
                //count emoticon
                if (checkEmoticon(tempTok))
                    emoticonC++;
                //count palindromes
                if (checkPalin(tempTok))
                    palindromeC++;
                //count characters
                charactersC += tempTok.length();
                //longest token
                longestToken = (tempTok.length() > longestToken)? tempTok.length() : longestToken;
                //count token
                tokenC++;
            }

            //count nextline
            newLineC++;
        }
        // runtimer
        long endTime   = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.0");
        totalTime = formatter.format((endTime - startTime) /10d);
        // output
        System.out.println(toStrings());
        scan.close();

//program end
           System.out.println("\n/ terminated successfully");
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

    //emoticon
    static boolean checkEmoticon(String str){
        //list of all emoticon
        String[] emoticons = {":D","D:",":)","<:","c:",":c","C:",":C","xd","xD","XD",":o",":O",":0",
        ":P",";D",";)","c;","<3"
        };
        //
        for (int i=0; i<emoticons.length; i++){
            if(str.equals(emoticons[i])){
                return true;
            }
        }
        return false;
    }
    //

////// output

    public static String toStrings(){
        int average = (charactersC/tokenC);
        return  "Total # Character count: " + charactersC + "\n" +
                "Total # Palindrome found: " + palindromeC + "\n" +
                "Total Number of tokens: " + tokenC +"\n" +
                "Total Number of emoticon: " + emoticonC + "\n" +
                "Total # of new line: " + newLineC + "\n" +
                "The longest token = " + longestToken + "\n" +
                "average token size token = " + average + "\n" +
                "Total time to execute this program " + totalTime + " secs"
        ;
    }
}
