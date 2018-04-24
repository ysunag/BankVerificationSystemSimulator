package edu.neu.ccs.cs5004.problem1.component.bank;


import edu.neu.ccs.cs5004.problem1.component.client.Client;
import edu.neu.ccs.cs5004.problem1.component.client.ClientId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents the process of generating the deposit limits of the bank client.
 */
public class DepositLimitGenerator implements DepositLimitGeneratorI{
  private List<Client> clients;

  /**
   * Creates a new deposit limit generator with the given clients to be generate the deposit
   * limit for.
   * @param clients the given clients to be generate the deposit limit for
   */
  public DepositLimitGenerator(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public Map<ClientId, Integer> generateDepositLimits() {
    Map<ClientId, Integer> result = new HashMap<>();
    for (Client currentClient: clients) {
      Random rand = new Random();
      int current = rand.nextInt(DepositLimitGeneratorI.DEPOSITBOUND + 1);
      result.put(currentClient.getId(), current);
    }
    return result;
  }
}
