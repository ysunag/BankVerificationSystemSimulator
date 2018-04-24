package edu.neu.ccs.cs5004.problem1.simulator;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.outputresult.FileName;

public class BankVerificationSimulatorTest {

  private BankVerificationSimulator test;

  @Before
  public void setUp() throws Exception {
    test = new BankVerificationSimulator(300, 50, 10,
            new FileName("test.csv"));
  }

  @Test
  public void setUpBankSystem() {
    test.setUpBankSystem();
  }

  @Test
  public void runVerificationSimulator() {
    test.setUpBankSystem();
    test.runVerificationSimulator();
  }
}