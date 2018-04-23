package edu.neu.ccs.cs5004.component.msgsignature;

public class Message implements MessageI {
  private int val;

  public Message(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}
