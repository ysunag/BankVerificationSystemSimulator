package edu.neu.ccs.cs5004.simulator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import edu.neu.ccs.cs5004.component.client.Client;
import edu.neu.ccs.cs5004.component.msgsignature.DigiSig;
import edu.neu.ccs.cs5004.component.msgsignature.DigiSigI;
import edu.neu.ccs.cs5004.component.msgsignature.Message;
import edu.neu.ccs.cs5004.component.msgsignature.MessageI;
import edu.neu.ccs.cs5004.component.msgsignature.MsgDigiPairI;
import edu.neu.ccs.cs5004.component.msgsignature.MsgDigiPair;

import edu.neu.ccs.cs5004.component.client.RsaSigGenerator;
import edu.neu.ccs.cs5004.component.client.RsaSigGeneratorI;

public class MsgSigGenerator implements MsgSigGeneratorI {
  private List<Client> clients;
  private int numberOfClients;

  public MsgSigGenerator(List<Client> clients, int numberOfClients) {
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
    Client currentClient;
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
