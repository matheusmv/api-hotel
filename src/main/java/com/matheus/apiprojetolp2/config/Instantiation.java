package com.matheus.apiprojetolp2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.domain.enums.StatusDoQuarto;
import com.matheus.apiprojetolp2.dto.EnderecoDTO;
import com.matheus.apiprojetolp2.dto.TelefoneDTO;
import com.matheus.apiprojetolp2.repositories.ClienteRepository;
import com.matheus.apiprojetolp2.repositories.QuartoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private QuartoRepository quartoRespository;

	@Override
	public void run(String... args) throws Exception {

		clienteRepository.deleteAll();
		quartoRespository.deleteAll();

		Cliente jose = new Cliente(null, "jose", "jose@gmail.com", "1111111110", "22222222211",
				new EnderecoDTO("x", "xxx", "xxxx", "xxxxx", "xxxxxxx", "xxxx", "xx"),
				new TelefoneDTO("xx", "xxx", "xxxxxxxx"));

		Cliente maria = new Cliente(null, "maria", "maria@gmail.com", "1111111110", "22222222211",
				new EnderecoDTO("x", "xxx", "xxxx", "xxxxx", "xxxxxxx", "xxxx", "xx"),
				new TelefoneDTO("xx", "xxx", "xxxxxxxx"));

		Cliente alex = new Cliente(null, "alex", "alex@gmail.com", "1111111110", "22222222211",
				new EnderecoDTO("x", "xxx", "xxxx", "xxxxx", "xxxxxxx", "xxxx", "xx"),
				new TelefoneDTO("xx", "xxx", "xxxxxxxx"));

		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

		Quarto num1 = new Quarto(null, 200.00, StatusDoQuarto.DISPONIVEL);
		Quarto num2 = new Quarto(null, 150.00, StatusDoQuarto.OCUPADO);
		Quarto num3 = new Quarto(null, 300.00, StatusDoQuarto.RESERVADO);
		Quarto num4 = new Quarto(null, 175.00, StatusDoQuarto.MANUTENCAO);

		quartoRespository.saveAll(Arrays.asList(num1, num2, num3, num4));
	}
}
