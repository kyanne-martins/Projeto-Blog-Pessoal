package com.generationpi.blogpessoalkmartins.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generationpi.blogpessoalkmartins.model.TemaModel;

public interface TemaRepository extends JpaRepository <TemaModel,Long>  {
public List <TemaModel> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
	
}
