package edu.neu.ccs.cs5004.component.msgsignature;


/**
 * Represents the transaction message.
 */
public class Message implements MessageI {
  private int val;

  /**
   * Creates a new message with the given value of the message.
   * @param val the given value of the message
   */
  public Message(int val) {
    this.val = val;
  }

  @Override
  public int getVal() {
    return val;
  }
}
