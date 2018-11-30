package com.meta.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSearchRepository extends JpaRepository<BookSearchList,Integer> {

}
