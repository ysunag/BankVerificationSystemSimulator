package edu.neu.ccs.cs5004.problem1.component.msgsignature;

/**
 * Represents the digital signature.
 */
public class DigiSig implements DigiSigI{
  private int val;

  /**
   * Generates a new digital signature with the given digital signature value.
   * @param val the given digital signature value
   */
  public DigiSig(int val) {
    this.val = val;
  }

  @Override
  public int getVal() {
    return val;
  }
}
