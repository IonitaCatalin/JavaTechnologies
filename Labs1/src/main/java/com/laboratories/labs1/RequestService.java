package com.laboratories.labs1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RequestService {

    public RequestService() {
    }

    public List<String> readFromRepository() {
        List<String> content = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("repository.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }

    public boolean writeToRepository(String key,int value)  {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String writeToFile = (key + ' ').repeat(value) + '#' + timestamp;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("repository.txt", true));
            writer.append(writeToFile);
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String formatAsHTML(List<String> content) {
        Collections.sort(content);

        String html = "<table style=\" border: 1px solid black;\"><tr><th>Timestamp</th><th>Value</th></tr>";

        for(String line: content) {
            String[] columns = line.split("#");
            html = html.concat("<tr><td>" + columns[1] + "</td><td>"+ columns[0] +"</td></tr>");
        }
        return html;
    }

    public String formatAsCSV(List<String> content) {
        Collections.sort(content);

        String csv = "";

        for(String line:content) {
            String[] columns = line.split("#");
            csv = csv.concat(columns[1] + "," +columns[0] + "\n");
        }

        return csv;
    }
}
