package com.rnm.omdb.daos;


import com.rnm.omdb.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark findByTitle(String title);
}