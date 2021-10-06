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

    public List<String> readFromRepository() throws IOException {
        List<String> content = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader("repository.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            content.add(line);
        }

        return content;

    }

    public void writeToRepository(String key,int value) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String writeToFile = (key + ' ').repeat(value) + '#' + timestamp;
        BufferedWriter writer = new BufferedWriter(new FileWriter("repository.txt", true));
        writer.append(writeToFile);
        writer.append('\n');
    }

    public String formatAsHTML(List<String> content) {
        Collections.sort(content);

        String html = "<table><tr><th>Timestamp</th><th>Value</th></tr>";

        for(String line: content) {
            String[] columns = line.split("#");
            html = html.concat("<tr><td>" + columns[0] + "</td><td>"+ columns[1] +"</td></tr>");
        }
        return html;
    }

    public String formatAsJSON(List<String> content) {
        return null;
    }
}
