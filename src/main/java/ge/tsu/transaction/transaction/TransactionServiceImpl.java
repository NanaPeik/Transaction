package ge.tsu.transaction.transaction;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.User;
import ge.tsu.transaction.classes.tables.pojos.Transaction;
import ge.tsu.transaction.classes.tables.records.TransactionRecord;
import ge.tsu.transaction.exception.HaveNotEnoughAmountForTransactionException;
import ge.tsu.transaction.exception.TransactionNotFoundException;
import ge.tsu.transaction.exception.UserNotFoundException;
import ge.tsu.transaction.user.UserService;
import ge.tsu.transaction.user.UserView;
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private DSLContext dslContext;
  @Autowired
  private UserService userService;

  @Override
  public void createTransaction(TransactionAdd transaction) {
    UserView receiver = userService.getUserById(transaction.getReceiverId());
    UserView sender = userService.getUserById(transaction.getSenderId());
    if (receiver != null) {
      TransactionRecord transactionRecord = dslContext.newRecord(Tables.TRANSACTION);
      BeanUtils.copyProperties(transaction, transactionRecord);

      if(sender.getAmount() < transaction.getAmount()){
          throw new HaveNotEnoughAmountForTransactionException("Not enough amount on your account...");
      }
      userService
          .updateUser(transaction.getReceiverId(), transaction.getAmount() + receiver.getAmount());
      userService
          .updateUser(transaction.getSenderId(), sender.getAmount() - transaction.getAmount());
      transactionRecord.insert();
    }

    throw new UserNotFoundException("incorrect receiver id...");
  }

  @Override
  public List<TransactionView> getTransactions(TransactionForFilter transaction) {
    User receiver = User.USER.as("Receiver");
    User sender = User.USER.as("Sender");
    SelectConditionStep<Record> conditionStep = dslContext
        .select()
        .from(Tables.TRANSACTION)
        .leftJoin(receiver)
        .on(Tables.TRANSACTION.RECEIVER_ID.eq(receiver.ID))
        .leftJoin(sender)
        .on(Tables.TRANSACTION.SENDER_ID.eq(sender.ID))
        .where(DSL.trueCondition());
    if (transaction.getAmount() != null) {
      conditionStep.and(Tables.TRANSACTION.AMOUNT.eq(transaction.getAmount()));
    }
    if (transaction.getDocumentNumber() != null) {
      conditionStep.and(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(transaction.getDocumentNumber()));
    }
    if (transaction.getPostDate() != null) {
      conditionStep.and(Tables.TRANSACTION.POST_DATE.eq(transaction.getPostDate()));
    }
    if (transaction.getReceiverEmail() != null) {
      conditionStep.and(receiver.EMAIL_ADDRESS.eq(transaction.getReceiverEmail()));
    }
    if (transaction.getReceiverAccount() != null) {
      conditionStep.and(receiver.ACCOUNT_NUMBER.eq(transaction.getReceiverAccount()));
    }
    if (transaction.getSenderEmail() != null) {
      conditionStep.and(sender.EMAIL_ADDRESS.eq(transaction.getSenderEmail()));
    }
    if (transaction.getSenderAccount() != null) {
      conditionStep.and(sender.ACCOUNT_NUMBER.eq(transaction.getSenderAccount()));
    }
    if (transaction.getLimit() != null) {
      conditionStep.limit(transaction.getLimit());
    }
    if (transaction.getOffset() != null) {
      conditionStep.offset(transaction.getOffset());
    }

    return conditionStep.fetch()
        .into(TransactionRecord.class)
        .stream()
        .map(it -> map(it.into(Transaction.class)))
        .collect(Collectors.toList());

  }

  @Override
  public TransactionView getTransactionById(Integer transactionId) {
    TransactionRecord record = getTransaction(transactionId);
    if (record != null) {
      return map(record.into(Transaction.class));
    }
    return null;
  }

  @Override
  public void deleteTransaction(Integer transactionId) {
    TransactionRecord transactionRecord = getTransaction(transactionId);
    if (transactionRecord == null) {
      throw new TransactionNotFoundException("Not found transaction with required id... ");
    }
    transactionRecord.delete();
  }


  private TransactionView map(Transaction transaction) {
    TransactionView transactionView = new TransactionView();
    BeanUtils.copyProperties(transaction, transactionView);

    UserView sender = userService.getUserById(transaction.getSenderId());
    transactionView.setSender(sender);

    UserView receiver = userService.getUserById(transaction.getReceiverId());
    transactionView.setReceiver(receiver);

    return transactionView;
  }

  private TransactionRecord getTransaction(Integer transactionId) {
    Record record = dslContext
        .select()
        .from(Tables.TRANSACTION)
        .where(Tables.TRANSACTION.ID.eq(transactionId))
        .fetchOne();
    if (record != null) {
      return record.into(TransactionRecord.class);
    }
    return null;
  }
}
