/*
 * This file is generated by jOOQ.
 */
package ge.tsu.transaction.classes.tables.records;


import ge.tsu.transaction.classes.tables.Transaction;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TransactionRecord extends UpdatableRecordImpl<TransactionRecord> implements Record8<Integer, String, LocalDateTime, Double, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.transaction.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.transaction.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.transaction.document_number</code>.
     */
    public void setDocumentNumber(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.transaction.document_number</code>.
     */
    public String getDocumentNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.transaction.post_date</code>.
     */
    public void setPostDate(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.transaction.post_date</code>.
     */
    public LocalDateTime getPostDate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.transaction.amount</code>.
     */
    public void setAmount(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.transaction.amount</code>.
     */
    public Double getAmount() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.transaction.receiver_account</code>.
     */
    public void setReceiverAccount(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.transaction.receiver_account</code>.
     */
    public String getReceiverAccount() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.transaction.receiver</code>.
     */
    public void setReceiver(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.transaction.receiver</code>.
     */
    public String getReceiver() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.transaction.sender_account</code>.
     */
    public void setSenderAccount(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.transaction.sender_account</code>.
     */
    public String getSenderAccount() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.transaction.sender</code>.
     */
    public void setSender(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.transaction.sender</code>.
     */
    public String getSender() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, LocalDateTime, Double, String, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Integer, String, LocalDateTime, Double, String, String, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Transaction.TRANSACTION.ID;
    }

    @Override
    public Field<String> field2() {
        return Transaction.TRANSACTION.DOCUMENT_NUMBER;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Transaction.TRANSACTION.POST_DATE;
    }

    @Override
    public Field<Double> field4() {
        return Transaction.TRANSACTION.AMOUNT;
    }

    @Override
    public Field<String> field5() {
        return Transaction.TRANSACTION.RECEIVER_ACCOUNT;
    }

    @Override
    public Field<String> field6() {
        return Transaction.TRANSACTION.RECEIVER;
    }

    @Override
    public Field<String> field7() {
        return Transaction.TRANSACTION.SENDER_ACCOUNT;
    }

    @Override
    public Field<String> field8() {
        return Transaction.TRANSACTION.SENDER;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getDocumentNumber();
    }

    @Override
    public LocalDateTime component3() {
        return getPostDate();
    }

    @Override
    public Double component4() {
        return getAmount();
    }

    @Override
    public String component5() {
        return getReceiverAccount();
    }

    @Override
    public String component6() {
        return getReceiver();
    }

    @Override
    public String component7() {
        return getSenderAccount();
    }

    @Override
    public String component8() {
        return getSender();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getDocumentNumber();
    }

    @Override
    public LocalDateTime value3() {
        return getPostDate();
    }

    @Override
    public Double value4() {
        return getAmount();
    }

    @Override
    public String value5() {
        return getReceiverAccount();
    }

    @Override
    public String value6() {
        return getReceiver();
    }

    @Override
    public String value7() {
        return getSenderAccount();
    }

    @Override
    public String value8() {
        return getSender();
    }

    @Override
    public TransactionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TransactionRecord value2(String value) {
        setDocumentNumber(value);
        return this;
    }

    @Override
    public TransactionRecord value3(LocalDateTime value) {
        setPostDate(value);
        return this;
    }

    @Override
    public TransactionRecord value4(Double value) {
        setAmount(value);
        return this;
    }

    @Override
    public TransactionRecord value5(String value) {
        setReceiverAccount(value);
        return this;
    }

    @Override
    public TransactionRecord value6(String value) {
        setReceiver(value);
        return this;
    }

    @Override
    public TransactionRecord value7(String value) {
        setSenderAccount(value);
        return this;
    }

    @Override
    public TransactionRecord value8(String value) {
        setSender(value);
        return this;
    }

    @Override
    public TransactionRecord values(Integer value1, String value2, LocalDateTime value3, Double value4, String value5, String value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TransactionRecord
     */
    public TransactionRecord() {
        super(Transaction.TRANSACTION);
    }

    /**
     * Create a detached, initialised TransactionRecord
     */
    public TransactionRecord(Integer id, String documentNumber, LocalDateTime postDate, Double amount, String receiverAccount, String receiver, String senderAccount, String sender) {
        super(Transaction.TRANSACTION);

        setId(id);
        setDocumentNumber(documentNumber);
        setPostDate(postDate);
        setAmount(amount);
        setReceiverAccount(receiverAccount);
        setReceiver(receiver);
        setSenderAccount(senderAccount);
        setSender(sender);
    }
}
