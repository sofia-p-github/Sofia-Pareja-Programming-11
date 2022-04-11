package com.example.gameofchance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class HelloController {


    public Button btnDice2;
    public Label labelDice1;
    public Label labelDice2;
    public Label labelCurrentPoints;
    public TextField textBet;
    public Button btnDice1;
    @FXML
    public int points = 100;
    public RadioButton rbtnHigher;
    public RadioButton rbtnLower;
    public Button btnPlayAgain;
    public Label labelOutcome;
    public Button btnResetGame;
    public Label labelFixBet;
    public Label labelSecondLine;
    @FXML
    ToggleGroup bet = new ToggleGroup();

    private boolean FirstDiceRolled = false;
    private boolean SecondDiceRolled = false;
    public int firstDiceAmount;
    public int secondDiceAmount;
    public String betString;
    public int betAmount;


    @FXML

    public boolean isNumDigit(String num){
        // System.out.println("isNumDigit : "+ num);

        //if (num == "0" || num == "1" || num == "2"|| num == "3" || num == "4" || num == "5" || num == "6"||num=="7"|| num=="8"|| num =="9"){
        if (num.equals("0")  || num.equals("1") || num.equals("2")|| num.equals("3")  || num.equals("4") || num.equals("5")  || num.equals("6") ||num.equals("7")|| num.equals("8")|| num.equals("9")){
          //  System.out.println("is a number : "+ num);
            return true;
        }
        else{
           // System.out.println("is NOT a number : "+ num);
            return false;
        }
    }

    public boolean searchBet(String bet){
        String[] betList = new String[textBet.getText().length()];
        String searchBetList = bet;
       // System.out.println("searchBetList: "+ searchBetList);
        boolean xerror = true;
        //for (int i = 0; i < textBet.getText().length()-1; i++ ){
        for (int i = 0; i < textBet.getText().length(); i++ ){
           // System.out.println("i: " + i);

           // betList[i] = searchBetList.substring(i+1, i);
            betList[i] = searchBetList.substring(i, i+1);
           // System.out.println("betList[i] " + betList[i]);
        }

        // System.out.println("betList.length:" + betList.length);
        for (int i = 0; i < betList.length; i++){

            if (isNumDigit(betList[i]) == true){
                //xerror = true;
                xerror = false;
                //System.out.println("i: " + i);
            }
            else{
               // xerror = false;
                //System.out.println("i: " + i);
                xerror = true;
                break;
            }
        }
        // System.out.println("error:" + xerror);


        return xerror;




    }

    public void showPoints(){


        labelCurrentPoints.setText(Integer.toString(points));
    }



    public void rollFirstDice(ActionEvent actionEvent) {
        if (FirstDiceRolled == false){
            int random = (int)(Math.random()*6 + 1);
            labelDice1.setText(Integer.toString(random));
            FirstDiceRolled = true;
            btnDice1.setDisable(true);
            firstDiceAmount = random;
            textBet.setDisable(false);
        }

    }

    public void getBet(ActionEvent actionEvent) {
       // if (searchBet(textBet.getText()) == true) {
        if (searchBet(textBet.getText()) == false) {
            betAmount = Integer.parseInt(textBet.getText());
            textBet.setDisable(true);
        }
        else{
            labelFixBet.setText("Bet Failed:<- Fix Your Bet");
            labelSecondLine.setText(" Your Bet Must Be An Integer");
            textBet.setDisable(false);
            rbtnLower.setSelected(false);
            rbtnHigher.setSelected(false);

        }

    }
    public void betTyped(KeyEvent keyEvent) {
        rbtnHigher.setDisable(false);
        rbtnLower.setDisable(false);
    }

    public void betHigher(ActionEvent actionEvent) {
       // if ((searchBet(textBet.getText()) == true)){
        if ((searchBet(textBet.getText()) == false)){
            betAmount = Integer.parseInt(textBet.getText());


            if (betAmount <= points){
                rbtnHigher.setDisable(true);
                rbtnLower.setDisable(true);
                textBet.setDisable(true);
                btnDice2.setDisable(false);
                betString = "Higher";
                labelFixBet.setText(" ");
                labelSecondLine.setText(" ");
            }
            else if (betAmount > points){
                labelFixBet.setText("Bet Failed:<- Fix Your Bet");
                labelSecondLine.setText(" Your Bet Cannot Be More Than Your Points");
                textBet.setDisable(false);
                rbtnLower.setSelected(false);
                rbtnHigher.setSelected(false);
            }
        }
        else{
            labelFixBet.setText("Bet Failed:<- Fix Your Bet");
            labelSecondLine.setText(" Your Bet Must Be An Integer");
            textBet.setDisable(false);
            rbtnLower.setSelected(false);
            rbtnHigher.setSelected(false);

        }


    }

    public void betLower(ActionEvent actionEvent) {
       // if (searchBet(textBet.getText()) == true) {
        if (searchBet(textBet.getText()) == false) {
            betAmount = Integer.parseInt(textBet.getText());

            if (betAmount <= points) {
                rbtnHigher.setDisable(true);
                rbtnLower.setDisable(true);
                textBet.setDisable(true);
                betString = "Lower";
                btnDice2.setDisable(false);
                labelFixBet.setText(" ");
                labelSecondLine.setText(" ");
            } else if (betAmount > points) {
                labelFixBet.setText("Bet Failed:<- Fix Your Bet");
                labelSecondLine.setText(" Your Bet Cannot Be More Than Your Points");
                textBet.setDisable(false);
                rbtnLower.setSelected(false);
                rbtnHigher.setSelected(false);
            }
        }
        else{
            labelFixBet.setText("Bet Failed:<- Fix Your Bet");
            labelSecondLine.setText(" Your Bet Must Be An Integer");
            textBet.setDisable(false);
            rbtnLower.setSelected(false);
            rbtnHigher.setSelected(false);

        }
    }

    public void rollSecondDice(ActionEvent actionEvent) {
        if (SecondDiceRolled == false){
            int random = (int)(Math.random()*6 + 1);
            labelDice2.setText(Integer.toString(random));
            betAmount = Integer.parseInt(textBet.getText());
            SecondDiceRolled = true;
            secondDiceAmount = random;

                if (( (firstDiceAmount > secondDiceAmount) && (rbtnLower.isSelected() == true) )|| (firstDiceAmount < secondDiceAmount && rbtnHigher.isSelected() == true)){
                    points += betAmount;
                    labelCurrentPoints.setText(Integer.toString(points));
                    labelOutcome.setText("You Won");

                }
                else{
                    points -= betAmount;
                    labelCurrentPoints.setText(Integer.toString(points));
                    labelOutcome.setText("You Lost");
                }



            btnDice2.setDisable(true);

        }
    }


    public void playAgain (ActionEvent actionEvent) {
        labelDice1.setText(" ");
        labelDice2.setText("");
        labelOutcome.setText(" ");
        FirstDiceRolled = false;
        SecondDiceRolled = false;
        showPoints();
        btnDice1.setDisable(false);
        btnDice2.setDisable(true);
        rbtnLower.setDisable(true);
        rbtnLower.setSelected(false);
        rbtnHigher.setDisable(true);
        rbtnHigher.setSelected(false);
        textBet.setDisable(true);
        textBet.clear();


    }


    public void resetGame(ActionEvent actionEvent) {
        labelDice1.setText(" ");
        labelDice2.setText("");
        labelOutcome.setText("");
        FirstDiceRolled = false;
        SecondDiceRolled = false;

        btnDice1.setDisable(false);
        btnDice2.setDisable(true);
        rbtnLower.setDisable(true);
        rbtnLower.setSelected(false);
        rbtnHigher.setDisable(true);
        rbtnHigher.setSelected(false);
        textBet.setDisable(true);
        textBet.clear();

        points = 100;
        showPoints();
        betString = "";
        betAmount = 0;

    }
}