package practice;

/**
 * notify和wait实现生产消费
 */
public class ProducerConsumer {
    private final Object lock = new Object();
    private boolean hasProduct = false;
    private String product;

    // 生产者方法
    public void produce(String item) {
        synchronized (lock) {
            while (hasProduct) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product = item;
            hasProduct = true;
            System.out.println("Produced: " + item);
            lock.notify();
        }
    }

    // 消费者方法
    public String consume() {
        synchronized (lock) {
            while (!hasProduct) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String consumedProduct = product;
            hasProduct = false;
            System.out.println("Consumed: " + consumedProduct);
            lock.notify();
            return consumedProduct;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        // 生产者线程
        new Thread(() -> {
            pc.produce("Apple");
            pc.produce("Banana");
            pc.produce("Orange");
        }).start();

        // 消费者线程
        new Thread(() -> {
            System.out.println("Consumed: " + pc.consume());
            System.out.println("Consumed: " + pc.consume());
            System.out.println("Consumed: " + pc.consume());
        }).start();
    }
}
