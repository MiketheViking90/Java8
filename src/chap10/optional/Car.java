package chap10.optional;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Car {

    private String make;
    private String model;
    @Setter
    private Optional<Insurance> insurance;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        insurance = Optional.empty();
    }

    public Car(String make, String model, Insurance insurance) {
        this.make = make;
        this.model = model;
        this.insurance = Optional.of(insurance);
    }
}
