package ge.tsu.transaction.user;


public interface UserService {

  void registration(UserAdd user);
  UserView checkUser(String email,String pass);
  UserView userExist(String identificationNumber);
  UserView getUserById(int id);
}
