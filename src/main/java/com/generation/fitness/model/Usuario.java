package com.generation.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message = "O atributo Nome é obrigatório!")	
	private String nome;
	
	@NotNull (message = "O atributo Usuário é obrigatório!")	
	@Email (message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotNull (message = "O atributo Senha é obrigatório!")	
	@Size (min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@Size (max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;
	
	@NotNull (message = "O atributo Peso é obrigatório!")	
	private Double peso;

	@NotNull (message = "O atributo Altura é obrigatório!")	
	private Long altura;
	
	private Double imc;
	
	@NotNull (message = "O atributo Idade é obrigatório!")	
	private Long idade;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private Treino treino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Long getAltura() {
		return altura;
	}

	public void setAltura(Long altura) {
		this.altura = altura;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}
	
	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	/*/Método utilitário para calculcar IMC
	private Double calcularIMC () {
		if (altura > 0) {
			double alturaMetros = altura/ 100; //Converter altura de cm para m
			return peso / (alturaMetros * alturaMetros);
		} else {
			throw new IllegalArgumentException("Altura deve ser maior do que 0");
		}
	}
	
	// Método para classicar o IMC
	private String classificarIMC () {
		double imc = calcularIMC ();
		if (imc < 18.5) {
			return String.format("Seu imc é: %2.f. Você está abaixo do peso", getImc());
		} else if (imc >= 18.5 && imc <24.9) {
			return String.format("Seu imc é: %2.f. Você está no peso ideal", getImc());
		} else if (imc >= 25 && imc <29.9) {
			return String.format("Seu imc é: %2.f. Você está com sobrepeso", getImc());
		} else if (imc >=30 && imc <39.9) {
			return String.format("Seu imc é: %2.f. Você está com obesidade I", getImc());
		} else {
			return String.format("Seu imc é: %2.f. Você está com obseidade II", getImc());
		}
	}
	*/
}
