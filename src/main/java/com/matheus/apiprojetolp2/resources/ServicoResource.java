package com.matheus.apiprojetolp2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.apiprojetolp2.domain.Servico;
import com.matheus.apiprojetolp2.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Servico>> findAll() {
		List<Servico> servicos = servicoService.findAll();
		return ResponseEntity.ok().body(servicos);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> findById(@PathVariable String id) {
		Servico servico = servicoService.findById(id);
		return ResponseEntity.ok().body(servico);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Servico obj) {
		Servico servico = obj;
		servico = servicoService.insert(servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable String id) {
		Servico servico = obj;
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
