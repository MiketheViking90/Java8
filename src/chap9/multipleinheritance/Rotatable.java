package chap9.multipleinheritance;

public interface Rotatable {

    void setRotationAngle(int angleInDegrees);

    int getRotationAngle();

    default void rotateBy(int angleInDegrees) {
        int rotationAngle = (getRotationAngle() + angleInDegrees) % 360;
        setRotationAngle(rotationAngle);
    }
}
