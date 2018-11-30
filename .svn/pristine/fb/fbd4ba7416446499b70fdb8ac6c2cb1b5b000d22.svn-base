package com.meta.db.Dto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository //⑥DBのItemテーブルに接続
public interface ItemRepository extends JpaRepository<Item, Integer>{
	public List<Item> findByLibkey(String libkey);
}