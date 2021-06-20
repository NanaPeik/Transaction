/*
 * This file is generated by jOOQ.
 */
package ge.tsu.transaction.classes.tables.records;


import ge.tsu.transaction.classes.tables.User;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record9<Integer, String, String, Double, String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user.id</code>.
     */
    public UserRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.user.identification_number</code>.
     */
    public UserRecord setIdentificationNumber(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user.identification_number</code>.
     */
    public String getIdentificationNumber() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user.account_number</code>.
     */
    public UserRecord setAccountNumber(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user.account_number</code>.
     */
    public String getAccountNumber() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user.amount</code>.
     */
    public UserRecord setAmount(Double value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user.amount</code>.
     */
    public Double getAmount() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.user.name</code>.
     */
    public UserRecord setName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.user.name</code>.
     */
    public String getName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.user.surname</code>.
     */
    public UserRecord setSurname(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.user.surname</code>.
     */
    public String getSurname() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.user.mobile_number</code>.
     */
    public UserRecord setMobileNumber(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.user.mobile_number</code>.
     */
    public String getMobileNumber() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.user.email_address</code>.
     */
    public UserRecord setEmailAddress(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.user.email_address</code>.
     */
    public String getEmailAddress() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.user.password</code>.
     */
    public UserRecord setPassword(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.user.password</code>.
     */
    public String getPassword() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, Double, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, String, Double, String, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.IDENTIFICATION_NUMBER;
    }

    @Override
    public Field<String> field3() {
        return User.USER.ACCOUNT_NUMBER;
    }

    @Override
    public Field<Double> field4() {
        return User.USER.AMOUNT;
    }

    @Override
    public Field<String> field5() {
        return User.USER.NAME;
    }

    @Override
    public Field<String> field6() {
        return User.USER.SURNAME;
    }

    @Override
    public Field<String> field7() {
        return User.USER.MOBILE_NUMBER;
    }

    @Override
    public Field<String> field8() {
        return User.USER.EMAIL_ADDRESS;
    }

    @Override
    public Field<String> field9() {
        return User.USER.PASSWORD;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getIdentificationNumber();
    }

    @Override
    public String component3() {
        return getAccountNumber();
    }

    @Override
    public Double component4() {
        return getAmount();
    }

    @Override
    public String component5() {
        return getName();
    }

    @Override
    public String component6() {
        return getSurname();
    }

    @Override
    public String component7() {
        return getMobileNumber();
    }

    @Override
    public String component8() {
        return getEmailAddress();
    }

    @Override
    public String component9() {
        return getPassword();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getIdentificationNumber();
    }

    @Override
    public String value3() {
        return getAccountNumber();
    }

    @Override
    public Double value4() {
        return getAmount();
    }

    @Override
    public String value5() {
        return getName();
    }

    @Override
    public String value6() {
        return getSurname();
    }

    @Override
    public String value7() {
        return getMobileNumber();
    }

    @Override
    public String value8() {
        return getEmailAddress();
    }

    @Override
    public String value9() {
        return getPassword();
    }

    @Override
    public UserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setIdentificationNumber(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setAccountNumber(value);
        return this;
    }

    @Override
    public UserRecord value4(Double value) {
        setAmount(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setName(value);
        return this;
    }

    @Override
    public UserRecord value6(String value) {
        setSurname(value);
        return this;
    }

    @Override
    public UserRecord value7(String value) {
        setMobileNumber(value);
        return this;
    }

    @Override
    public UserRecord value8(String value) {
        setEmailAddress(value);
        return this;
    }

    @Override
    public UserRecord value9(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, Double value4, String value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, String identificationNumber, String accountNumber, Double amount, String name, String surname, String mobileNumber, String emailAddress, String password) {
        super(User.USER);

        setId(id);
        setIdentificationNumber(identificationNumber);
        setAccountNumber(accountNumber);
        setAmount(amount);
        setName(name);
        setSurname(surname);
        setMobileNumber(mobileNumber);
        setEmailAddress(emailAddress);
        setPassword(password);
    }
}
