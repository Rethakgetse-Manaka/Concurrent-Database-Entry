public class Main {
    public static void main(String[] args) {
        Thread[] developer = new Developer[2];
        Thread[] Admin = new Admin[1];
        CDatabase database = new CDatabase();
        for(int i=0;i<2;i++){
            developer[i] = new Developer(database);
            developer[i].start();
        }
        for(int i=0;i<1;i++){
            Admin[i] = new Admin(database);
            Admin[i].start();
        }
    }
}
