class Producer extends Thread{
    Queue q;
    public Producer(Queue q)
    {
        this.q=q;
    }

    public void run()
    {
        int i=1;

        while(true)
        {
            q.produce(i++);
        }
    }
}

class Consumer extends Thread{
    Queue q;
    public Consumer(Queue q)
    {
        this.q=q;
    }

    public void run()
    {
        int i=1;

        while(true)
        {
            q.consume();
        }
    }
}

class Queue
{
    int data;
    boolean flag=false;
    synchronized public void produce(int i){
        try {
            if(flag){
                System.out.println("Producer in waiting state");
                wait();
            }else {
                data=i;
                System.out.println("I have produced data "+ data);
                flag=true;
                notify();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    synchronized public  void consume(){

    try {
        if(!flag){
            System.out.println("consumer in waiting state");
            wait();
        }else {
            System.out.println("I have consumed data "+ data);
            flag=false;
            notify();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}

public class intercommunicatin_betn_threads {
    public static void main(String[] args)
    {
        Queue q=new Queue();

        Producer p=new Producer(q);
        Consumer c=new Consumer(q);

        p.start();
        c.start();
    }
}
