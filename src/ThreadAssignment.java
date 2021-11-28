public class ThreadAssignment {

    static class Counter {
       public static int counter = 0;
      public static synchronized  void count() {
            counter++;
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.count();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        new MyThread(counter).start();
        new MyThread(counter).start();
    }
}
