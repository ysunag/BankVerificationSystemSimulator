package edu.neu.ccs.cs5004.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.neu.ccs.cs5004.component.client.ClientI;
import edu.neu.ccs.cs5004.component.client.ClientId;

public class DepositLimitGenerator implements DepositLimitGeneratorI{
  private List<ClientI> clients;

  public DepositLimitGenerator(List<ClientI> clients) {
    this.clients = clients;
  }

  public Map<ClientId, Integer> generateDepositLimits() {
    Map<ClientId, Integer> result = new HashMap<>();
    for(ClientI currentClient: clients) {
      Random rand = new Random();
      int current = rand.nextInt(DepositLimitGeneratorI.DEPOSITBOUND + 1);
      result.put(currentClient.getId(), current);
    }
    return result;
  }
}
