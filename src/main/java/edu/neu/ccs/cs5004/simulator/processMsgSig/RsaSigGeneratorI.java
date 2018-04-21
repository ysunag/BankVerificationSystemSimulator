package edu.neu.ccs.cs5004.simulator.processMsgSig;

import edu.neu.ccs.cs5004.component.client.ClientI;
import edu.neu.ccs.cs5004.component.msgSig.DigiSigI;
import edu.neu.ccs.cs5004.component.msgSig.MessageI;

public interface RsaSigGeneratorI {

  DigiSigI generateSig(ClientI currentClient, MessageI msg);
}
