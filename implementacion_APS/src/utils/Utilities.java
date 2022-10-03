package utils;

public class Utilities {
    

    public static boolean isFieldInteger(String legajo){
        try{
            Integer.parseInt(legajo);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
