// https://www.geeksforgeeks.org/facade-design-pattern-introduction/

class ScheduleServer {

    public void startBooting(){
        System.out.println("Starts booting...");
    }

    public void readSystemConfigFile(){
        System.out.println("Reading system config files...");
    }

    public void init(){
        System.out.println("Initializing...");
    }

    public void initializeContext(){
        System.out.println("Initializing context...");
    }

    public void initializeListeners(){
        System.out.println("Initializing listeners...");
    }

    public void createSystemObjects(){
        System.out.println("Creating system objects...");
    }

    public void releaseProcesses(){
        System.out.println("Releasing processes...");
    }

    public void destory(){
        System.out.println("Destorying...");
    }

    public void destroySystemObjects(){
        System.out.println("Destroying system objects...");
    }

    public void destoryListeners(){
        System.out.println("Destroying listeners...");
    }

    public void destoryContext(){
        System.out.println("Destroying context...");
    }

    public void shutdown(){
        System.out.println("Shutting down...");
    }
}

class ScheduleServerFacade {
    private final ScheduleServer scheduleServer;
    public ScheduleServerFacade(ScheduleServer scheduleServer){
        this.scheduleServer = scheduleServer;
    }
    public void startServer(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }
    public void stopServer(){
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}

public class FacadePattern {


    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade facadeServer = new ScheduleServerFacade(scheduleServer);
        facadeServer.startServer();


        System.out.println("Start working......");
        System.out.println("After work done.........");
        facadeServer.stopServer();


    }



}
