package com.example.isvirin.greendaoapp;

import android.app.Application;

import com.example.isvirin.greendaoapp.model.DaoMaster;
import com.example.isvirin.greendaoapp.model.DaoSession;

import org.greenrobot.greendao.database.Database;

public class DaoApp extends Application {
    public static final boolean ENCRYPTED = false;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), ENCRYPTED ? "shop-db-encrypted" : "shop-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
