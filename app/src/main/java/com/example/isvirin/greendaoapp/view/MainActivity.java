package com.example.isvirin.greendaoapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.isvirin.greendaoapp.DaoApp;
import com.example.isvirin.greendaoapp.R;
import com.example.isvirin.greendaoapp.model.User2;
import com.example.isvirin.greendaoapp.model.UserDao;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
//    private ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User2> usersForList = new ArrayList<>();
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
//        realm = Realm.getInstance(new RealmConfiguration.Builder(this).build());
//        realm = Realm.getInstance(((DaoApp) getApplication()).getRealmConfiguration());
        Realm.deleteRealm(Realm.getDefaultConfiguration());
        realm = Realm.getDefaultInstance();

        generateUsers();
        writeUsers();
        showUsersList();

//        clearAll();
    }

    private void clearAll() {
        UserDao userDao = ((DaoApp) getApplication()).getDaoSession().getUserDao();
        userDao.deleteAll();
    }

    private void showUsersList() {
        realm.beginTransaction();
        RealmQuery<User2> query = realm.where(User2.class);
        RealmResults<User2> result1 = query.findAll();
        for (int i = 0; i < result1.size(); i++) {
            usersForList.add(result1.get(i));
        }



        realm.commitTransaction();

//        UserDao userDao = ((DaoApp) getApplication()).getDaoSession().getUserDao();
//        Query<User> query = userDao
//                .queryBuilder()
//                .orderAsc(UserDao.Properties.LastName)
//                .build();
//        usersForList = (ArrayList<User>) query.list();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment, new UserListFragment()).commit();
    }

    private void writeUsers() {
//        ((DaoApp) getApplication()).getDaoSession().getUserDao().insertInTx(users);
    }

    private void generateUsers() {
        realm.beginTransaction();
        for (int i = 0; i < 100; i++) {
            User2 user = realm.createObject(User2.class); // Create a new object
            user.setFirstName("first_name_" + i);
            user.setLastName("last_name_" + i);
//            users.add(new User("first_name_" + i, "last_name_" + i));
        }
//        User2 user = realm.createObject(User2.class); // Create a new object
//        user.setFirstName("first_name_");
//        user.setLastName("last_name_");

        realm.commitTransaction();
    }
}
