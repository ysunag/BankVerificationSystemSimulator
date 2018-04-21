package edu.neu.ccs.cs5004.outputResult;


import java.util.List;

public interface FileWriterI {
  void toWrite(FileName fileName, List<String> output);


}
