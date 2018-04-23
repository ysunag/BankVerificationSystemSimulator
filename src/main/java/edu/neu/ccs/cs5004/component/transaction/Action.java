package edu.neu.ccs.cs5004.component.transaction;

import edu.neu.ccs.cs5004.component.msgsignature.MessageI;

public interface Action {
  int DEPOSITBOUND = 4;
  static Action generateAction(MessageI msg) {
    int last = msg.getVal() % 10;
    if (last <= DEPOSITBOUND) {
      return Deposit.getInstance();
    } else {
      return Withdrawal.getInstance();
    }
  }
}
