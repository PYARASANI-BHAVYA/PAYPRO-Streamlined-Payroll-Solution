package com.payproapi.api.repositories;

import com.payproapi.api.entity.SalaryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payproapi.api.entity.SalaryEntity;


@Repository
public interface SalaryRepository extends CrudRepository<SalaryEntity, Integer> {

    @Query(value = "SELECT * FROM b_salary", nativeQuery = true)
    Page<SalaryEntity> listAllSalaries(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM b_salary", nativeQuery = true)
    String countSalaries();
}

