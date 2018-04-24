package edu.neu.ccs.cs5004.problem1.outputresult;

import java.util.Objects;

/**
 * Represents the file name.
 */
public class FileName {
  private String name;

  /**
   * Creates a new file name with the given name.
   * @param name the given name
   */
  public FileName(String name) {
    this.name = name;
  }

  /**
   * Getter for the name of the file name.
   * @return the name of the file name
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    FileName fileName = (FileName) other;
    return Objects.equals(getName(), fileName.getName());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getName());
  }
}
