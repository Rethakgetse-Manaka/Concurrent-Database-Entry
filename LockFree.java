import java.util.concurrent.atomic.AtomicReference;

import java.util.EmptyStackException;
public class LockFree{
    public class Node{
        Job job;
        volatile AtomicReference<Node> next;
        public Node(Job job){
            this.job = job;
            this.next = new AtomicReference<Node>(null);
        }
    }
    volatile Node head, tail;
    public LockFree(){
        head = new Node(new Job(-1, 0));
        tail = head;
    }
    public void enq(Job job){
        Node newNode = new Node(job);
        while(true){
            Node last = tail;
            Node next = last.next.get();
            if(last == tail){
                if(next == null){
                    if(last.next.compareAndSet(next, newNode)){
                        System.out.println("(IN)["+Thread.currentThread().getName()+"]"+job.toString());
                        tail = newNode;
                        return;
                    }
                }else{
                    tail = next;
                }
            }
        }
    }
    public  Job deq() throws EmptyStackException {
        while(true){
            Node first = head;
            Node last = tail;
            Node next = first.next.get();
            if(first == head){
                if(first == last){
                    if(next == null){
                        throw new EmptyStackException();
                    }
                    tail = next;
                }else{
                    if(next == null){
                        throw new EmptyStackException();
                    }
                    Job job = next.job;
                    if(first.next.compareAndSet(next, next.next.get())){
                        return job;
                    }
                }
            }
        }
    }
    
}
