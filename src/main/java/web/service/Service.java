
package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Service {

    private final List<Car> cars;

    {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", 1, 1));
        cars.add(new Car("2", 2, 2));
        cars.add(new Car("3", 3, 3));
        cars.add(new Car("4", 4, 4));
        cars.add(new Car("5", 5, 5));
    }

    public Service(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> select(String count) {
        if (count == null) {
            return cars;
        } else {
            return cars.stream()
                    .limit(Integer.parseInt(count))
                    .collect(Collectors.toList());
        }
    }

}