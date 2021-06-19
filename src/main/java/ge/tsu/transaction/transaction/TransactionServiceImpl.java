package ge.tsu.transaction.transaction;

import ge.tsu.transaction.classes.Tables;
import ge.tsu.transaction.classes.tables.records.TransactionRecord;
import ge.tsu.transaction.exception.TransactionNotFoundException;
import ge.tsu.transaction.transaction.Transaction;
import ge.tsu.transaction.transaction.TransactionAdd;
import ge.tsu.transaction.transaction.TransactionForFilter;
import ge.tsu.transaction.transaction.TransactionService;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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
        dslContext.select().from(Tables.TRANSACTION)
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
    if (transaction.getReceiver() != null) {
      conditionStep.and(Tables.TRANSACTION.RECEIVER.eq(transaction.getReceiver()));
    }
    if (transaction.getReceiverAccount() != null) {
      conditionStep.and(Tables.TRANSACTION.RECEIVER_ACCOUNT.eq(transaction.getReceiverAccount()));
    }
    List transactionRecords = conditionStep.fetch()
        .into(TransactionRecord.class);
    if (transactionRecords.isEmpty()) {
      return Collections.emptyList();
    }
    return Collections.emptyList();
  }

  @Override
  public Transaction getTransactionById(String documentNumber) {

    TransactionRecord transactionRecord = dslContext.select().from(Tables.TRANSACTION)
        .where(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(documentNumber))
        .fetchOne().into(TransactionRecord.class);
    return map(transactionRecord);


  }

  @Override
  public void deleteTransaction(String documentNumber) {
    int check = dslContext.deleteFrom(Tables.TRANSACTION)
        .where(Tables.TRANSACTION.DOCUMENT_NUMBER.eq(documentNumber))
        .execute();

    if (check == 0) {
      throw new TransactionNotFoundException("now found transaction with required id... ");
    }
  }



  private Transaction map(Object transactionRecord) {
    Transaction transaction = new Transaction();
    TransactionRecord record= (TransactionRecord) transactionRecord;
    transaction.setAmount(record.getAmount());
    transaction.setDocumentNumber(record.getDocumentNumber());
    transaction.setPostDate(record.getPostDate());
    transaction.setReceiver(record.getReceiver());
    transaction.setReceiverAccount(record.getReceiverAccount());
    transaction.setSender(record.getSender());
    transaction.setSenderAccount(record.getSenderAccount());
    return transaction;
  }
}
