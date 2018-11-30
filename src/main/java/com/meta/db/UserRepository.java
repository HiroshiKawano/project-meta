package com.meta.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Integer>{

	@Query(value="select it from UserDB it where it.mail like :mail")
	public List<UserDB> myQuery(@Param("mail") String mail);

	//アカウント登録時に入力されたメールアドレスが既にDBにないか確認
	public Optional<UserDB> findByMail(String mail);

}
