package edu.neu.ccs.cs5004.outputresult;


import java.util.List;

/**
 * Represents a file writer.
 */
public interface FileWriterI {

  /**
   * Writes the output into a file with the given file name.
   * @param fileName the given file name
   * @param output the output to write
   */
  void toWrite(FileName fileName, List<String> output);


}
