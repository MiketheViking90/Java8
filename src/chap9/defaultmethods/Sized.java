package chap9.defaultmethods;

public interface Sized {

    int getSize();

    default boolean isEmpty() {
        return getSize() == 0;
    }
}
