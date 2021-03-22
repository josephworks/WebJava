package net.josephworks;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws LifecycleException, URISyntaxException {
        String serverLocation = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getPath();
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        //TODO: Implement args override
        tomcat.setPort(8080);

        String contextPath = "";

        //TODO: Implement args override
        String warFilePath = serverLocation + "\\WebJava.war";

        System.out.println("WAR Location: " + warFilePath);

        tomcat.getHost().setAppBase(".");

        tomcat.addWebapp(contextPath, warFilePath);

        tomcat.start();
        tomcat.getServer().await();
    }
}