package edu.neu.ccs.cs5004.problem1.component.transaction;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.MessageI;

/**
 * Represents the action of the transaction.
 */
public interface Action {
  int DEPOSITBOUND = 4;

  /**
   * Generates a transaction action according to the given message.
   * @param msg the given message to generate the transaction action
   * @return a deposit action if the last digit of the message is less than or equal to the
   *        DEPOSITBOUND, a withdrawal action otherwise
   */
  static Action generateAction(MessageI msg) {
    int last = msg.getVal() % 10;
    if (last <= DEPOSITBOUND) {
      return Deposit.getInstance();
    } else {
      return Withdrawal.getInstance();
    }
  }
}
