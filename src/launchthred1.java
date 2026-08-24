
public class launchthred1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started");

        Thread t=Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());

        Thread.sleep(5000);

        t.setName("NewThread");
        t.setPriority(10);
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println("Application ended");
    }
}
