package chap10.composeoptional;

import java.util.Optional;

import chap10.optional.Car;
import chap10.optional.Insurance;
import chap10.optional.Person;

public class QueryInsurance {

    public Optional<Insurance> findCheapestInsurance_NullSafe(Optional<Person> person,
                                                              Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    private Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance("Geico");
    }

    public void filterInsurance(Insurance insurance) {
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        optInsurance.filter(ins -> "Geico".equals(ins.getName()));
    }
}
