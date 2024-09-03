package com.FabLab.FabLab.repository;

import com.FabLab.FabLab.entity.User;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("DELETE FROM User u WHERE u.name = :name ")
    void DeleteByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.name = :name ")
    User ReadByName(@Param("name") String name);

}