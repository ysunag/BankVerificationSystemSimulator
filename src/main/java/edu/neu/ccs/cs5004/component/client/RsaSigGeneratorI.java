package edu.neu.ccs.cs5004.component.client;

import edu.neu.ccs.cs5004.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.component.msgsignature.MessageI;

public interface RsaSigGeneratorI {

  DigiSigI generateSig(Client currentClient, MessageI msg);
}
