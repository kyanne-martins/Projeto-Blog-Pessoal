package com.generation.blogpessoalkmartins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoalkmartins.model.TemaModel;
import com.generation.blogpessoalkmartins.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> GetById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TemaModel>> GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<TemaModel> postTema (@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<TemaModel> putPostagem (@RequestBody TemaModel tema){
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable Long id) {
		repository.deleteById(id);

}

}
