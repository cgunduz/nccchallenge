package com.cemgunduz.cassandratemplate.persistence.mysql.dao;

import com.cemgunduz.cassandratemplate.persistence.mysql.models.Isp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by cem.gunduz on 01.08.2015.
 */
public interface IspDao extends JpaRepository<Isp, Long> {

    @Query(value = "SELECT * FROM Isp WHERE companyName = :companyName", nativeQuery = true)
    List<Isp> findByCompanyName(@Param("companyName") String companyName);

    List<Isp> findByCompanyNameLike(String companyName);

    @Query(value = "select i.companyName from Isp i", nativeQuery = true)
    List<String> findAllCompanyNames();
}
