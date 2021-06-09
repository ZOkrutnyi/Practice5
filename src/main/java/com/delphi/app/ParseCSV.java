package main.java.com.delphi.app;

import java.io.FileWriter;
import java.io.IOException;

public class ParseCSV {
    public void parseToCSV(String str, String filename)
    {
        try(FileWriter fw = new FileWriter(filename,true))
        {
            fw.append(str).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseToCSV(String[] str, String filename)
    {
        for (String s: str) {
            try(FileWriter fw = new FileWriter(filename,true))
            {
                fw.append(s).append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

