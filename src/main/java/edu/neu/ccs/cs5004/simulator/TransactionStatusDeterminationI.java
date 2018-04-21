package edu.neu.ccs.cs5004.simulator;

import edu.neu.ccs.cs5004.component.client.ClientId;
import edu.neu.ccs.cs5004.component.msgSig.MessageI;

public interface TransactionStatusDeterminationI {

  boolean verifyTransaction(MessageI msg, ClientId client);
}
