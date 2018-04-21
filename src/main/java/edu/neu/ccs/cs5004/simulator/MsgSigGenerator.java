package edu.neu.ccs.cs5004.simulator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import edu.neu.ccs.cs5004.component.client.ClientI;
import edu.neu.ccs.cs5004.component.msgSig.DigiSig;
import edu.neu.ccs.cs5004.component.msgSig.DigiSigI;
import edu.neu.ccs.cs5004.component.msgSig.Message;
import edu.neu.ccs.cs5004.component.msgSig.MessageI;
import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPairI;
import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPair;

import edu.neu.ccs.cs5004.simulator.processMsgSig.RsaSigGenerator;
import edu.neu.ccs.cs5004.simulator.processMsgSig.RsaSigGeneratorI;

public class MsgSigGenerator implements MsgSigGeneratorI {
  private List<ClientI> clients;
  private int numberOfClients;

  public MsgSigGenerator(List<ClientI> clients, int numberOfClients) {
    this.clients = clients;
    this.numberOfClients = numberOfClients;
  }

  public List<MsgDigiPairI> generateMsgSigPairs(int numOfVerification, double invalidMsgPercent) {
    Double temp = numOfVerification * invalidMsgPercent / 100;
    int allowedInvalidMsgNum = temp.intValue();
    int currentInvalidNum = 0;
    List<MsgDigiPairI> pairs = new LinkedList<>();

    RsaSigGeneratorI sigGenerator = new RsaSigGenerator();
    Random rand = new Random();
    MessageI msg;
    DigiSigI signature;
    ClientI currentClient;
    for(int i = 0; i < numOfVerification; i++) {
      int clientNum = rand.nextInt(numberOfClients);
      currentClient = clients.get(clientNum);
      msg = new Message(rand.nextInt(MessageI.MESSAGEBOUND) + 1);
      int validOrNot = rand.nextInt(2);
      if(validOrNot == 0 && currentInvalidNum < allowedInvalidMsgNum) {
        signature = new DigiSig(rand.nextInt(DigiSigI.DIGISIGRANDOMBOUND) + 1);
        currentInvalidNum += 1;
      } else {
        signature = sigGenerator.generateSig(currentClient, msg);
      }
      MsgDigiPairI currentPair = new MsgDigiPair(msg, signature, currentClient.getId());
      pairs.add(currentPair);
    }
    return pairs;
  }
}
