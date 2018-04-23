package edu.neu.ccs.cs5004.component.client;

import java.util.Objects;

public class ClientId {
  private int val;

  public ClientId(int thisid) {
    this.val = thisid;
  }

  public int getVal() {
    return val;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    ClientId clientId = (ClientId) other;
    return val == clientId.val;
  }

  @Override
  public int hashCode() {

    return Objects.hash(val);
  }
}
