package com.jsoftware.test.impl;

import com.jsoftware.test.api.IShortAnswerQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class ShortAnswerQuestion extends Question implements IShortAnswerQuestion {
  
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // Variable
  private String[] keywords;

  // Constructor
  public ShortAnswerQuestion(String question, String[] keywords) {
    super(question);
    this.keywords = keywords;
  }

  //-----------------Set and Get methods----------------------------//

  // Get the keywords
  public String[] getKeywords() {
    return this.keywords;
  }

  // Set the keywords
  public void setKeywords(String[] keywords) {
    this.keywords = keywords;
  }

  //---------------------Other Methods------------------------------//

  // Check the answer
  @Override
  public boolean checkAnswer(String answer) {
    for (int i = 0; i < keywords.length; i++) {
      if (answer.contains(keywords[i])) {
        return true;
      }
    }
    return false;
  }
}
