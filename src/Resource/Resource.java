package Resource;

public abstract class Resource {
    
    
    public static String username = "niggo";
    public static String password = "niggo123";
    
    //
    // Benutzername und Passwort setzen
    //
    public static void setAuthData(String username, String password) {
        Resource.username = username;
        Resource.password = password;
    }
    

}
