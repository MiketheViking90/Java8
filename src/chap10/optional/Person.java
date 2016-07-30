package chap10.optional;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {

    private Optional<Car> car;
    private Optional<String> name;

}
