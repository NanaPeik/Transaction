package ge.tsu.transaction.user;

import ge.tsu.transaction.exception.UserIsNotRegisteredException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/user")
  public void registration(@RequestBody UserAdd user) {
    userService.registration(user);
  }

  @PostMapping("/login")
  public void logIn(@RequestParam String email,
      @RequestParam String pass,
      HttpServletResponse httpServletResponse) {
    UserView userView = userService.checkUser(email, pass);
    if (userView == null) {
      throw new UserIsNotRegisteredException("Incorrect email or password...");
    }
    Cookie cookie = new Cookie("user_id", userView.getIdentificationNumber());
    cookie.setHttpOnly(true);
    httpServletResponse.addCookie(cookie);
  }

  @PostMapping("/logOut")
  public void logOut(HttpServletRequest request,
      HttpServletResponse httpServletResponse) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("user_id")) {
          cookie.setValue(null);
          httpServletResponse.addCookie(cookie);
        }
      }
    }
  }
}
