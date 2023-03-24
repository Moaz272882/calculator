package com.example.calcilator;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox screen_box = new HBox();
        GridPane Buttons_pane = new GridPane();
        BorderPane calculator = new BorderPane();
        //Text area to show results
        TextArea screen = new TextArea();
        screen.setMaxHeight(50);
        screen.setMaxWidth(350);
        screen_box.getChildren().add(screen);

        //Buttons
        Button bt1 = new Button("1");
        Button bt2 = new Button("2");
        Button bt3 = new Button("3");
        Button bt4 = new Button("4");
        Button bt5 = new Button("5");
        Button bt6 = new Button("6");
        Button bt7 = new Button("7");
        Button bt8 = new Button("8");
        Button bt9 = new Button("9");
        Button plus = new Button("+");
        Button minus = new Button(" - ");
        Button multiply = new Button(" * ");
        Button devide = new Button(" / ");
        Button equal = new Button("=");
        Button clear = new Button("C");
        Button zero = new Button("0");
        Button zero_zero = new Button("00");
        Button percent = new Button("%");

        //adding buttons on screen
        Buttons_pane.add(bt1, 0, 0);
        Buttons_pane.add(bt2, 1, 0);
        Buttons_pane.add(bt3, 2, 0);
        Buttons_pane.add(bt4, 0, 1);
        Buttons_pane.add(bt5, 1, 1);
        Buttons_pane.add(bt6, 2, 1);
        Buttons_pane.add(bt7, 0, 2);
        Buttons_pane.add(bt8, 1, 2);
        Buttons_pane.add(bt9, 2, 2);
        Buttons_pane.add(plus, 3, 0);
        Buttons_pane.add(minus, 3, 1);
        Buttons_pane.add(multiply, 3, 2);
        Buttons_pane.add(devide, 3, 3);
        Buttons_pane.add(equal, 2, 3);
        Buttons_pane.add(clear, 2, 4);
        Buttons_pane.add(zero, 0, 3);
        Buttons_pane.add(zero_zero, 1, 3);
        Buttons_pane.add(percent, 3, 4);
        Buttons_pane.setHgap(50);
        Buttons_pane.setVgap(50);

//resizing buttons for appropriate size
        bt1.setPrefHeight(40);
        bt1.setPrefWidth(60);
        bt2.setPrefHeight(40);
        bt2.setPrefWidth(60);
        bt3.setPrefHeight(40);
        bt3.setPrefWidth(60);
        bt4.setPrefHeight(40);
        bt4.setPrefWidth(60);
        bt5.setPrefHeight(40);
        bt5.setPrefWidth(60);
        bt6.setPrefHeight(40);
        bt6.setPrefWidth(60);
        bt7.setPrefHeight(40);
        bt7.setPrefWidth(60);
        bt8.setPrefHeight(40);
        bt8.setPrefWidth(60);
        bt9.setPrefHeight(40);
        bt9.setPrefWidth(60);
        plus.setPrefHeight(40);
        plus.setPrefWidth(60);
        minus.setPrefHeight(40);
        minus.setPrefWidth(60);
        devide.setPrefHeight(40);
        devide.setPrefWidth(60);
        clear.setPrefHeight(40);
        clear.setPrefWidth(60);
        equal.setPrefHeight(40);
        equal.setPrefWidth(60);
        zero_zero.setPrefHeight(40);
        zero_zero.setPrefWidth(60);
        zero.setPrefHeight(40);
        zero.setPrefWidth(60);
        multiply.setPrefHeight(40);
        multiply.setPrefWidth(60);
        percent.setPrefHeight(40);
        percent.setPrefWidth(60);

//setting buttons on action
        multiply.setOnAction(EventHandler -> {
            screen.setText(screen.getText() +multiply.getText());
        });

        plus.setOnAction(EventHandler -> {
            screen.setText(screen.getText() +plus.getText());
        });

        minus.setOnAction(EventHandler -> {
            screen.setText(screen.getText() +minus.getText());
        });

        devide.setOnAction(EventHandler -> {
            screen.setText(screen.getText() +devide.getText());
        });
        percent.setOnAction(EventHandler -> {
            screen.setText(screen.getText() +percent.getText());
        });
        clear.setOnAction(EventHandler -> {
            screen.setText(" ");
        });
        zero.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + zero.getText());
        });
        zero_zero.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + zero_zero.getText());
        });
        bt1.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt1.getText() + "");

        });
        bt2.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt2.getText());
        });
        bt3.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt3.getText());
        });

        bt4.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt4.getText());
        });
        bt5.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt5.getText());
        });
        bt6.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt6.getText());
        });
        bt7.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt7.getText());
        });
        bt8.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt8.getText());
        });
        bt9.setOnAction(EventHandler -> {
            screen.setText(screen.getText() + bt9.getText());
        });
        equal.setOnAction(EventHandler -> {
            screen.setText(String.valueOf(operation(screen.getText())));
        });



        //setting the layout
        screen_box.setAlignment(Pos.TOP_CENTER);
        Buttons_pane.setAlignment(Pos.CENTER);
        calculator.setTop(screen_box);
        calculator.setCenter(Buttons_pane);

        Scene scene = new Scene(calculator, 500, 500);
        stage.setTitle("Animation!");
        stage.setScene(scene);
        stage.show();
    }

    static double operation(String screen_text){
        char temp[] =  screen_text.toCharArray();
        int  sign_index = 0 ;

        String sign = " ";
        Double  result = 0.0 ;

        Character text_array[] =  new Character[screen_text.length()];
        for (int i =0;i<screen_text.length();i++){
            text_array[i] = temp[i];
        }

//asigning the sign to the sign and deviding the array into number1 and number2
        for (int j = 0 ; j< text_array.length;j++){
            if (!Character.isDigit(text_array[j])){
                sign_index = j;
                sign = String.valueOf(text_array[j]);
            }
        }
        //number1
        char number_1[] = new char[sign_index];
        //number2
        char number_2[] = new char[text_array.length - sign_index -1];
        //creating a character array of number1 and number2
        for (int k =0; k< number_1.length;k++){
            number_1[k] = text_array[k];
        }
        for (int l =0; l< number_2.length;l++){
            number_2[l] = text_array[l];
        }

        String num1 = String.valueOf(number_1);
        double number1 = Double.parseDouble(num1);
        String num2 = String.valueOf(number_2);
        double number2 = Double.parseDouble(num2);
        switch (sign){

            case "-" :
                result = number1 - number2;
                break;
            case "*" :
                result = number1 * number2;
                break;
            case "/" :
                result = number1 / number2;
                break;
            case "+":
                result = number1 +number2;
                break;
            default:
                System.out.println("Please enter a valid operation sign !");
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        launch();
    }
}