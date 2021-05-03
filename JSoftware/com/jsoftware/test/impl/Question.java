package com.jsoftware.test.impl;

import java.io.Serializable;

import com.jsoftware.test.api.IQuestion;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class Question implements IQuestion, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // Variables
  private String question;

  // Constructor
  public Question(String question) {
    this.question = question;
  }
  
  // Getter method for question variable
  public String getQuestion() {
    return this.question;
  }

}
