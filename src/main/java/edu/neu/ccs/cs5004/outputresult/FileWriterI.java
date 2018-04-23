package edu.neu.ccs.cs5004.outputresult;


import java.util.List;

public interface FileWriterI {
  void toWrite(FileName fileName, List<String> output);


}
