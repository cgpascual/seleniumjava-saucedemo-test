package utils;

public class WaitUtils {

    public static void debugSleep(int seconds){

        if(Boolean.parseBoolean(ConfigReader.get("debugMode"))){
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}