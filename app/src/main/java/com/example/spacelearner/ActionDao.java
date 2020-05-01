package com.example.spacelearner;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActionDao {
    @Query("INSERT INTO actions3 (title,chapter,addedDate,revisionsAmount,nextRevision,maxRevisions) VALUES (:title,:chapter,:createdDate,:revisions,:nextRevision,:maxRevisions)")
    void create(String title, String chapter,Long createdDate, int revisions, Long nextRevision, int maxRevisions);

    @Query("SELECT * FROM actions3 WHERE nextRevision > :dateNow AND revisionsAmount < maxRevisions ORDER BY nextRevision ASC")
    List<Action3> getAllActivities(Long dateNow);

    @Query("SELECT * FROM actions3 WHERE nextRevision <= :dateNow AND revisionsAmount < maxRevisions ORDER BY nextRevision ASC")
    List<Action3> getAllTodos(Long dateNow);

    @Query("SELECT * FROM actions3 WHERE revisionsAmount >= maxRevisions ORDER BY addedDate DESC")
    List<Action3> getAllDone();

    @Query("UPDATE actions3 SET title = :title, chapter = :chapter WHERE id = :id")
    void updateValues(String title,String chapter, int id);

    @Query("UPDATE actions3 SET revisionsAmount = :revisions WHERE id = :id")
    void updateRevisionsAmount(int revisions, int id);

    @Query("DELETE FROM actions3 WHERE id = :id")
    void delete(int id);

    @Query("DELETE FROM actions3")
    void deleteAll();
}
