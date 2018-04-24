package edu.neu.ccs.cs5004.component.msgsignature;

/**
 * Represents the digital signature.
 */
public interface DigiSigI {
  int DIGISIGRANDOMBOUND = 10000;

  /**
   * Getter for the value of the digital signature.
   * @return the value of the digital signature
   */
  int getVal();
}
