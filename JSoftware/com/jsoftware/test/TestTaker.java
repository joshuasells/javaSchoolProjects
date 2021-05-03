package com.jsoftware.test;

import java.io.IOException;
import java.util.Scanner;

import com.jsoftware.test.api.IQuestionFactory;
import com.jsoftware.test.api.IQuestionSet;
import com.jsoftware.test.impl.FillInBlanksQuestion;
import com.jsoftware.test.impl.MultipleChoiceQuestion;
import com.jsoftware.test.impl.QuestionFactory;
import com.jsoftware.test.impl.QuestionSet;
import com.jsoftware.test.impl.ShortAnswerQuestion;
import com.jsoftware.test.impl.TrueFalseQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class TestTaker {
  public static void main(String[] args) throws IOException {

    // boolean for loop control
    boolean b = true;

    // Start by creating a QuestionFactory and QuestionSet
    IQuestionFactory questFact = new QuestionFactory();
    IQuestionSet test = new QuestionSet();


    System.out.println("Welcome to the TestTaker program!\n");
    System.out.print("What test would you like to take?  ");

    Scanner input = new Scanner(System.in);

    String testName = input.nextLine();

    test = questFact.load(testName + ".dat");

    if (test == null) {
      System.out.println("An error occured");
      System.exit(2);
    }

    System.out.println("\nTest loaded successful!\n");
    System.out.println("Enter 1 to take a whole test or 2 to take a sample test.");

    while (b) {

      System.out.print("Your choice: ");
      String choice = input.nextLine();

      switch(choice) {
        case "1":
          b = false;
          System.out.println("\n----------------------------");
          System.out.println("The test starts now!");
          System.out.println("----------------------------\n");

          takeTest(test);
          break;
        
        case "2":
          b = false;

          System.out.print("How many questions would you like to sample?");
          int size = input.nextInt();
          input.nextLine();
          System.out.println("\n----------------------------");
          System.out.println("The test starts now!");
          System.out.println("----------------------------\n");

          IQuestionSet sampleTest = test.randomSample(size);

          takeTest(sampleTest);
          break;
  
        default:
          System.out.print("Please enter 1 or 2.\n");
  
      }
    }
    input.close();
  }

  // Method for taking the test. It recieves an IQuestionSet instance and tests the user.
  public static void takeTest(IQuestionSet test) {
    // Create a new Scanner.
    Scanner input = new Scanner(System.in);
    // Variable to track correct answers.
    int correctAnswers = 0;
    // loop through each question
    for (int i = 0; i < test.size(); i++) {
      // display question
      System.out.println("Question " + (i + 1) + " of " + test.size());
      System.out.println("----------------");
      System.out.println(test.getQuestion(i).getQuestion());

      // if multiple choice, then display choices.
      if (test.getQuestion(i) instanceof MultipleChoiceQuestion) {
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) test.getQuestion(i);
        String[] mcqChoices = mcq.getChoices();
        for (int j = 0; j < mcqChoices.length; j++) {
          System.out.println("\t" + (j+1) + ") " + mcqChoices[j]);
        }
      }

      System.out.print("Your answer: ");
      String answer = input.nextLine();

      // If multiple choice question, then explicit cast and check answer.
      if (test.getQuestion(i) instanceof MultipleChoiceQuestion) {
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) test.getQuestion(i);
        int mCAnswer = Integer.parseInt(answer);
        if (mcq.checkAnswer(mCAnswer - 1)) {
          System.out.println("You got it!\n");
          correctAnswers++;
        }
        else {
          System.out.println("Wrong!\n");
        }
      }

      // If true false question, then explicit cast and check answwer.
      if (test.getQuestion(i) instanceof TrueFalseQuestion) {
        TrueFalseQuestion tfq = (TrueFalseQuestion) test.getQuestion(i);
        boolean tfAnswer;
        if (answer.equalsIgnoreCase("true")) {
          tfAnswer = true;
        }
        else {
          tfAnswer = false;
        }
        if (tfq.checkAnswer(tfAnswer)) {
          System.out.println("You got it!\n");
          correctAnswers++;
        }
        else {
          System.out.println("Wrong!\n");
        }
      }

      // If Fill in the blank question, then explicit cast and check answer.
      if (test.getQuestion(i) instanceof FillInBlanksQuestion) {
        FillInBlanksQuestion fibq = (FillInBlanksQuestion) test.getQuestion(i);
        String[] fibAnswer = answer.split("\\s*,\\s*");

        if (fibq.checkAnswer(fibAnswer)) {
          System.out.println("You got it!\n");
          correctAnswers++;
        }
        else {
          System.out.println("Wrong!\n");
        }
      }

      // If Short answer question, then explicit cast and check answer.
      if (test.getQuestion(i) instanceof ShortAnswerQuestion) {
        ShortAnswerQuestion saq = (ShortAnswerQuestion) test.getQuestion(i);

        if (saq.checkAnswer(answer)) {
          System.out.println("You got it!\n");
          correctAnswers++;
        }
        else {
          System.out.println("Wrong!\n");
        }
      }

    }

    // Display to user their score.
    System.out.println("You got " + correctAnswers + " questions right out of " + test.size() + " questions total.\n\n");
    input.close();

  }
}
