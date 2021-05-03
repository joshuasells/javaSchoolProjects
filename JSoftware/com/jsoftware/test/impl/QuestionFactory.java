package com.jsoftware.test.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.jsoftware.test.api.IQuestion;
import com.jsoftware.test.api.IQuestionFactory;
import com.jsoftware.test.api.IQuestionSet;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class QuestionFactory implements IQuestionFactory, Serializable {
  
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // No Variables
  // Default constructor will be used

  // Methods


  // Create Multiple choice question
  @Override
  public IQuestion makeMultipleChoice(String question, String[] choices, int answer) {
    IQuestion q = new MultipleChoiceQuestion(question, choices, answer);
    return q;
  }

  // Create True False question
  @Override
  public IQuestion makeTrueFalse(String question, boolean answer) {
    IQuestion q = new TrueFalseQuestion(question, answer);
    return q;
  }

  // Create Fill In Blanks question
  @Override
  public IQuestion makeFillInBlank(String question, String[] answer) {
    IQuestion q = new FillInBlanksQuestion(question, answer);
    return q;
  }

  // Create Short answer question
  @Override
  public IQuestion makeShortAnswer(String question, String[] keywords) {
    IQuestion q = new ShortAnswerQuestion(question, keywords);
    return q;
  }

  // Load a question set
  @Override
  public IQuestionSet load(String filename) throws IOException {
    try {
      FileInputStream file = new FileInputStream(filename);
      ObjectInputStream input = new ObjectInputStream(file);
      IQuestionSet test = (IQuestionSet)(input.readObject());
      file.close();
      return test;
    }
    catch(FileNotFoundException e) {
      System.out.println("File Doesn't exist!");
      return null;
    }
    catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  // Save a question set
  @Override
  public boolean save(IQuestionSet testSet, String filename) {
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream output = new ObjectOutputStream(file);
      output.writeObject(testSet);
      output.close();
      return true;
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // Create an empty test set
  @Override
  public IQuestionSet makeEmptyQuestionSet() {
    IQuestionSet test = new QuestionSet();
    return test;
  }
}
