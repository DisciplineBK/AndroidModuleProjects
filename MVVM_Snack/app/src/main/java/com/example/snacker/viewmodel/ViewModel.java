package com.example.snacker.viewmodel;

import androidx.databinding.BaseObservable;

import com.example.snacker.model.Database;
import com.example.snacker.model.Person;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseObservable {
    private Database database;
    private List<Person> items = new ArrayList<>();
    private String winner;

    public ViewModel(Database database){
        Logger.d("ViewModel 생성자 실행 | DB(Model) 참조");
        this.database = database;

        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                Logger.d("리스너 실행");
                winner = null;
                winner = database.getWinner();
                notifyChange();
            }
        });
    }

    public void getUser() {
        Logger.d("db에게 user(winner)를 달라고 요청");
        database.getUser();
    }

    public String getWinner(){
        Logger.d("Winner 반환 (%s)", winner);
        return winner;
    }
}
