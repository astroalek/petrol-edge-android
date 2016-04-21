package it.petroledge.spotthatcar.repository.schema;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import it.petroledge.spotthatcar.repository.schema.Car;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CAR".
*/
public class CarDao extends AbstractDao<Car, Long> {

    public static final String TABLENAME = "CAR";

    /**
     * Properties of entity Car.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Feed_date = new Property(1, java.util.Date.class, "feed_date", false, "FEED_DATE");
    };


    public CarDao(DaoConfig config) {
        super(config);
    }
    
    public CarDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CAR\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FEED_DATE\" INTEGER);"); // 1: feed_date
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "idx_feed_date_desc ON CAR" +
                " (\"FEED_DATE\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CAR\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Car entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date feed_date = entity.getFeed_date();
        if (feed_date != null) {
            stmt.bindLong(2, feed_date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Car readEntity(Cursor cursor, int offset) {
        Car entity = new Car( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)) // feed_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Car entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFeed_date(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Car entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Car entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}