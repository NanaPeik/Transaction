package ge.tsu.transaction.user;


public interface UserService {

  void registration(UserAdd user);
  UserView checkUser(String email,String pass);
}
