/*
 Sofia Pareja     PEN number 133543876
Improved FriendsBook


*/


package com.example.friendsbook;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;


public class HelloController {
    public Button btnCreateFriend;
    public TextField getEmail;
    public TextField getGrade;
    public TextField getName;
    public TextField getSchool;
    public ListView friendsList;

    public Button btnDeleteFriend;
    public Label labelGradeError;
    public Label labelGradeError2;
    public Button btnDeleteFile;
    public TextField fieldCreateFile;
    public Button btnOkCreate;
    public ListView listFiles;
    public Label labelCreateFile;
    public Label labelFileInList;
    public Tab tabFRIENDSLIST;
    public Tab tabTXTLIST;
    public Button btnUpdateFile;
    public Button btnLoadFromFile;
    public Label labelTXTerror;
    public TextArea textArea;

    @FXML

    private void initialize(){
        // this fills the listview with all of the files currently in the directory
        updateListFiles();
        textArea.setWrapText(true);
    }

    private void updateListFiles(){
        String myDir = System.getProperty("user.dir"); // this is the current directory

        File f = new File(myDir);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            } // this filters out non-txt files
        };
        File[] files = f.listFiles(filter);
        for (int i = 0; i < files.length; i++) {
            listFiles.getItems().add(files[i].getName());
        }

    }

    public static void checkGrade (int grade){
        if (grade < 0 || grade > 12){
            throw new ArithmeticException("Grade not valid");
        }
    }


    public void CreateFriend(ActionEvent actionEvent) {
        boolean isInputValid = true;
        int grade = 0;
        try{
            grade = Integer.parseInt(getGrade.getText());
            try {
                checkGrade(grade);
            }
            catch(ArithmeticException e){
                labelGradeError.setText("Error: Grade must be");
                labelGradeError2.setText("between 1 and 12");
                isInputValid = false;
            }

        }
        catch(Exception e){
            labelGradeError.setText("Error: Grade must ");
            labelGradeError2.setText("be an integer");
            isInputValid = false;
        }
        if (isInputValid == true){
            String name = getName.getText();
            String school = getSchool.getText();
            String email = getEmail.getText();
            Friend temp = new Friend(name, grade, school, email);
            friendsList.getItems().add(temp);
            labelGradeError2.setText("");
            labelGradeError.setText(" ");
            getEmail.clear();
            getGrade.clear();
            getName.clear();
            getSchool.clear();
            btnDeleteFriend.setDisable(true);
            btnDeleteFriend.setVisible(false);
        }

    }


    public void displayFriend(MouseEvent mouseEvent) {
        if (friendsList.getSelectionModel().getSelectedItem() != null){
            btnDeleteFriend.setText("Delete Friend:");
            btnDeleteFriend.setDisable(false);
            btnDeleteFriend.setVisible(true);
        }
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = (Friend) friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(temp);
        btnDeleteFriend.setText(" ");
        btnDeleteFriend.setDisable(true);
        btnDeleteFriend.setVisible(false);
    }


    public void fileSelected(MouseEvent mouseEvent) {
        friendsList.getItems().clear();
        btnDeleteFile.setDisable(false);
        labelFileInList.setText((String) listFiles.getSelectionModel().getSelectedItem());
        tabFRIENDSLIST.setDisable(false);



    }

    public void deleteFile(ActionEvent actionEvent) {


        String fileTBDString = (String) listFiles.getSelectionModel().getSelectedItem();
        File fileTBD = new File(fileTBDString);
        listFiles.getItems().remove(fileTBDString);
        fileTBD.delete();
        labelFileInList.setText(" ");
        tabFRIENDSLIST.setDisable(true);
        btnDeleteFile.setDisable(true);




    }

    public void createFile(ActionEvent actionEvent) throws IOException {
        String newFile = fieldCreateFile.getText();
        boolean fileIsValid = newFile.endsWith("txt");

        if (fileIsValid && !listFiles.getItems().contains(newFile) ){
            listFiles.getItems().add(newFile);
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
            labelTXTerror.setText(" ");
            fieldCreateFile.clear();
        }
        else if (fileIsValid && listFiles.getItems().contains(newFile)){
            labelTXTerror.setText("That file already exists");
        }
        else if (!fileIsValid ){
            labelTXTerror.setText("The file must end with '.txt' ");
        }

    }

    public void updateFile(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = friendsList.getItems();
        boolean firstTime = true;

        String fileTBDString =  labelFileInList.getText();
        File fileTBD = new File(fileTBDString);
        fileTBD.delete();
        FileWriter fw = new FileWriter(fileTBDString);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();


        for (Friend f: myList){
            if (firstTime ){
                f.writeToFile1((String) listFiles.getSelectionModel().getSelectedItem());
                firstTime = false;
            }
            else{
                f.writeToFile2((String) listFiles.getSelectionModel().getSelectedItem());
            }

        }

        friendsList.getItems().clear();
    }

    public void loadFromFile(ActionEvent actionEvent) throws IOException {
        friendsList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends((String) listFiles.getSelectionModel().getSelectedItem());
        for (Friend f: friends){
            friendsList.getItems().add(f);
        }
        friends.clear();
    }
}