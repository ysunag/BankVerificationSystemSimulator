package edu.neu.ccs.cs5004.simulator;

import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgsignature.MessageI;

/**
 * Represents the process of determining whether the transaction request amount is allowed.
 */
public interface TransactionStatusDeterminationI {

  /**
   * Verify the whether transaction is allowed with the given message and the client Id.
   * @param msg the given message to verify
   * @param client the given client ID
   * @return true if the message contains a deposit request within the deposit limit or a
   *        withdrawal request within the withdrawal limit, false otherwise.
   */
  boolean verifyTransaction(MessageI msg, ClientId client);
}
