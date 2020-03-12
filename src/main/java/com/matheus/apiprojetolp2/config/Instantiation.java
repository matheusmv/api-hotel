package com.matheus.apiprojetolp2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.domain.Endereco;
import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.domain.Servico;
import com.matheus.apiprojetolp2.domain.Telefone;
import com.matheus.apiprojetolp2.domain.enums.StatusDoQuarto;
import com.matheus.apiprojetolp2.domain.enums.TipoCategoria;
import com.matheus.apiprojetolp2.repositories.ClienteRepository;
import com.matheus.apiprojetolp2.repositories.HospedagemRepository;
import com.matheus.apiprojetolp2.repositories.QuartoRepository;
import com.matheus.apiprojetolp2.repositories.ServicoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private QuartoRepository quartoRespository;

	@Autowired
	private HospedagemRepository hospedagemRespository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public void run(String... args) throws Exception {

		/* LIMPANDO O BANCO DE DADOS */

		clienteRepository.deleteAll();
		quartoRespository.deleteAll();
		hospedagemRespository.deleteAll();
		servicoRepository.deleteAll();

		/* CRIANDO QUARTOS */

		Quarto num1 = new Quarto(null, TipoCategoria.MASTER, StatusDoQuarto.OCUPADO, 200.00);
		Quarto num2 = new Quarto(null, TipoCategoria.PADRAO, StatusDoQuarto.OCUPADO, 150.00);
		Quarto num3 = new Quarto(null, TipoCategoria.MASTER_SUPERTIOR, StatusDoQuarto.RESERVADO, 300.00);
		Quarto num4 = new Quarto(null, TipoCategoria.LUXO, StatusDoQuarto.OCUPADO, 175.00);

		/* SALVANDO OS DADOS NO BD */

		quartoRespository.saveAll(Arrays.asList(num1, num2, num3, num4));

		/* CRIANDO SERVIÇOS */

		Servico alimentacao = new Servico(null, "Alimentação", "Serviço de quarto", 40.00);
		Servico limpeza = new Servico(null, "Limpeza", "Limpeza do quarto", 120.00);
		Servico manutencao = new Servico(null, "Manutenção", "Manutenção do quarto", 80.00);

		/* SALVANDO OS DADOS NO BD */

		servicoRepository.saveAll(Arrays.asList(alimentacao, limpeza, manutencao));

		/* CRIANDO CLIENTES */

		Cliente jose = new Cliente(null, "jose", "jose@gmail.com", "12345", "3216549877", "9876543217",
				new Telefone("55", "88", "911111111"), new Endereco("matriz","10","varzea", "62800000", "Aracati", "ce"));

		Cliente maria = new Cliente(null, "maria", "maria@gmail.com", "12345", "4891560236", "9846513204",
				new Telefone("55", "88", "922222222"), new Endereco("matriz","10","varzea", "62800000", "Aracati", "ce"));

		Cliente alex = new Cliente(null, "alex", "alex@gmail.com", "12345", "9517536548", "7539518522",
				new Telefone("55", "88", "933333333"), new Endereco("matriz","10","varzea", "62800000", "Aracati", "ce"));

		/* SALVANDO OS DADOS NO BD */

		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

		/* HOSPEDANDO OS CLIENTES NOS QUARTOS */

		Hospedagem h1 = new Hospedagem(null, jose.getId(), Instant.now(), Instant.now().plusSeconds(604800));
		Hospedagem h2 = new Hospedagem(null, maria.getId(), Instant.now(), Instant.now().plusSeconds(654800));
		Hospedagem h3 = new Hospedagem(null, alex.getId(), Instant.now(), Instant.now().plusSeconds(804800));
		Hospedagem h4 = new Hospedagem(null, jose.getId(), Instant.now(), Instant.now().plusSeconds(904800));

		/* QUARTOS PARA CADA HOSPEDAGEM */

		h1.getQuartos().add(num1);
		h2.getQuartos().add(num4);
		h3.getQuartos().add(num2);
		h4.getQuartos().add(num3);

		/* SALVANDO OS DADOS NO BD */

		hospedagemRespository.saveAll(Arrays.asList(h1, h2, h3, h4));

		/* SALVANDO OS DADOS NO BD */

		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

		/* ADICIONANDO TARIFAS PARA CADA HOSPEDAGEM */

		h1.getTarifas().addAll(Arrays.asList(alimentacao, limpeza, manutencao));
		h2.getTarifas().addAll(Arrays.asList(alimentacao, limpeza, manutencao));
		h3.getTarifas().addAll(Arrays.asList(alimentacao, limpeza, manutencao));
		h4.getTarifas().addAll(Arrays.asList(alimentacao, limpeza, manutencao));

		/* SALVANDO OS DADOS NO BD */

		hospedagemRespository.saveAll(Arrays.asList(h1, h2, h3, h4));
		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

	}
}
