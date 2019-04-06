package Resource;

public abstract class Resource {
    
    
    public static String username = "tim123";
    public static String password = "123456";
    
    //
    // Benutzername und Passwort setzen
    //
    public static void setAuthData(String username, String password) {
        Resource.username = username;
        Resource.password = password;
    }
    

}
