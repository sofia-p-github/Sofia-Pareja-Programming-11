package com.example.friendsbook;
import java.io.*;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static int grade;
    private static String school;
    private static String email;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String fileName) throws IOException{
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            parseFriend(line);
        }

        return friends;
    }

    private static void parseFriend(String string){
        int c1 = string.indexOf(",");
        int c2 = string.indexOf(",",c1+1);
        int c3 = string.indexOf(",",c2+1);
        String name = string.substring(0,c1);
        int grade = Integer.parseInt(string.substring(c1+1,c2));
        String school = string.substring(c2+1,c3);
        String email = string.substring(c3+1);

        friends.add(new Friend(name, grade, school, email));


    }



}
