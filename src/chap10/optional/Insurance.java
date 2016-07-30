package chap10.optional;

import lombok.Getter;

public class Insurance {

    @Getter
    private String name;

    public Insurance(String name) {
        this.name = name;
    }

}
