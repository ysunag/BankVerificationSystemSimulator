package edu.neu.ccs.cs5004.component.client;

import java.util.Objects;

/**
 * Represents the client ID.
 */
public class ClientId {
  private int val;

  /**
   * Constructs a client ID with the given ID value.
   * @param thisid the given ID value
   */
  public ClientId(int thisid) {
    this.val = thisid;
  }

  /**
   * Getter for the ID value.
   * @return the value of the client ID.
   */
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
