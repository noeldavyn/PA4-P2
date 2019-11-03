package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;
import java.util.*;

   public class DuplicateCounter {
    private Map<String,Integer> wordCounter;

    public void count(String dataFile) throws FileNotFoundException
    {
        String word;
        wordCounter = new HashMap<String,Integer>();
        Scanner sc = new Scanner(new File(dataFile));

        while(sc.hasNext() )
        {
            word=sc.next();

            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            }

            else {
                wordCounter.put(word, 1);
            }
        }

        sc.close();
    }

    public void write(String outputFile) throws IOException
    {
        File f;
        FileWriter fw = null;

        f = new File(outputFile);

        if(!f.exists()) {
            f.createNewFile();
        }

        fw=new FileWriter(f);

        for (Map.Entry entry : wordCounter.entrySet()) {
            fw.write(entry.getKey() + " " + entry.getValue()+"\n");
        }

        fw.close();

        System.out.println("Done.");
    }
}




