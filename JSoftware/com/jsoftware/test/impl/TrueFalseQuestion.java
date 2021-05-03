package com.jsoftware.test.impl;

import com.jsoftware.test.api.ITrueFalseQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class TrueFalseQuestion extends Question implements ITrueFalseQuestion {
  
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // Variables
  private boolean answer;

  // Constructor
  public TrueFalseQuestion(String question, boolean answer) {
    super(question + " True/False?");
    this.answer = answer;
  }

  //--------------------Get and Set methods-------------------------------//

  // Get the answer
  public boolean getAnswer() {
    return this.answer;
  }

  // Set the answer
  public void setAnswer(boolean answer) {
    this.answer = answer;
  }

  //--------------Other methods---------------------------------//

  // Check the answer
  @Override
  public boolean checkAnswer(boolean answer) {
    if (this.answer == answer) {
      return true;
    }
    else {
      return false;
    }
  }
}
