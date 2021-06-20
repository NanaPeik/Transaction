package ge.tsu.transaction.user;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.pojos.User;
import ge.tsu.transaction.classes.tables.records.UserRecord;
import ge.tsu.transaction.exception.UserAlreadyExistsException;
import java.util.Objects;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  @Autowired
  DSLContext dslContext;

  @Override
  public void registration(UserAdd user) {
    if (userExist(user.getIdentificationNumber())) {
      throw new UserAlreadyExistsException("User is already registered ...");
    }
    UserRecord userRecord = dslContext.newRecord(Tables.USER);
    BeanUtils.copyProperties(user, userRecord);
    userRecord.insert();
  }

  private Boolean userExist(String identificationNumber) {
    return dslContext.select().from(Tables.USER)
      .where(Tables.USER.IDENTIFICATION_NUMBER.eq(identificationNumber)).fetchOne() != null;
  }

  @Override
  public UserView checkUser(String email,String pass) {
    return Objects.requireNonNull(dslContext.select().from(Tables.USER)
        .where(Tables.USER.EMAIL_ADDRESS.eq(email)).and(Tables.USER.PASSWORD.eq(pass))
        .fetchOne()).into(UserRecord.class).map(it->map(it.into(User.class)));
  }

  private UserView map(User user){
    UserView userView=new UserView();
    BeanUtils.copyProperties(user,userView);
    return userView;
  }
}
