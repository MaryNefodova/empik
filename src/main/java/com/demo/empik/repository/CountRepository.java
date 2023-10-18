package com.demo.empik.repository;

import com.demo.empik.model.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CountRepository  extends JpaRepository<Count, Integer> {

    @Query(value = "SELECT idcount FROM count c WHERE c.login = :name", nativeQuery = true)
    Integer findAllActiveUsersNative(@Param("name") String name);

    @Query(value = "UPDATE count SET REQUEST_COUNT = REQUEST_COUNT+1 WHERE LOGIN = :name", nativeQuery = true)
    @Modifying
    void updateRequestCountIfExist(@Param("name") String name);


    @Query(value = "INSERT INTO count (LOGIN, REQUEST_COUNT) values (:name, 1)", nativeQuery = true)
    @Modifying
    void insertNewLogin(@Param("name") String name);
}
