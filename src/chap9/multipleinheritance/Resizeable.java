package chap9.multipleinheritance;

public interface Resizeable {

    int getWidth();

    int getHeight();

    void setWidth(int w);

    void setHeight(int h);

    void setAbsoluteSize(int w, int h);

    default void setRelativeSize(int wFactor, int hFactor) {
        int wScale = getWidth() / wFactor;
        int hScale = getHeight() / hFactor;

        setAbsoluteSize(wScale, hScale);
    }
}
