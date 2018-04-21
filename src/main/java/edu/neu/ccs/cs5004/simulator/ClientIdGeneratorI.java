package edu.neu.ccs.cs5004.simulator;

import java.util.List;

import edu.neu.ccs.cs5004.component.client.Client;
import edu.neu.ccs.cs5004.component.client.ClientI;

public interface ClientIdGeneratorI {

  void generateClientId(List<ClientI> clients, int numOfClient);
}
