package edu.neu.ccs.cs5004.problem1.simulator;

import edu.neu.ccs.cs5004.problem1.component.msgsignature.MsgDigiPairI;

import java.util.List;



/**
 * Represents the process of generating the message-digital signature pairs.
 */

public interface MsgSigGeneratorI {

  /**
   * Generates the given number of message-digital signature pairs with given invalid message
   * percentage.
   * @param numOfVerification the given number of message-digital signature pairs to generate
   * @param invalidMsgPercent the given invalid message percentage
   * @return the list of generated message-digital signature pairs
   */
  List<MsgDigiPairI> generateMsgSigPairs(int numOfVerification, double invalidMsgPercent);
}
