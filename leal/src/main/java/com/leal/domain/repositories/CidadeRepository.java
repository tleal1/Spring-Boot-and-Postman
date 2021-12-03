package com.leal.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leal.domain.Cidade;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
