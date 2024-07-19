public class CDatabase{
    public volatile LockFreeStack JobQueue;
    public CDatabase(){
        JobQueue = new LockFreeStack();
    }
    public void AddJob(Job job){
        JobQueue.enq(job);
    }
    public Job GetJob(){
        return JobQueue.deq();
    }
   
}