package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Александр on 03.07.2017.
 */
public class SignUpServlet extends HttpServlet{
    private AccountService accountService;
    public SignUpServlet(AccountService a){
        accountService = a;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        accountService.addNewUser(login, password);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

