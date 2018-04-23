package edu.neu.ccs.cs5004.component.client;

import java.util.List;


public interface ClientIdGeneratorI {

  void generateClientId(List<Client> clients, int numOfClient);
}
