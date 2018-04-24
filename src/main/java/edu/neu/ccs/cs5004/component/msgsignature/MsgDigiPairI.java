package edu.neu.ccs.cs5004.component.msgsignature;

import edu.neu.ccs.cs5004.component.client.ClientId;

/**
 * Represents transaction message and digital signature pair.
 */
public interface MsgDigiPairI {

  /**
   * Getter for the message in the message and digital signature pair.
   * @return message in the message and digital signature pair
   */
  MessageI getMessage();

  /**
   * Getter for the digital signature in the message and digital signature pair.
   * @return digital signature in the message and digital signature pair
   */
  DigiSigI getSignature();

  /**
   * Getter for the client whom the message and digital signature pair belongs to.
   * @return the client ID of the client whom the message and digital signature pair belongs to
   */
  ClientId getClientId();

}
