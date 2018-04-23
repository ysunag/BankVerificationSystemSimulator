package edu.neu.ccs.cs5004.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.ccs.cs5004.component.client.Client;
import edu.neu.ccs.cs5004.component.transaction.Action;
import edu.neu.ccs.cs5004.component.bank.Bank;
import edu.neu.ccs.cs5004.commandLineArgument.ArgumentParser;
import edu.neu.ccs.cs5004.component.msgSig.MsgDigiPairI;
import edu.neu.ccs.cs5004.component.transaction.TransactionStatusI;
import edu.neu.ccs.cs5004.outputResult.CsvFileWriter;
import edu.neu.ccs.cs5004.outputResult.FileName;
import edu.neu.ccs.cs5004.outputResult.FileWriterI;
import edu.neu.ccs.cs5004.component.client.ClientIdGenerator;
import edu.neu.ccs.cs5004.component.client.ClientIdGeneratorI;
import edu.neu.ccs.cs5004.component.bank.DepositLimitGenerator;
import edu.neu.ccs.cs5004.component.bank.DepositLimitGeneratorI;
import edu.neu.ccs.cs5004.component.bank.WithdrawlLimitGenerator;
import edu.neu.ccs.cs5004.component.bank.WithdrawlLimitGeneratorI;
import edu.neu.ccs.cs5004.component.client.RsaKeyGenerator;
import edu.neu.ccs.cs5004.component.client.RsaKeyGeneratorI;
import edu.neu.ccs.cs5004.component.bank.RsaSigVerification;
import edu.neu.ccs.cs5004.component.bank.RsaSigVerificationI;

public class BankVerificationSimulator implements BankVerificationSimulatorI {
  public static final String YES = "yes";
  public static final String NO = "no";
  public static final String HEADER = "Transaction number-Date,Time,Client ID,Message," +
          "Digital signature,Verified,Transaction status";
  private Bank bank;
  private List<Client> clients;
  private List<MsgDigiPairI> pairsToVerify;
  private int numOfClient;
  private int numOfVerification;
  private double invalidMsgPercent;
  private FileName outputFile;

  public BankVerificationSimulator(int numOfClient, int numOfVerification, double invalidMsgPercent,
                                   FileName outputFile) {
    this.numOfClient = numOfClient;
    this.numOfVerification = numOfVerification;
    this.invalidMsgPercent = invalidMsgPercent;
    this.outputFile = outputFile;
    bank = new Bank();
    clients = new ArrayList<>();
  }

  public void setUpBankSystem() {
    ClientIdGeneratorI clientGenerator = new ClientIdGenerator();
    clientGenerator.generateClientId(clients, numOfClient);
    RsaKeyGeneratorI keyGenerator= new RsaKeyGenerator();
    for(Client currentClient: clients) {
      keyGenerator.generateKey(currentClient);
      bank.addPublicKey(currentClient.getId(), currentClient.getPublicKey());
    }
    MsgSigGeneratorI msgSigGenerator = new MsgSigGenerator(clients, numOfClient);
    pairsToVerify = msgSigGenerator.generateMsgSigPairs(numOfVerification, invalidMsgPercent);
    DepositLimitGeneratorI depLimitGenerator = new DepositLimitGenerator(clients);
    bank.setDepositLimits(depLimitGenerator.generateDepositLimits());
    WithdrawlLimitGeneratorI wdLimitGenerator = new WithdrawlLimitGenerator(clients);
    bank.setWithdrawlLimits(wdLimitGenerator.generateWithdrawlLimits());
  }


  public void runVerificationSimulator() {
    RsaSigVerificationI sigVerification = new RsaSigVerification();
    TransactionStatusDeterminationI transacStatDeterminator = new TransactionStatusDetermination(bank);
    StringBuilder sb;
    String seperator = ",";
    int transactionNum = 1;
    List<String> output = new ArrayList<>();
    output.add(HEADER);
    for(MsgDigiPairI pair: pairsToVerify) {
      sb = new StringBuilder();
      sb.append(transactionNum);
      DateFormat dateFormat = new SimpleDateFormat("-yyyy/MM/dd,HH:mm:ss");
      Date date = new Date();
      sb.append(dateFormat.format(date));
      sb.append(seperator);
      sb.append(pair.getClientId().getVal());
      sb.append(seperator);
      sb.append(pair.getMessage().getVal());
      sb.append(seperator);
      sb.append(pair.getSignature().getVal());
      sb.append(seperator);
      boolean sigVerified = sigVerification.verifyMsg(bank, pair);
      sb.append(sigVerified? YES: NO);
      sb.append(seperator);
      Action currentAction = Action.generateAction(pair.getMessage());
      boolean validTransaction = transacStatDeterminator.verifyTransaction(pair.getMessage(),
              pair.getClientId());
      TransactionStatusI transactStatus = TransactionStatusI.
              generateTransactionStatus(currentAction, sigVerified && validTransaction);
      sb.append(transactStatus.toString());
      transactionNum += 1;
      output.add(sb.toString());
    }
    FileWriterI writer = new CsvFileWriter();
    writer.toWrite(outputFile, output);
  }

  public static void main(String[] args) {
    ArgumentParser parser = new ArgumentParser(args);
    parser.checkArgument();
    BankVerificationSimulatorI newSimulator  = new BankVerificationSimulator(
            parser.getClientNum(), parser.getVerificationNum(), parser.getInvalidMsgPercentage(),
            parser.getOutputFile());
    newSimulator.setUpBankSystem();
    newSimulator.runVerificationSimulator();
  }
}
