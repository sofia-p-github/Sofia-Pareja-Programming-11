
/*
 Sofia Pareja     PEN number 133543876
Programming History Assignment


*/
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void checkWord(String word, ArrayList <String> source, ArrayList <Integer>results){
        for (int i = 0; i < source.size(); i++){

            if (source.get(i).contains(word) == true){
                results.add(i+1);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>(); // this will hold the lines from Programming History
        boolean fileError = false;
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line); // this reads each line and adds it to the ArrayList lines
        }
        br.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // this reads input
        System.out.println(" Which word will you search for?");
        String word = in.readLine(); // the variable word is now the word you typed in
        System.out.println("Searching for: " + word);
        ArrayList<Integer> results = new ArrayList<Integer>(); // this will hold the index position of the ArrayList where the word is in
        checkWord(word,lines,results); // checks each ArrayList element for the word, adds each index position to results
        if (results.size() > 0){ // checking if the word was there or not
            System.out.print("The lines where " + word + " appears: ");
            for (int i = 0; i < results.size();i++){
                System.out.print(results.get(i) + ", " );
            }
        }
        else{
            System.out.println("The word " + word + " was not found in the file"); // this only happens if you search a word not in the file (like unicorn)
        }







    }
}
