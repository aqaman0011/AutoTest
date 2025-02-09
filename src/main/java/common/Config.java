package common;

public class Config {
    //public static final String PLATFORM_AND_BROWSER = "win_Chrome";
    public static final int IMPLICIT_WAIT = 5;
    // You can load for bash command mvn test -DplatformAndBrowser=mac_Chrome
    public static final String PLATFORM_AND_BROWSER = System.getProperty("platformAndBrowser", "win_Chrome");
}
