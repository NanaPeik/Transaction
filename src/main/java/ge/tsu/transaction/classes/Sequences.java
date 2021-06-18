/*
 * This file is generated by jOOQ.
 */
package ge.tsu.transaction.classes;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.transaction_id_seq</code>
     */
    public static final Sequence<Integer> TRANSACTION_ID_SEQ = Internal.createSequence("transaction_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.user_id_seq</code>
     */
    public static final Sequence<Integer> USER_ID_SEQ = Internal.createSequence("user_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}