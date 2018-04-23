package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgSig.DigiSigI;
import edu.neu.ccs.cs5004.component.msgSig.MessageI;

public interface RsaSigGeneratorI {

  DigiSigI generateSig(Client currentClient, MessageI msg);
}
