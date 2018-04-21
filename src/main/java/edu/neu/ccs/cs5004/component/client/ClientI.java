package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgSig.RsaKey;

public interface ClientI {
  int IDBOUND = 100000;

  ClientId getId();

  RsaKey getPublicKey();
}
