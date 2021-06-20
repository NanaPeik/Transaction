/*
 * This file is generated by jOOQ.
 */
package ge.tsu.transaction.classes.tables;


import ge.tsu.transaction.classes.Keys;
import ge.tsu.transaction.classes.Public;
import ge.tsu.transaction.classes.tables.records.TransactionRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Transaction extends TableImpl<TransactionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.transaction</code>
     */
    public static final Transaction TRANSACTION = new Transaction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionRecord> getRecordType() {
        return TransactionRecord.class;
    }

    /**
     * The column <code>public.transaction.id</code>.
     */
    public final TableField<TransactionRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.transaction.document_number</code>.
     */
    public final TableField<TransactionRecord, String> DOCUMENT_NUMBER = createField(DSL.name("document_number"), SQLDataType.VARCHAR.defaultValue(DSL.field("uuid_in((md5((random())::text))::cstring)", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>public.transaction.post_date</code>.
     */
    public final TableField<TransactionRecord, LocalDateTime> POST_DATE = createField(DSL.name("post_date"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.transaction.amount</code>.
     */
    public final TableField<TransactionRecord, Double> AMOUNT = createField(DSL.name("amount"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.transaction.receiver_id</code>.
     */
    public final TableField<TransactionRecord, Integer> RECEIVER_ID = createField(DSL.name("receiver_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.transaction.sender_id</code>.
     */
    public final TableField<TransactionRecord, Integer> SENDER_ID = createField(DSL.name("sender_id"), SQLDataType.INTEGER, this, "");

    private Transaction(Name alias, Table<TransactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transaction(Name alias, Table<TransactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.transaction</code> table reference
     */
    public Transaction(String alias) {
        this(DSL.name(alias), TRANSACTION);
    }

    /**
     * Create an aliased <code>public.transaction</code> table reference
     */
    public Transaction(Name alias) {
        this(alias, TRANSACTION);
    }

    /**
     * Create a <code>public.transaction</code> table reference
     */
    public Transaction() {
        this(DSL.name("transaction"), null);
    }

    public <O extends Record> Transaction(Table<O> child, ForeignKey<O, TransactionRecord> key) {
        super(child, key, TRANSACTION);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TransactionRecord, Integer> getIdentity() {
        return (Identity<TransactionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TransactionRecord> getPrimaryKey() {
        return Keys.STATUS_PK;
    }

    @Override
    public List<UniqueKey<TransactionRecord>> getKeys() {
        return Arrays.<UniqueKey<TransactionRecord>>asList(Keys.STATUS_PK);
    }

    @Override
    public List<ForeignKey<TransactionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TransactionRecord, ?>>asList(Keys.TRANSACTION__RECEIVER_ID_FK01, Keys.TRANSACTION__SENDER_ID_FK02);
    }

    private transient User _receiverIdFk01;
    private transient User _senderIdFk02;

    public User receiverIdFk01() {
        if (_receiverIdFk01 == null)
            _receiverIdFk01 = new User(this, Keys.TRANSACTION__RECEIVER_ID_FK01);

        return _receiverIdFk01;
    }

    public User senderIdFk02() {
        if (_senderIdFk02 == null)
            _senderIdFk02 = new User(this, Keys.TRANSACTION__SENDER_ID_FK02);

        return _senderIdFk02;
    }

    @Override
    public Transaction as(String alias) {
        return new Transaction(DSL.name(alias), this);
    }

    @Override
    public Transaction as(Name alias) {
        return new Transaction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaction rename(String name) {
        return new Transaction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaction rename(Name name) {
        return new Transaction(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, LocalDateTime, Double, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
