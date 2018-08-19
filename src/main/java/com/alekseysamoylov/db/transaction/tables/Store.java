/*
 * This file is generated by jOOQ.
*/
package com.alekseysamoylov.db.transaction.tables;


import com.alekseysamoylov.db.transaction.Indexes;
import com.alekseysamoylov.db.transaction.Keys;
import com.alekseysamoylov.db.transaction.Public;
import com.alekseysamoylov.db.transaction.tables.records.StoreRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Store extends TableImpl<StoreRecord> {

    private static final long serialVersionUID = 597221522;

    /**
     * The reference instance of <code>public.store</code>
     */
    public static final Store STORE = new Store();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreRecord> getRecordType() {
        return StoreRecord.class;
    }

    /**
     * The column <code>public.store.id</code>.
     */
    public final TableField<StoreRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('store_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.store.name</code>.
     */
    public final TableField<StoreRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>public.store</code> table reference
     */
    public Store() {
        this(DSL.name("store"), null);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(String alias) {
        this(DSL.name(alias), STORE);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(Name alias) {
        this(alias, STORE);
    }

    private Store(Name alias, Table<StoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private Store(Name alias, Table<StoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STORE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<StoreRecord, Integer> getIdentity() {
        return Keys.IDENTITY_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StoreRecord> getPrimaryKey() {
        return Keys.STORE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StoreRecord>> getKeys() {
        return Arrays.<UniqueKey<StoreRecord>>asList(Keys.STORE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Store as(String alias) {
        return new Store(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Store as(Name alias) {
        return new Store(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(String name) {
        return new Store(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(Name name) {
        return new Store(name, null);
    }
}
