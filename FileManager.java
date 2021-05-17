import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    BufferedReader br;
    File file;

    public FileManager (String filename) {
        file = new File(filename);
    }
    
    public ArrayList<String[]> stringList (String split) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            br = new BufferedReader(
                new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                String[] words = s.split(split);
                list.add(words);
            }
            br.close();
            return list;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}
