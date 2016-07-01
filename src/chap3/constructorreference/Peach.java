package chap3.constructorreference;

public class Peach {

    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
