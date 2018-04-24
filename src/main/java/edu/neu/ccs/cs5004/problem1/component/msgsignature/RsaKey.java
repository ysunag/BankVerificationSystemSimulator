package edu.neu.ccs.cs5004.problem1.component.msgsignature;

/**
 * Represents the RSA key with a pair of integers.
 */
public class RsaKey {
  private int first;
  private int second;

  /**
   * Creates an RSA key with two integers.
   * @param first the first value of the key
   * @param second the second value of the key
   */
  public RsaKey(int first, int second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Getter for the property 'First'.
   * @return Value for the property 'First'
   */
  public int getFirst() {
    return first;
  }

  /**
   * Getter for the property 'Second'.
   * @return Value for the property 'Second'
   */
  public int getSecond() {
    return second;
  }
}
