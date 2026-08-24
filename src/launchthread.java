
class library implements Runnable
{
    String res1="Java";
    String res2="DSA_BOOK";
    String res3="Spring_Boot";

    @Override
    public void run()
    {
        String name=Thread.currentThread().getName();

        if(name.equals("A")) {
            try {

                Thread.sleep(3000);

                synchronized (res1) {
                    System.out.println("Student A has aquired " + res1);
                    Thread.sleep(3000);
                    synchronized (res2) {
                        System.out.println("Student A has aquired " + res2);
                        Thread.sleep(3000);
                        synchronized (res3) {
                            System.out.println("Student A has aquired " + res3);
                            Thread.sleep(3000);
                        }
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
            else
            {
                try {

                    Thread.sleep(3000);

                    synchronized (res1){
                        System.out.println("Student B has aquired " + res1);
                        Thread.sleep(3000);
                        synchronized (res2){
                            System.out.println("Student B has aquired " + res2);
                            Thread.sleep(3000);
                            synchronized (res3){
                                System.out.println("Student B has aquired " + res3);
                                Thread.sleep(3000);
                            }
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

    }
}


public class launchthread {
    public static void main(String[] args)
    {
        library lab=new library();

        Thread t1=new Thread(lab);
        Thread t2=new Thread(lab);

        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
