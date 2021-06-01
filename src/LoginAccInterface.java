public interface LoginAccInterface {
    boolean loginNormal(String username,String passwd);
    boolean checkUsername(String username);
    boolean loginVia2FA();
    boolean loginViaBiometric();
    boolean register(String username,String passwd);
}
