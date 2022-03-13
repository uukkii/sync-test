package homeworks.multithreading.sync.task1;

import java.util.Arrays;
import java.util.List;

import static homeworks.multithreading.sync.task1.Producer.PRODUCTION_TIME;

public class Customer {
    protected static final List<String> COSTUMERS = Arrays.asList("Mark", "Mary", "John", "George", "Amy");
    private final Producer producer;
    protected final static int TIMEOUT = 100;

    public Customer(Producer producer) {
        this.producer = producer;
    }

    protected synchronized void orderCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " is producing new car...");
            Thread.sleep(PRODUCTION_TIME);
            producer.getStorage().add(new Car());
            System.out.println("Producer of " + Thread.currentThread().getName() + " built a new car!");
            notify();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    protected synchronized Car buyCar() {
        try {
            System.out.println("Customer " + Thread.currentThread().getName() + " came to the store.");
            Thread.sleep(TIMEOUT);
            while (producer.getStorage().size() == 0) {
                System.out.println("Sorry, " + Thread.currentThread().getName() + ", there are no cars!");
                wait();
            }
            Thread.sleep(TIMEOUT);
            System.out.println(Thread.currentThread().getName() + " has bought the car!");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return producer.getStorage().remove(0);
    }
}
