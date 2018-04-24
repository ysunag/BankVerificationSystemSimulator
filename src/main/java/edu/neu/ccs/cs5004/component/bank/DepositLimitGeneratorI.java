package edu.neu.ccs.cs5004.component.bank;

import edu.neu.ccs.cs5004.component.client.ClientId;

import java.util.Map;



/**
 * Represents the process of generating the deposit limits of the bank client.
 */
public interface DepositLimitGeneratorI {
  int DEPOSITBOUND = 2000;

  /**
   * Generates the deposit limits for the clients.
   * @return a map with the client ID as the key and the deposit limit as the value.
   */
  Map<ClientId, Integer> generateDepositLimits();
}
