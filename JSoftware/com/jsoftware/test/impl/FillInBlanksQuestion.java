package com.jsoftware.test.impl;

import com.jsoftware.test.api.IFillInBlanksQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class FillInBlanksQuestion extends Question implements IFillInBlanksQuestion {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  // Variables
  private String[] answer;

  // Constructor
  public FillInBlanksQuestion(String question, String[] answer) {
    super(question);
    this.answer = answer;
  }

  //--------------------------Get and Set Methods---------------------//

  // Get answer
  public String[] getAnswer() {
    return answer;
  }

  // Set answer
  public void setAnswer(String[] answer) {
    this.answer = answer;
  }

  //---------------Other Methods----------------------//
  
  // Check the answer
  @Override
  public boolean checkAnswer(String[] keywords) {
    for (int i = 0; i < this.answer.length; i++) {
      if (!(keywords[i].equalsIgnoreCase(answer[i]))) {
        return false;
      }
    }
    if (keywords.length != answer.length) {
      return false;
    }
    return true;
  }
  
}
