package com.techmeskills.an16.bondarenko_vadim.homework04.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SleepDatabase_Impl extends SleepDatabase {
  private volatile SleepDatabaseDao _sleepDatabaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `daily_sleep_quality_table` (`nightId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `start_time_milli` INTEGER NOT NULL, `end_time_milli` INTEGER NOT NULL, `quality_rating` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '255b5d9d425094ac56566fea7ada79e1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `daily_sleep_quality_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDailySleepQualityTable = new HashMap<String, TableInfo.Column>(4);
        _columnsDailySleepQualityTable.put("nightId", new TableInfo.Column("nightId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailySleepQualityTable.put("start_time_milli", new TableInfo.Column("start_time_milli", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailySleepQualityTable.put("end_time_milli", new TableInfo.Column("end_time_milli", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailySleepQualityTable.put("quality_rating", new TableInfo.Column("quality_rating", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDailySleepQualityTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDailySleepQualityTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailySleepQualityTable = new TableInfo("daily_sleep_quality_table", _columnsDailySleepQualityTable, _foreignKeysDailySleepQualityTable, _indicesDailySleepQualityTable);
        final TableInfo _existingDailySleepQualityTable = TableInfo.read(_db, "daily_sleep_quality_table");
        if (! _infoDailySleepQualityTable.equals(_existingDailySleepQualityTable)) {
          return new RoomOpenHelper.ValidationResult(false, "daily_sleep_quality_table(com.techmeskills.an16.bondarenko_vadim.homework04.database.SleepNight).\n"
                  + " Expected:\n" + _infoDailySleepQualityTable + "\n"
                  + " Found:\n" + _existingDailySleepQualityTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "255b5d9d425094ac56566fea7ada79e1", "35d9657fac11bd068a9c66bb2ada0eb7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "daily_sleep_quality_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `daily_sleep_quality_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SleepDatabaseDao.class, SleepDatabaseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SleepDatabaseDao getSleepDatabaseDao() {
    if (_sleepDatabaseDao != null) {
      return _sleepDatabaseDao;
    } else {
      synchronized(this) {
        if(_sleepDatabaseDao == null) {
          _sleepDatabaseDao = new SleepDatabaseDao_Impl(this);
        }
        return _sleepDatabaseDao;
      }
    }
  }
}
