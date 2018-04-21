package edu.neu.ccs.cs5004.outputResult;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CsvFileWriter implements FileWriterI {

  public void toWrite(FileName fileName, List<String> output) {
    try (BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(fileName.getName()), "UTF-8"))) {
      for (String line: output) {
        outputFile.write(line);
        outputFile.newLine();
      }
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}
