
package gamesemproject.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Utils {
    
    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();
        try { //better than throws for each method that calls this method
            BufferedReader gi = new BufferedReader(new FileReader(path));
            String line;
            while ((line = gi.readLine()) != null){
                builder.append(line + " ");
            }
            gi.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }
}