package com.generationpi.blogpessoalkmartins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generationpi.blogpessoalkmartins.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository <PostagemModel,Long> {

}
