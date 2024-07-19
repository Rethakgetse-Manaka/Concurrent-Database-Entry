public class Backoff {
    int MIN_DELAY;
    int MAX_DELAY;
    Backoff(int min,int max){
        this.MIN_DELAY = min;
        this.MAX_DELAY = max;
    }
    public void backoff(){
        int delay = MIN_DELAY;
        int limit = MAX_DELAY;
        int delayTime = (int)(Math.random() * (limit - delay + 1)+delay);
        try{
            Thread.sleep(delayTime);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
