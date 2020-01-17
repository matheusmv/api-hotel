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
import com.matheus.apiprojetolp2.dto.EnderecoDTO;
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
		
		clienteRepository.deleteAll();
		quartoRespository.deleteAll();
		hospedagemRespository.deleteAll();

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

		Quarto num1 = new Quarto(null, 200.00, StatusDoQuarto.DISPONIVEL, new CategoriaDTO(TipoCategoria.MASTER));
		Quarto num2 = new Quarto(null, 150.00, StatusDoQuarto.OCUPADO, new CategoriaDTO(TipoCategoria.PADRAO));
		Quarto num3 = new Quarto(null, 300.00, StatusDoQuarto.RESERVADO,
				new CategoriaDTO(TipoCategoria.MASTER_SUPERTIOR));
		Quarto num4 = new Quarto(null, 175.00, StatusDoQuarto.MANUTENCAO, new CategoriaDTO(TipoCategoria.LUXO));

		quartoRespository.saveAll(Arrays.asList(num1, num2, num3, num4));
		
		Hospedagem h1 = new Hospedagem(null, sdf.parse("20/06/2019"),sdf.parse("27/06/2019"));
		Hospedagem h2 = new Hospedagem(null, sdf.parse("01/08/2019"),sdf.parse("17/08/2019"));
		Hospedagem h3 = new Hospedagem(null, sdf.parse("30/11/2019"),sdf.parse("07/12/2019"));
		
		hospedagemRespository.saveAll(Arrays.asList(h1, h2, h3));
		
		TarifaDTO t1 = new TarifaDTO(TipoServico.ALIMENTACAO, 40.00);
		TarifaDTO t2 = new TarifaDTO(TipoServico.ALIMENTACAO, 50.80);
		TarifaDTO t3 = new TarifaDTO(TipoServico.LIMPEZA, 120.00);

		h1.getTarifas().addAll(Arrays.asList(t1, t2, t3));
		
		hospedagemRespository.save(h1);
	}
}
