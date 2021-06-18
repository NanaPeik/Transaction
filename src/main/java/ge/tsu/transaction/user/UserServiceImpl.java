package ge.tsu.transaction.user;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  @Autowired
  DSLContext dslContext;

  @Override
  public void registration(User user) {
    UserRecord userRecord=dslContext.newRecord(Tables.USER);
    BeanUtils.copyProperties(user,userRecord);
    userRecord.insert();
  }
}
