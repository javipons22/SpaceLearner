package com.example.spacelearner;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActionDao {
    @Query("INSERT INTO actions3 (content,addedDate,revisionsAmount,nextRevision,maxRevisions) VALUES (:content,:createdDate,:revisions,:nextRevision,:maxRevisions)")
    void create(String content,Long createdDate,int revisions,Long nextRevision,int maxRevisions);

    @Query("SELECT * FROM actions3 ORDER BY addedDate DESC")
    List<Action3> getAll();

    @Query("UPDATE actions3 SET content = :content WHERE id = :id")
    void save(String content, int id);

    @Query("DELETE FROM actions3 WHERE id = :id")
    void delete(int id);

    @Query("SELECT content FROM actions3")
    List<String> getContents();

    @Query("DELETE FROM actions3")
    void deleteAll();
}
