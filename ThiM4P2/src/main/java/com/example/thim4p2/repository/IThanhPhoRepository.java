package com.example.thim4p2.repository;

import com.example.thim4p2.model.ThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IThanhPhoRepository extends JpaRepository<ThanhPho,Integer> {
//    @Query(nativeQuery = true,value = "select tp.* from thanh_pho tp join quoc_gia qg on tp.quoc_gia_id = qg.id where tp.is_delete = 0")
//    List<ThanhPho> hienThiThanhPho();

}
