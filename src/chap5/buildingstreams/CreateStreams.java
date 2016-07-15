package chap5.buildingstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStreams {

    private static String FILEPATH = System.getProperty("user.dir") + "/src/chap5/buildingstreams/data.txt";

    void streamFromValues() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase)
              .forEach(System.out::println);
    }

    void streamFromArrays() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int sum = Arrays.stream(numbers)
                        .reduce(Integer::sum)
                        .getAsInt();
        System.out.println(sum);
    }

    void streamFromFiles() throws IOException {
        System.out.println(FILEPATH);
        Stream<String> lines = Files.lines(Paths.get(FILEPATH));
        lines.flatMap(line -> Arrays.stream(line.split(" ")))
             .distinct()
             .forEach(System.out::println);
    }

    void streamFromIterate() {
        List<Integer> ints = Stream.iterate(2, n -> n + 2)
                                   .limit(15)
                                   .collect(Collectors.toList());
        System.out.println(ints);
    }

    void streamFibs() {
        Stream.iterate(new int[]{0, 1}, vals -> new int[]{vals[1], vals[0] + vals[1]})
              .limit(20)
              .forEach(vals -> System.out.println(vals[0] + ", " + vals[1]));
    }

    void streamGenerate() {
        Stream.generate(Math::random)
              .limit(20)
              .forEach(System.out::println);
    }

    public static void main(String[] args) {
        CreateStreams createStreams = new CreateStreams();
        createStreams.streamFromValues();
        createStreams.streamFromArrays();
        try {
            createStreams.streamFromFiles();
        } catch (IOException e) {
            System.out.println(e);
        }
        createStreams.streamFromIterate();
        createStreams.streamFibs();
        createStreams.streamGenerate();
    }
}
