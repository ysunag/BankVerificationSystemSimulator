package edu.neu.ccs.cs5004.simulator;

import java.util.List;

import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPairI;

public interface MsgSigGeneratorI {

  List<MsgDigiPairI> generateMsgSigPairs(int numOfVerification, double invalidMsgPercent);
}
