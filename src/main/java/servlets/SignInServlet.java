package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Александр on 04.07.2017.
 */
public class SignInServlet extends HttpServlet {
    private AccountService accountService;
    public SignInServlet(AccountService a){
        accountService = a;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(accountService.getUser(login, password)){
            response.getWriter().print("Authorized: " + login);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
