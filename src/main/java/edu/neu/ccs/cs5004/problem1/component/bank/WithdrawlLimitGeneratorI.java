package edu.neu.ccs.cs5004.problem1.component.bank;

import edu.neu.ccs.cs5004.problem1.component.client.ClientId;


import java.util.Map;


/**
 * Represents the process of generating the withdrawal limits of the bank client.
 */
public interface WithdrawlLimitGeneratorI {
  int WITHDRAWLBOUND = 3000;

  /**
   * Generates the withdrawal limits for the clients.
   * @return a map with the client ID as the key and the withdrawal limit as the value.
   */
  Map<ClientId, Integer> generateWithdrawlLimits();
}
