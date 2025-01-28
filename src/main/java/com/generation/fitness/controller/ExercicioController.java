package com.generation.fitness.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.fitness.model.Exercicio;
import com.generation.fitness.repository.CategoriaRepository;
import com.generation.fitness.repository.ExercicioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exercicios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExercicioController {

	@Autowired
	private ExercicioRepository exercicioRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Exercicio>> getAll() {
		return ResponseEntity.ok(exercicioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Exercicio> getById(@PathVariable Long id) {
		return exercicioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Exercicio>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(exercicioRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Exercicio> post(@Valid @RequestBody Exercicio exercicio) {
		if (categoriaRepository.existsById(exercicio.getCategoria().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicio));

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
	}

	@PutMapping
	public ResponseEntity<Exercicio> put(@Valid @RequestBody Exercicio exercicio) {
		if (exercicioRepository.existsById(exercicio.getId())) {
		}

		if (categoriaRepository.existsById(exercicio.getCategoria().getId()))
			return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.save(exercicio));
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Exercicio> exercicio = exercicioRepository.findById(id);

		if (exercicio.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		exercicioRepository.deleteById(id);
	}
}
