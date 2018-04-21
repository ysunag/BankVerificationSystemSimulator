package edu.neu.ccs.cs5004.simulator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.neu.ccs.cs5004.component.client.Client;
import edu.neu.ccs.cs5004.component.client.ClientI;
import edu.neu.ccs.cs5004.component.client.ClientId;

public class ClientIdGenerator implements ClientIdGeneratorI {

  public void generateClientId(List<ClientI> clients, int numOfClient) {
    Set<Integer> temp = new HashSet<>();
    Random rand = new Random();
    for(int i = 0; i < numOfClient; i++) {
      boolean valid = false;
      while(!valid) {
        int n = rand.nextInt(ClientI.IDBOUND) + 1;
        if(!temp.contains(n)) {
          temp.add(n);
          clients.add(new Client(new ClientId(n)));
          valid = true;
        }
      }

    }
  }
}
