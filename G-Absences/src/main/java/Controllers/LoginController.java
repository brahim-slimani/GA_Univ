package Controllers;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@ManagedBean
public class LoginController implements Serializable {

    private String user;
    private String password;
    private String message;

    public String login(){
        if(user.equals("admin")&&password.equals("admin")){
            message = "";
            return "index";
        }else{
            message = "Utilisateur ou mot de passe érronné, veulliez réssayer ";
            user = "";
            password = "";
            return "login";
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
