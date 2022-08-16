package com.generation.blogpessoalkmartins.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoalkmartins.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)	
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	 @Autowired
	 private UsuarioRepository usuarioRepository;
	
	 @BeforeAll
	 void start() {
		 
		 usuarioRepository.deleteAll();	
		 usuarioRepository.save(new Usuario(0L,"João da Silva", "joao@email.com.br", "13465278", "https://i.imgur.com/FETvs2O.jpg"));
		 usuarioRepository.save(new Usuario(0L,"Manuela da Silva", "manuela@email.com.br", "13465278","https :1/i. imgur . com/NtyGneo. jpg"));
		 usuarioRepository.save(new Usuario(0L,"Adriana da Silva","adriana@email.com.br","13465278","https://i . imgur.com/mB3VM2N"));
		 usuarioRepository.save(new Usuario(0L,"Paulo Antunes","paulo@email.com.br","13465278","https :1/i. imgur . coei! JR7kUFU. jpg"));
		 
	 }

	 @Test
	 @DisplayName("Retorna  1  usuario")
	 public void deveRetornarUmUsuario() {
	Optional<Usuario>usuario = usuarioRepository.findByUsuario("joao@email.com.br");
	assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	
	 }
	 
	 @Test
	 @DisplayName("Retorna  3  usuarios")
	 public void deveRetornarTresUsuario() {
		 
	 
	List<Usuario> listDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
	assertEquals(3,listDeUsuarios.size());
	assertTrue(listDeUsuarios.get(0).getNome().equals("João da Silva")); 
	assertTrue(listDeUsuarios.get(1).getNome().equals("Manuela da Silva")); 
	assertTrue(listDeUsuarios.get(2).getNome().equals("Adriana da Silva")); 
	 }
	 
	 @AfterAll
	 public void end() {
		 usuarioRepository.deleteAll();
	 }
	 
}


