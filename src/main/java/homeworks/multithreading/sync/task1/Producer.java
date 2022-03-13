package homeworks.multithreading.sync.task1;

import java.util.ArrayList;
import java.util.List;

import static homeworks.multithreading.sync.task1.Customer.COSTUMERS;

public class Producer {
    protected static final int PRODUCTION_TIME = 500;
    protected static final String AUTOMOBILE = "Toyota";
    protected int numberOfCars;
    protected boolean doneCheck = false;
    protected List<Car> storage = new ArrayList<>();

    Customer customer = new Customer(this);


    protected void sellCar() {
        customer.buyCar();
    }

   protected void produceCar() {
        while (!doneCheck) {
            customer.orderCar();
            numberOfCars++;
            isDone();
        }
    }

    protected List<Car> getStorage() {
        return storage;
    }

    private void isDone() {
        if (numberOfCars == COSTUMERS.size()) {
            doneCheck = true;
        }
    }
}
