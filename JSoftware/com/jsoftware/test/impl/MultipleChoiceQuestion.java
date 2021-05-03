package com.jsoftware.test.impl;

import com.jsoftware.test.api.IMultipleChoiceQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class MultipleChoiceQuestion extends Question implements IMultipleChoiceQuestion {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // Variables
  private String[] choices;
  private int answer;

  // Constructor
  public MultipleChoiceQuestion(String question, String[] choices, int answer) {
    super(question);
    this.choices = choices;
    this.answer = answer;
  }

  //---------------Set and Get Methods----------------------------------//

  // Get choices
  public String[] getChoices() {
    return this.choices;
  }

  // Get answer
  public int getAnswer() {
    return this.answer;
  }

  // Set choices
  public void setChoices(String[] choices) {
    this.choices = choices;
  }

  // Set answer
  public void setAnswer(int answer) {
    this.answer = answer;
  }

  //----------------------Other Methods--------------------------------//

  // Check the answer
  @Override
  public boolean checkAnswer(int index) {
    if (this.answer == index) {
      return true;
    }
    else {
      return false;
    }
  }


}
