
class mycar1 implements Runnable{
    @Override
     public void run()
    {
        try {
            System.out.println(Thread.currentThread().getName()+" has entered in parking lot");
            Thread.sleep(2000);
            synchronized(this){
                System.out.println(Thread.currentThread().getName()+" has started the car");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" has come back in parking lot");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class Car {
    public static void main(String[] args) {
        // code here
        mycar1 m=new mycar1();

        Thread t1=new Thread(m);
        Thread t2=new Thread(m);
        Thread t3=new Thread(m);

        t1.setName("Modi ji");
        t2.setName("Rahul Gandhi");
        t3.setName("Amit shah");

        t1.start();
        t2.start();
        t3.start();


    }
}