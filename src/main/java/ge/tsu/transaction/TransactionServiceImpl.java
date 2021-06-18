package ge.tsu.transaction;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.records.TransactionRecord;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private DSLContext dslContext;

  @Override
  public void createTransaction(TransactionAdd transaction) {
    TransactionRecord transactionRecord = dslContext.newRecord(Tables.TRANSACTION);
    BeanUtils.copyProperties(transaction, transactionRecord);
    transactionRecord.insert();
  }

  @Override
  public List<Transaction> getTransactions(TransactionForFilter transaction) {
    SelectConditionStep conditionStep =
        (SelectConditionStep) dslContext.select().from(Tables.TRANSACTION);
    if (transaction.getAmount() != null) {
      conditionStep.and(Tables.TRANSACTION.AMOUNT.eq(transaction.getAmount()));
    }
    if (transaction.getDocumentNumber() != null) {
      conditionStep.and(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(transaction.getDocumentNumber()));
    }
    if (transaction.getPostDate() != null) {
      conditionStep.and(Tables.TRANSACTION.POST_DATE.eq(transaction.getPostDate()));
    }
    if (transaction.getReceiver() != null) {
      conditionStep.and(Tables.TRANSACTION.RECEIVER.eq(transaction.getReceiver()));
    }
    if (transaction.getReceiverAccount() != null) {
      conditionStep.and(Tables.TRANSACTION.RECEIVER_ACCOUNT.eq(transaction.getReceiverAccount()));
    }
    List<TransactionRecord> transactionRecords = conditionStep.fetch()
        .into(TransactionRecord.class);

    return (List<Transaction>) transactionRecords.stream().map(this::map);
  }

  @Override
  public Transaction getTransactionById(String documentNumber) {
    TransactionRecord transactionRecord = dslContext.select().from(Tables.TRANSACTION)
        .where(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(documentNumber)).fetchOne()
        .into(TransactionRecord.class);
    return map(transactionRecord);
  }

  @Override
  public boolean deleteTransaction(String documentNumber) {
    dslContext.deleteFrom(Tables.TRANSACTION)
        .where(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(documentNumber))
        .execute();
    return false;
  }

  private Transaction map(TransactionRecord transactionRecord) {
    Transaction transaction = new Transaction();
    transaction.setAmount(transactionRecord.getAmount());
    transaction.setDocumentNumber(transactionRecord.getDocumentNumber());
    transaction.setPostDate(transactionRecord.getPostDate());
    transaction.setReceiver(transactionRecord.getReceiver());
    transaction.setReceiverAccount(transactionRecord.getReceiverAccount());
    transaction.setSender(transactionRecord.getSender());
    transaction.setSenderAccount(transactionRecord.getSenderAccount());
    return transaction;
  }
}
