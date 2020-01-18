package com.matheus.apiprojetolp2.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.domain.enums.StatusDoQuarto;
import com.matheus.apiprojetolp2.dto.CategoriaDTO;
import com.matheus.apiprojetolp2.dto.ClienteSimplesDTO;
import com.matheus.apiprojetolp2.dto.EnderecoDTO;
import com.matheus.apiprojetolp2.dto.QuartoDTO;
import com.matheus.apiprojetolp2.dto.TarifaDTO;
import com.matheus.apiprojetolp2.dto.TelefoneDTO;
import com.matheus.apiprojetolp2.dto.enums.TipoCategoria;
import com.matheus.apiprojetolp2.dto.enums.TipoServico;
import com.matheus.apiprojetolp2.repositories.ClienteRepository;
import com.matheus.apiprojetolp2.repositories.HospedagemRepository;
import com.matheus.apiprojetolp2.repositories.QuartoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private QuartoRepository quartoRespository;

	@Autowired
	private HospedagemRepository hospedagemRespository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		/* LIMPANDO O BANCO DE DADOS */

		clienteRepository.deleteAll();
		quartoRespository.deleteAll();
		hospedagemRespository.deleteAll();

		/* CRIANDO QUARTOS */

		Quarto num1 = new Quarto(null, 200.00, StatusDoQuarto.OCUPADO, new CategoriaDTO(TipoCategoria.MASTER));
		Quarto num2 = new Quarto(null, 150.00, StatusDoQuarto.OCUPADO, new CategoriaDTO(TipoCategoria.PADRAO));
		Quarto num3 = new Quarto(null, 300.00, StatusDoQuarto.RESERVADO,
				new CategoriaDTO(TipoCategoria.MASTER_SUPERTIOR));
		Quarto num4 = new Quarto(null, 175.00, StatusDoQuarto.OCUPADO, new CategoriaDTO(TipoCategoria.LUXO));

		/* SALVANDO OS DADOS NO BD */

		quartoRespository.saveAll(Arrays.asList(num1, num2, num3, num4));

		/* CRIANDO CLIENTES */

		Cliente jose = new Cliente(null, "jose", "jose@gmail.com", "3216549877", "9876543217",
				new EnderecoDTO("A", "111", "AA", "Bairro A", "62800000", "Aracati", "CE"),
				new TelefoneDTO("55", "88", "911111111"));

		Cliente maria = new Cliente(null, "maria", "maria@gmail.com", "4891560236", "9846513204",
				new EnderecoDTO("B", "222", "BB", "Bairro B", "62800000", "Aracati", "CE"),
				new TelefoneDTO("55", "88", "922222222"));

		Cliente alex = new Cliente(null, "alex", "alex@gmail.com", "9517536548", "7539518522",
				new EnderecoDTO("C", "333", "CC", "Bairro C", "62800000", "Aracati", "CE"),
				new TelefoneDTO("55", "88", "933333333"));

		/* SALVANDO OS DADOS NO BD */

		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

		/* HOSPEDANDO OS CLIENTES NOS QUARTOS */

		Hospedagem h1 = new Hospedagem(null, sdf.parse("20/06/2019"), sdf.parse("27/06/2019"),
				new ClienteSimplesDTO(jose));
		Hospedagem h2 = new Hospedagem(null, sdf.parse("01/08/2019"), sdf.parse("17/08/2019"),
				new ClienteSimplesDTO(maria));
		Hospedagem h3 = new Hospedagem(null, sdf.parse("30/11/2019"), sdf.parse("07/12/2019"),
				new ClienteSimplesDTO(alex));
		Hospedagem h4 = new Hospedagem(null, sdf.parse("01/03/2019"), sdf.parse("10/03/2019"),
				new ClienteSimplesDTO(jose));

		/* QUARTOS PARA CADA HOSPEDAGEM */

		h1.getQuartos().add(new QuartoDTO(num1));
		h2.getQuartos().add(new QuartoDTO(num4));
		h3.getQuartos().add(new QuartoDTO(num2));
		h4.getQuartos().add(new QuartoDTO(num3));

		/* SALVANDO OS DADOS NO BD */

		hospedagemRespository.saveAll(Arrays.asList(h1, h2, h3, h4));

		/* HOSPEDAGENS DE CADA CLIENTE */

		jose.getHospedagens().add(h4);
		jose.getHospedagens().add(h1);
		maria.getHospedagens().add(h2);
		alex.getHospedagens().add(h2);

		/* SALVANDO OS DADOS NO BD */

		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));

		/* ADICIONANDO TARIFAS PARA CADA HOSPEDAGEM */

		TarifaDTO t1 = new TarifaDTO(TipoServico.ALIMENTACAO, 40.00);
		TarifaDTO t2 = new TarifaDTO(TipoServico.ALIMENTACAO, 50.80);
		TarifaDTO t3 = new TarifaDTO(TipoServico.LIMPEZA, 120.00);

		TarifaDTO t4 = new TarifaDTO(TipoServico.ALIMENTACAO, 40.00);
		TarifaDTO t5 = new TarifaDTO(TipoServico.ALIMENTACAO, 50.80);
		TarifaDTO t6 = new TarifaDTO(TipoServico.LIMPEZA, 120.00);

		TarifaDTO t7 = new TarifaDTO(TipoServico.ALIMENTACAO, 40.00);
		TarifaDTO t8 = new TarifaDTO(TipoServico.ALIMENTACAO, 50.80);
		TarifaDTO t9 = new TarifaDTO(TipoServico.LIMPEZA, 120.00);

		TarifaDTO t10 = new TarifaDTO(TipoServico.ALIMENTACAO, 40.00);
		TarifaDTO t11 = new TarifaDTO(TipoServico.ALIMENTACAO, 50.80);
		TarifaDTO t12 = new TarifaDTO(TipoServico.LIMPEZA, 120.00);

		h1.getTarifas().addAll(Arrays.asList(t1, t2, t3));
		h2.getTarifas().addAll(Arrays.asList(t4, t5, t6));
		h3.getTarifas().addAll(Arrays.asList(t7, t8, t9));
		h4.getTarifas().addAll(Arrays.asList(t10, t11, t12));

		/* SALVANDO OS DADOS NO BD */

		hospedagemRespository.saveAll(Arrays.asList(h1, h2, h3, h4));
		clienteRepository.saveAll(Arrays.asList(jose, maria, alex));
	}
}
