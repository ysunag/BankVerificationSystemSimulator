package edu.neu.ccs.cs5004.problem1.component.client;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.problem1.component.msgsignature.MessageI;

/**
 * Represents the process of generating digital signature.
 */
public interface RsaSigGeneratorI {

  /**
   * Generates the digital signature for the given message using the private key of the
   * given client.
   * @param currentClient the client whose private key is used for generating the digital signature
   * @param msg the given message to generate the given message for
   * @return the digital signature of the given message
   */
  DigiSigI generateSig(Client currentClient, MessageI msg);
}
