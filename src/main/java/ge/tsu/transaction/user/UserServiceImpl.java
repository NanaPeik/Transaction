package ge.tsu.transaction.user;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.pojos.User;
import ge.tsu.transaction.classes.tables.records.UserRecord;
import ge.tsu.transaction.exception.UserAlreadyExistsException;
import java.util.Objects;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  @Autowired
  DSLContext dslContext;

  @Override
  public void registration(UserAdd user) {
    if (userExist(user.getIdentificationNumber()) != null) {
      throw new UserAlreadyExistsException("User is already registered ...");
    }
    UserRecord userRecord = dslContext.newRecord(Tables.USER);
    BeanUtils.copyProperties(user, userRecord);
    userRecord.insert();
  }

  @Override
  public UserView userExist(String identificationNumber) {
    Record record = dslContext.select().from(Tables.USER)
        .where(Tables.USER.IDENTIFICATION_NUMBER.eq(identificationNumber))
        .fetchOne();
    if (record != null) {
      return record.into(UserRecord.class).map(it -> map(it.into(User.class)));
    }
    return null;
  }

  @Override
  public UserView getUserById(int id) {
    Record record = dslContext.select().from(Tables.USER)
        .where(Tables.USER.ID.eq(id)).fetchOne();
    if (record != null) {
      return record.into(UserRecord.class).map(it -> map(it.into(User.class)));
    }
    return null;
  }

  @Override
  public void updateUser(int id, Double amount) {
    dslContext.update(Tables.USER)
        .set(Tables.USER.AMOUNT, amount).where(Tables.USER.ID.eq(id))
        .execute();
  }

  @Override
  public UserView checkUser(String email, String pass) {
    Record record = dslContext.select().from(Tables.USER)
        .where(Tables.USER.EMAIL_ADDRESS.eq(email))
        .and(Tables.USER.PASSWORD.eq(pass))
        .fetchOne();
    if (record != null) {
      return record.into(UserRecord.class).map(it -> map(it.into(User.class)));
    }
    return null;
  }

  private UserView map(User user) {
    UserView userView = new UserView();
    BeanUtils.copyProperties(user, userView);
    return userView;
  }
}
