package edu.neu.ccs.cs5004.problem1.component.client;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Represents the process of generating unique client ID.
 */
public class ClientIdGenerator implements ClientIdGeneratorI {

  @Override
  public void generateClientId(List<Client> clients, int numOfClient) {
    Set<Integer> temp = new HashSet<>();
    Random rand = new Random();
    for (int i = 0; i < numOfClient; i++) {
      boolean valid = false;
      while (!valid) {
        int num = rand.nextInt(Client.IDBOUND) + 1;
        if (!temp.contains(num)) {
          temp.add(num);
          clients.add(new Client(new ClientId(num)));
          valid = true;
        }
      }

    }
  }
}
