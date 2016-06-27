package chap2.executearound;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    private static final String PWD = System.getProperty("user.dir") + "/src/chap2/data/";
    private static final String FILENAME = "data.txt";


    public String process(BufferedReaderProcessor processor)
            throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(PWD + FILENAME))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileProcessor fp = new FileProcessor();
        String result = fp.process((BufferedReader br) ->
                    (br.readLine() + br.readLine()));
        System.out.println(result);

        result = fp.process(
                (BufferedReader br) -> ("haha"));
        System.out.println(result);
    }
}
