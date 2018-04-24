package edu.neu.ccs.cs5004.outputresult;

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
}
