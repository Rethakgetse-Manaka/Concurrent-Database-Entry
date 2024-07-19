public class Job {
    int ManHours;
    volatile boolean ApprovalStatus = false;
    volatile int jobNumber;
    public Job(int jobNumber,int hours){
        this.jobNumber = jobNumber;
        this.ManHours = hours;
    }
    public void setApprovalStatus(boolean status){
        this.ApprovalStatus = status;
    }
    public boolean getApprovalStatus(){
        return this.ApprovalStatus;
    }
    public int getManHours(){
        return this.ManHours;
    }
    public int getJobNumber(){
        return this.jobNumber;
    }
    public String toString(){
        return "["+this.getJobNumber()+"]" + "["+this.getManHours()+"]";
    }
    public String ShowJob(){
        return "["+this.getJobNumber()+"]" + "["+this.getManHours()+"]" + "["+this.getApprovalStatus()+"]";
    }
}
