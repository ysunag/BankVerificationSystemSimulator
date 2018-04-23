package edu.neu.ccs.cs5004.component.msgSig;

import java.math.BigInteger;

public class RsaKey {
  private BigInteger first;
  private BigInteger second;

  public RsaKey(BigInteger first, BigInteger second) {
    this.first = first;
    this.second = second;
  }

  public BigInteger getFirst() {
    return first;
  }

  public BigInteger getSecond() {
    return second;
  }
}
