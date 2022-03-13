package homeworks.multithreading.sync.task1;

import static homeworks.multithreading.sync.task1.Customer.COSTUMERS;
import static homeworks.multithreading.sync.task1.Producer.AUTOMOBILE;

public class Application {
    private static final Producer producer = new Producer();

    public static void main(String[] args) {

        for (String name : COSTUMERS) {
            new Thread(null, producer::sellCar, name).start();
        }

        new Thread(null, producer::produceCar, AUTOMOBILE).start();

//        for (int i = 0; i < COSTUMERS.size(); i++) {
//            new Thread(null, producer::produceCar, AUTOMOBILE).start();
//        }
    }
}
