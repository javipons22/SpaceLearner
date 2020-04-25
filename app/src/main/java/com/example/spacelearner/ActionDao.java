package com.example.spacelearner;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActionDao {
    @Query("INSERT INTO actions (content) VALUES (:content)")
    void create(String content);

    @Query("SELECT * FROM actions")
    List<Action> getAll();

    @Query("UPDATE actions SET content = :content WHERE id = :id")
    void save(String content, int id);

    @Query("DELETE FROM actions WHERE id = :id")
    void delete(int id);

    @Query("SELECT content FROM actions")
    List<String> getContents();

    @Query("DELETE FROM actions")
    void deleteAll();
}
