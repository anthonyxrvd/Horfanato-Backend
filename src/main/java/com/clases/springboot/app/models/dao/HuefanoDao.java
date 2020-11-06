package com.clases.springboot.app.models.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clases.springboot.app.models.entity.Huerfano;

@Repository("HuerfanoDao")
public interface HuefanoDao  extends JpaRepository<Huerfano,Long> {


}
