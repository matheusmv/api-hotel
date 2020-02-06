package com.matheus.apiprojetolp2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.apiprojetolp2.domain.Servico;
import com.matheus.apiprojetolp2.dto.ServicoDTO;
import com.matheus.apiprojetolp2.dto.ServicoResponseDTO;
import com.matheus.apiprojetolp2.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ServicoResponseDTO>> findAll() {
		List<Servico> servicos = servicoService.findAll();
		List<ServicoResponseDTO> servicosResponseDTO = servicos.stream().map(s -> new ServicoResponseDTO(s))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(servicosResponseDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ServicoDTO> findById(@PathVariable String id) {
		Servico servico = servicoService.findById(id);
		return ResponseEntity.ok().body(new ServicoDTO(servico));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ServicoDTO obj) {
		Servico servico = servicoService.fromDTO(obj);
		servico = servicoService.insert(servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ServicoDTO obj, @PathVariable String id) {
		Servico servico = servicoService.fromDTO(obj);
		servico.setId(id);
		servico = servicoService.update(servico);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
