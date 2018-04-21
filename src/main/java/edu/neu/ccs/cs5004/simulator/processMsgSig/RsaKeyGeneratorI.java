package edu.neu.ccs.cs5004.simulator.processMsgSig;

import edu.neu.ccs.cs5004.component.client.ClientI;

public interface RsaKeyGeneratorI {
  void generateKey(ClientI currentClient);
}
