package com.Junior.bookstore;

import domain.Categoria;
import domain.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import repositories.CategoriaRepository;
import repositories.LivroRepository;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1= new Categoria(null,"Informatica","Livro de TI");

		Livro l1 = new Livro(null,"Clean code","Robert Martin","Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList((List) l1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));


	}
}
