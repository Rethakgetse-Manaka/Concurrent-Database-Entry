public class Developer extends Thread {
    public volatile CDatabase database;
    public Developer(CDatabase database){
        this.database = database;
    }
    public void run(){
        for(int i=0;i<3;i++){
            Job job = new Job(i+1,(int)(Math.random() * (24 - 1 + 1)+1));
            database.AddJob(job);
        }
    }
}
