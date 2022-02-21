import org.junit.internal.runners.model.EachTestNotifier;

import java.util.Scanner;

/*
2173440
Sofia Pareja Project 1
*/
public class Main {
    static int problemOne(String s){
        int vowelCounter = 0;
        char[] inputArray = new char[s.length()]; // Creating an array of all the letters in the string
        for (int i = 0; i < s.length(); i++){
            inputArray[i] = s.charAt(i);
        }
        for (int i = 0; i < inputArray.length; i++){ // this checks how many vowels are in the string
            if((inputArray[i] == 'a' )|| (inputArray[i] == 'i') || (inputArray[i] == 'o')|| (inputArray[i] == 'u') || (inputArray[i] == 'e')){
                vowelCounter ++;
            }
        }

        return vowelCounter;
    }

    static int problemTwo(String s){
        int bobCounter = 0;
        char[] inputArray = new char[s.length()]; // Creating an array of all the letters in the string
        for (int i = 0; i < s.length(); i++){
            inputArray[i] = s.charAt(i);
        }
        for (int i = 0; i < inputArray.length -2; i++){
            if((inputArray[i] == 'b') && (inputArray[i+1] == 'o') && (inputArray[i+2] == 'b')){ // checks how many times 'bob' appears
                bobCounter += 1;
            }
        }
        //TODO
        return bobCounter;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        char[] inputArray = new char[s.length()]; // Creating an array of all the letters in the string
        for (int i = 0; i < s.length(); i++) {
            inputArray[i] = s.charAt(i);
        }

        int[] substringStart = new int[inputArray.length]; //the start of each substring
        int[] substringEnd = new int[inputArray.length]; // the end of each substring
        int currentLength = 1; // length of current substring
        int substringNum = 0; // number of substrings in string
        int[] substringLength = new int [inputArray.length]; // length of each substring
        for (int i = 1; i < inputArray.length; i++){
              if ((inputArray[i] > inputArray[i-1]) || (inputArray[i] == inputArray[i-1])){ // checking if the letters are in alphabetical order
                  currentLength +=1;
                  if (i == (inputArray.length-1 )){ // if it's the end of the string, ending the substring as well
                      substringStart[substringNum] = i - (currentLength-1);
                      if (substringStart[substringNum] == -1){
                          substringStart[substringNum] = 0;
                      }
                      substringEnd[substringNum] = i +1;
                      substringLength[substringNum] = currentLength;
                      substringNum += 1;
                  }
              }
              else if (inputArray[i] < inputArray[i-1]){ // if the letters aren't in alphabetical order, end of substring
                  substringStart[substringNum] = i - (currentLength); // substring start is recorded
                  substringEnd[substringNum] = i; // substring end is recorded
                  substringLength[substringNum] = currentLength; // length of substring
                  currentLength = 1;
                  substringNum += 1;
              }



        }
        int longestLength = 1;
        int answerStart = 0;
        int answerEnd = 1;
        for (int i = 0; i < substringNum; i++){ //checking all substrings
            if (substringLength[i] > longestLength){ // checking if the substring is the longest
                answerStart = substringStart[i];
                answerEnd = substringEnd[i];
                longestLength = substringLength[i];
            }
        }


        return s.substring(answerStart,answerEnd);
    }
    public static void main(String[] args) {


    }
}
