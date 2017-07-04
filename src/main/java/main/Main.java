package main;

import accounts.AccountService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignUpServlet;
import servlets.SignInServlet;

/**
 * Created by Александр on 03.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();
        SignUpServlet s1 = new SignUpServlet(accountService);
        SignInServlet s2 = new SignInServlet(accountService);
        ServletContextHandler ser = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ser.addServlet(new ServletHolder(s1), "/signup");
        ser.addServlet(new ServletHolder(s2), "/signin");
        Server server = new Server(8080);
        server.setHandler(ser);
        System.out.println("Server started");
        server.start();
        server.join();
    }
}
