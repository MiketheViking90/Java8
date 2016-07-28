package chap9.multipleinheritance;

public interface Moveable {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    default void moveHorizontally(int dist) {
        int x = getX() + dist;
        setX(x);
    }

    default void moveVertically(int dist) {
        int y = getY() + dist;
        setY(y);
    }

}
