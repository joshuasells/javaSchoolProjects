package com.jsoftware.test;

import java.util.Scanner;

import com.jsoftware.test.api.IQuestion;
import com.jsoftware.test.api.IQuestionFactory;
import com.jsoftware.test.api.IQuestionSet;
import com.jsoftware.test.impl.MultipleChoiceQuestion;
import com.jsoftware.test.impl.QuestionFactory;
import com.jsoftware.test.impl.QuestionSet;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class TestMaker {
  
  public static void main(String[] args) {

    // Start by creating a QuestionFactory, QuestionSet, and Question
    IQuestionFactory questFact = new QuestionFactory();
    IQuestionSet test = new QuestionSet();
    IQuestion question = null;
    
    System.out.println("Welcome to the TestMaker program!\n");

    System.out.print("What would you like to call this test? ");

    Scanner input = new Scanner(System.in);
    
    String testName = input.nextLine();
      
    while(true) {
      printMenu();

      System.out.print("Your choice: ");

      String choice = input.nextLine();

      // switch to handle menu options
      switch (choice) {

        // MULTIPLE CHOICE
        case "1":
          // Create variables to hold data.
          String mCQuestion;
          String[] mCChoices = new String[4];
          int mCAnswer;

          System.out.println("\nWhat is your multiple-choice question?");
          mCQuestion = input.nextLine();

          System.out.print("\nPlease enter your first choice: ");
          mCChoices[0] = input.nextLine();

          System.out.print("Please enter your second choice: ");
          mCChoices[1] = input.nextLine();

          System.out.print("Please enter your third choice: ");
          mCChoices[2] = input.nextLine();

          System.out.print("Please enter your fourth and last choice: ");
          mCChoices[3] = input.nextLine();

          System.out.print("What choice was the answer? (Enter #1-4): ");
          mCAnswer = input.nextInt() - 1;
          input.nextLine();

          // Create a multiple choice question via qFactory and add it to qset.
          question = questFact.makeMultipleChoice(mCQuestion, mCChoices, mCAnswer);
          test.add(question);
          break;


        // TRUE/FALSE
        case "2":
          // Create variables to hold data.
          String tFQuestion;
          String tFStringAnswer;
          boolean tFAnswer;

          System.out.println("\nWhat is your True/False question?");
          tFQuestion = input.nextLine();

          System.out.println("\nWhat is the answer? (Please enter exactly true or false)");
          tFStringAnswer = input.nextLine().toLowerCase();
          if (tFStringAnswer == "true") {
            tFAnswer = true;
          }
          else {
            tFAnswer = false;
          }

          // Create a true/false question via qFactory and add it to qset.
          question = questFact.makeTrueFalse(tFQuestion, tFAnswer);
          test.add(question);
          break;


        // FILL IN THE BLANK
        case "3":
          // Create variables to hold data.
          String fITBQuestion;
          String fITBStringAnswer;
          String[] fITBAnswer;

          System.out.println("\nWhat is your fill in the blank question?");
          fITBQuestion = input.nextLine();

          System.out.println("\nWhat is the answer? Please separate answers with a comma.");
          fITBStringAnswer = input.nextLine();
          fITBAnswer = fITBStringAnswer.split("\\s*,\\s*");

          // Create a fill in the blank question via qFactory and add it to qset.
          question = questFact.makeFillInBlank(fITBQuestion, fITBAnswer);
          test.add(question);
          break;


        // SHORT ANSWER
        case "4":
          // Create variables to hold data.
          String sAQuestion;

          System.out.println("\nWhat is your short answer question?");
          sAQuestion = input.nextLine();

          System.out.println("\nHow many keywords does your short answer question have?");
          int numKeywords = input.nextInt();
          String[] sAKeywords = new String[numKeywords];
          input.nextLine();

          for (int i = 0; i < numKeywords; i++) {
            System.out.print("What is a keyword in your short answer question? ");
            sAKeywords[i] = input.nextLine();
          }

          // Create a short answer question via qFactory and add it to qset.
          question = questFact.makeShortAnswer(sAQuestion, sAKeywords);
          test.add(question);
          break;


        // REMOVE QUESTION
        case "5":
          System.out.println("\nSelect the index of the question you would like to remove.");
          for (int i = 0; i < test.size(); i++) {
            // Display questions.
            System.out.println("Question " + i + ") " + test.getQuestion(i).getQuestion());

            // If a multiple choice, then display the choices too.
            if (test.getQuestion(i) instanceof MultipleChoiceQuestion) {
              MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) test.getQuestion(i);
              String[] mcqChoices = mcq.getChoices();
              for (int j = 0; j < mcqChoices.length; j++) {
                System.out.println("\t" + (j+1) + ") " + mcqChoices[j]);
              }
            }
          }

          System.out.print("Your choice: ");
          int indexRemove = input.nextInt();
          input.nextLine();

          // Remove question from qset.
          test.remove(indexRemove);
          break;


        // EXIT PROGRAM
        case "6":
          // Save the test to a data file.
          questFact.save(test, testName + ".dat");
          System.out.println("\nTest saved.\nGoodbye!");
          input.close();
          System.exit(1);
        
        default:
          System.out.println("\n\nPlease enter 1-6\n\n");
      }
    }
  }

  // A simple method for printing the Menu of options.
  public static void printMenu() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("\t1) add a multiple-choice question");
    System.out.println("\t2) add a true/false question");
    System.out.println("\t3) add a fill-in-the-blank question");
    System.out.println("\t4) add short answer question");
    System.out.println("\t5) remove a question");
    System.out.println("\t6) exit program");
  }
}
