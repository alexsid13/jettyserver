package accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Александр on 04.07.2017.
 */
public class AccountService {
    private Map<String, String> loginpass;
    public AccountService(){
        loginpass = new HashMap<String, String>();
    }
    public void addNewUser(String log, String pas){
        loginpass.put(log,pas);
    }
    public boolean getUser(String log, String pas){
        if(loginpass.containsKey(log))
            return true;
        else
            return false;
    }
}
