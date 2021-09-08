package com.example.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where userEmail=(:userEmail) and password=(:password)")
    UserEntity login (String userEmail, String password);


}
