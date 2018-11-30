package com.meta.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistoryDB, Integer> {
	@Query(value="select sh from SearchHistoryDB sh where concat like :name")
	public List<SearchHistoryDB>srQuery(@Param("name") String name);
}
