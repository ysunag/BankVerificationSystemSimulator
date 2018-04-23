package edu.neu.ccs.cs5004.component.msgsignature;

public class DigiSig implements DigiSigI{
  private int val;

  public DigiSig(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}
