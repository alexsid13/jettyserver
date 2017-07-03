package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.Servlet1;

import javax.servlet.Servlet;
import java.net.ContentHandler;

/**
 * Created by Александр on 03.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Servlet1 s = new Servlet1();
        ServletContextHandler ser = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ser.addServlet(new ServletHolder(s), "/mirror");
        Server server = new Server(8080);
        server.setHandler(ser);
        System.out.println("Server started");
        server.start();
        server.join();
    }
}
