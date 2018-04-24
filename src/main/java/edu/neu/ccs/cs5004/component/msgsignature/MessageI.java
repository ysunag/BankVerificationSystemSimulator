package edu.neu.ccs.cs5004.component.msgsignature;

/**
 * Represents the transaction message.
 */
public interface MessageI {
  int MESSAGEBOUND = 30000;

  /**
   * Getter for the value of the transaction message.
   * @return the value of the transaction message
   */
  int getVal();
}
