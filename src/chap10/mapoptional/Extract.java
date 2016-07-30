package chap10.mapoptional;

import java.util.Optional;

import chap10.optional.Car;
import chap10.optional.Insurance;
import chap10.optional.Person;

public class Extract {

    Insurance insurance;
    Person person;

    void getName() {
        String name;
        if (insurance != null) {
            name = insurance.getName();
        }
    }

    void getNameMapping() {
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> optName = optInsurance.map(Insurance::getName);
    }

    void getCarInsuranceName() {
        person.getCar().get().getInsurance().get().getName();
    }

    void getCarInsuranceNameMap() {
        Optional<Person> optPerson = Optional.ofNullable(person);
        optPerson.map(Person::getCar).map(Optional::get).map(Car::getInsurance);
    }

    void getCarInsuranceNameFlatMap() {
        Optional<Person> optPerson = Optional.ofNullable(person);
        optPerson.flatMap(Person::getCar)
                 .flatMap(Car::getInsurance)
                 .map(Insurance::getName)
                 .orElse("Unknown");
    }

    void defaultOptionalBehaviors() throws Exception {
        Optional<Person> optPerson = Optional.ofNullable(person);
        person.getCar().get();
        person.getCar().orElse(new Car(null, null));
        person.getCar().orElseThrow(IllegalArgumentException::new);
        person.getCar().ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Insurance insurance = new Insurance("Geico");
        Car car = new Car("Honda", "Accord");
        car.setInsurance(Optional.ofNullable(insurance));

        Person person = new Person();
        //person.getCar().orElseGet(() -> new Car("Nissan", "Altima"));
        //person.getCar().orElseThrow(() -> new IllegalArgumentException("Fuck"));
        person.setName(Optional.ofNullable(null));
        String name = person.getName().orElse("Bill");
        person.setCar(Optional.ofNullable(null));
        Car car1 = person.getCar().orElseGet(() -> new Car("Nissan", "Altima"));
        System.out.println(name);
        System.out.println(car1);
    }

}
