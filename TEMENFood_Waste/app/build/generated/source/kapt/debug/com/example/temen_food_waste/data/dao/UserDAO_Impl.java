package com.example.temen_food_waste.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.temen_food_waste.data.entity.User;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDAO_Impl implements UserDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  public UserDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User` (`id_user`,`username`,`email`,`password`,`token`,`is_email_verified`,`foto_profil`,`no_telp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId_user() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_user());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getToken() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getToken());
        }
        stmt.bindLong(6, value.is_email_verified());
        if (value.getFoto_profil() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFoto_profil());
        }
        if (value.getNo_telp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getNo_telp());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId_user() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_user());
        }
      }
    };
  }

  @Override
  public void insertAll(final User... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "SELECT * FROM user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "token");
      final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "is_email_verified");
      final int _cursorIndexOfFotoProfil = CursorUtil.getColumnIndexOrThrow(_cursor, "foto_profil");
      final int _cursorIndexOfNoTelp = CursorUtil.getColumnIndexOrThrow(_cursor, "no_telp");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final Integer _tmpId_user;
        if (_cursor.isNull(_cursorIndexOfIdUser)) {
          _tmpId_user = null;
        } else {
          _tmpId_user = _cursor.getInt(_cursorIndexOfIdUser);
        }
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpToken;
        if (_cursor.isNull(_cursorIndexOfToken)) {
          _tmpToken = null;
        } else {
          _tmpToken = _cursor.getString(_cursorIndexOfToken);
        }
        final int _tmpIs_email_verified;
        _tmpIs_email_verified = _cursor.getInt(_cursorIndexOfIsEmailVerified);
        final String _tmpFoto_profil;
        if (_cursor.isNull(_cursorIndexOfFotoProfil)) {
          _tmpFoto_profil = null;
        } else {
          _tmpFoto_profil = _cursor.getString(_cursorIndexOfFotoProfil);
        }
        final Integer _tmpNo_telp;
        if (_cursor.isNull(_cursorIndexOfNoTelp)) {
          _tmpNo_telp = null;
        } else {
          _tmpNo_telp = _cursor.getInt(_cursorIndexOfNoTelp);
        }
        _item = new User(_tmpId_user,_tmpUsername,_tmpEmail,_tmpPassword,_tmpToken,_tmpIs_email_verified,_tmpFoto_profil,_tmpNo_telp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> loadAllByIds(final int[] idUser) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM user WHERE id_user IN (");
    final int _inputSize = idUser.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : idUser) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "token");
      final int _cursorIndexOfIsEmailVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "is_email_verified");
      final int _cursorIndexOfFotoProfil = CursorUtil.getColumnIndexOrThrow(_cursor, "foto_profil");
      final int _cursorIndexOfNoTelp = CursorUtil.getColumnIndexOrThrow(_cursor, "no_telp");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item_1;
        final Integer _tmpId_user;
        if (_cursor.isNull(_cursorIndexOfIdUser)) {
          _tmpId_user = null;
        } else {
          _tmpId_user = _cursor.getInt(_cursorIndexOfIdUser);
        }
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpToken;
        if (_cursor.isNull(_cursorIndexOfToken)) {
          _tmpToken = null;
        } else {
          _tmpToken = _cursor.getString(_cursorIndexOfToken);
        }
        final int _tmpIs_email_verified;
        _tmpIs_email_verified = _cursor.getInt(_cursorIndexOfIsEmailVerified);
        final String _tmpFoto_profil;
        if (_cursor.isNull(_cursorIndexOfFotoProfil)) {
          _tmpFoto_profil = null;
        } else {
          _tmpFoto_profil = _cursor.getString(_cursorIndexOfFotoProfil);
        }
        final Integer _tmpNo_telp;
        if (_cursor.isNull(_cursorIndexOfNoTelp)) {
          _tmpNo_telp = null;
        } else {
          _tmpNo_telp = _cursor.getInt(_cursorIndexOfNoTelp);
        }
        _item_1 = new User(_tmpId_user,_tmpUsername,_tmpEmail,_tmpPassword,_tmpToken,_tmpIs_email_verified,_tmpFoto_profil,_tmpNo_telp);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
