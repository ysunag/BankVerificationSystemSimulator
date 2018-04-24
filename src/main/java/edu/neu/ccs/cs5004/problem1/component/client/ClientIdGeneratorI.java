package edu.neu.ccs.cs5004.problem1.component.client;

import java.util.List;

/**
 * Represents the process of generating unique client ID.
 */
public interface ClientIdGeneratorI {

  /**
   * Generates the client ID for the given number of clients.
   * @param clients the list to store the clients with the newly generated IDs.
   * @param numOfClient the given number of clients to generate the ID for.
   */
  void generateClientId(List<Client> clients, int numOfClient);
}
