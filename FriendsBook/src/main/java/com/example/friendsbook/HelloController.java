package com.example.friendsbook;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class HelloController {
    public Button btnCreateFriend;
    public TextField getEmail;
    public TextField getGrade;
    public TextField getName;
    public TextField getSchool;
    public ListView friendsList;
    public Label labelName;
    public Label labelFriendInfo;
    public Label labelEmail;
    public Label labelSchool;
    public Label labelGrade;
    public Button btnDeleteFriend;
    public Label labelGradeError;
    public Label labelGradeError2;

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
            labelGradeError.setText("Error: Grade must be an integer");
            isInputValid = false;
        }
        if (isInputValid == true){
            String name = getName.getText();
            String school = getSchool.getText();
            String email = getEmail.getText();
            Friend temp = new Friend(name, school,grade,email);
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
        Friend temp;
        temp = (Friend) friendsList.getSelectionModel().getSelectedItem();
        labelFriendInfo.setText("Friend Info: ");
        labelName.setText("Name: " + temp.getName());
        labelEmail.setText("Email: " + temp.getEmail());
        labelGrade.setText("Grade: " + temp.getGrade());
        labelSchool.setText("School: "+ temp.getSchool());
        btnDeleteFriend.setText("Delete Friend:");
        btnDeleteFriend.setDisable(false);
        btnDeleteFriend.setVisible(true);

    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = (Friend) friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(temp);
        labelFriendInfo.setText("");
        labelName.setText("");
        labelEmail.setText("");
        labelGrade.setText("");
        labelSchool.setText(" ");
        btnDeleteFriend.setText(" ");
        btnDeleteFriend.setDisable(true);
        btnDeleteFriend.setVisible(false);
    }
}