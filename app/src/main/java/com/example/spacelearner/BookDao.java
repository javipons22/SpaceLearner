package com.example.spacelearner;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("INSERT INTO books (title,chapter,addedDate,revisionsAmount,nextRevision,maxRevisions) VALUES (:title,:chapter,:createdDate,:revisions,:nextRevision,:maxRevisions)")
    void create(String title, String chapter,Long createdDate, int revisions, Long nextRevision, int maxRevisions);

    @Query("SELECT * FROM books WHERE nextRevision > :dateNow AND revisionsAmount < maxRevisions ORDER BY nextRevision ASC")
    List<Book> getAllActivities(Long dateNow);

    @Query("SELECT * FROM books WHERE nextRevision <= :dateNow AND revisionsAmount < maxRevisions ORDER BY nextRevision ASC")
    List<Book> getAllTodos(Long dateNow);

    @Query("SELECT * FROM books WHERE revisionsAmount >= maxRevisions ORDER BY addedDate DESC")
    List<Book> getAllDone();

    @Query("UPDATE books SET title = :title, chapter = :chapter WHERE id = :id")
    void updateValues(String title,String chapter, int id);

    @Query("UPDATE books SET revisionsAmount = :revisions WHERE id = :id")
    void updateRevisionsAmount(int revisions, int id);

    @Query("DELETE FROM books WHERE id = :id")
    void delete(int id);

    @Query("DELETE FROM books")
    void deleteAll();
}
