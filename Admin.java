import java.util.EmptyStackException;

public class Admin extends Thread{
    public volatile CDatabase database;
    public Admin(CDatabase database){
        this.database = database;
    }
    
    public void run(){
        int i = 0;
        while(i<3){
            
            try{
                try{
                    Thread.sleep(7);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                Job job = database.GetJob();
                if(job != null){
                    boolean randomApproval = Math.random() < 0.5;
                    job.setApprovalStatus(randomApproval);
                    System.out.println("(OUT)["+Thread.currentThread().getName()+"]"+ job.ShowJob());
                }
            }catch(EmptyStackException e){
                System.out.println("No more jobs to process");
                i++;
            }
        }
    }
}
