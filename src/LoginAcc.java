import java.util.ArrayList;


public class LoginAcc implements LoginAccInterface{
    
    String username ="";
    String passwd =""; 
    //username must be unique
    ArrayList<String> usernameList =new ArrayList<>();
    ArrayList<String> passwdList =new ArrayList<>();

    @Override
    public boolean checkUsername(String username) {
        for(String s : usernameList ){
            if(s.equals(username)){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean loginNormal(String username, String passwd) {
        for(int i = 0; i < usernameList.size(); i++){
            if((usernameList.get(i).equals(username)) && (passwdList.get(i).equals(passwd))){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loginVia2FA() {
        
        return TwoFA.login2FA();
    }

    @Override
    public boolean loginViaBiometric() {
        
        return BiometricLogin.loginBiometric();
    }

    public boolean register(String username,String passwd){
        if(checkUsername(username)){
            usernameList.add(username);
            passwdList.add(passwd);
            return true;
        }

        return false;
    }
    
}
