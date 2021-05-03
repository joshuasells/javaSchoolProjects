package com.jsoftware.test.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.jsoftware.test.api.IQuestion;
import com.jsoftware.test.api.IQuestionSet;

/**
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Date: 02/06/2021
 * 
 */

public class QuestionSet implements IQuestionSet, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  // Variables
  private ArrayList<IQuestion> test;

  // NoArg Constructor
  public QuestionSet() {
    this.test = new ArrayList<>();
  }

  // Methods

  // clear the test and return an empty test set
  @Override
  public IQuestionSet emptyTestSet() {
    this.test.clear();
    return this;
  }

  // fetch a random sample of a QuestionSet
  @Override
  public IQuestionSet randomSample(int size) {
    // New question set
    IQuestionSet randomSample = new QuestionSet();

    Random rand = new Random();
    int random;

    // generate a random index, add to new random sample and remove from original. Removing ensures no repeats.
    for (int i = 0; i < size; i++) {
      random = rand.nextInt(this.size());
      randomSample.add(this.getQuestion(random));
      this.remove(random);
    }
    return randomSample;
  }

  // add a question
  @Override
  public boolean add(IQuestion question) {
    this.test.add(question);
    return true;
  }

  // remove a question
  @Override
  public boolean remove(int index) {
    this.test.remove(index);
    return true;
  }

  // get a question from the questionSet
  @Override
  public IQuestion getQuestion(int index) {
    return this.test.get(index);
  }

  // get the size of the Question set
  @Override
  public int size() {
    return test.size();
  }

  
}
