import java.util.EmptyStackException;
import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack {
    public class Node{
        public Job job;
        public volatile AtomicReference<Node> next;
        public Node(Job job){
            this.job = job;
            this.next = new AtomicReference<Node>(null);
        }
    }
    AtomicReference<Node> top = new AtomicReference<LockFreeStack.Node>(null);
    static final int MIN_DELAY = 10;
    static final int MAX_DELAY = 100;
    Backoff backoff = new Backoff(MIN_DELAY,MAX_DELAY);

    protected boolean tryPush(Node node){
        Node oldTop = top.get();
        node.next.set(oldTop);
        return(top.compareAndSet(oldTop, node));
    }
    public void enq(Job job){
        Node node = new Node(job);
        while(true){
            if(tryPush(node)){
                System.out.println("(IN)["+Thread.currentThread().getName()+"]"+job.toString());
                return;
            }else{
                backoff.backoff();
            }
        }
    }
    protected Node tryPop() throws EmptyStackException{
        Node oldTop = top.get();
        if(oldTop == null){
            throw new EmptyStackException();
        }
        Node newTop = oldTop.next.get();
        if(top.compareAndSet(oldTop, newTop)){
            return oldTop;
        }else{
            return null;
        }
    }
    public Job deq() throws EmptyStackException{
        while(true){
            Node returnNode = tryPop();
            if(returnNode != null){
                return returnNode.job;
            }else{
                backoff.backoff();
            }
        }
    }
}
