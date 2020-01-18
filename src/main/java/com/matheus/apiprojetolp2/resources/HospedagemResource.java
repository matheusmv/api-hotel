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

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.services.HospedagemService;

@RestController
@RequestMapping(value = "/hospedagens")
public class HospedagemResource {

	@Autowired
	private HospedagemService hospedagemService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hospedagem>> findAll() {
		List<Hospedagem> hospedagens = hospedagemService.findAll();
		return ResponseEntity.ok().body(hospedagens);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hospedagem> findById(@PathVariable String id) {
		Hospedagem hospedagem = hospedagemService.findById(id);
		return ResponseEntity.ok().body(hospedagem);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Hospedagem obj) {
		Hospedagem hospedagem = new Hospedagem(obj.getId(), obj.getDataCheckIn(), obj.getDataCheckOut(),
				obj.getCliente());
		hospedagem = hospedagemService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hospedagem.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Hospedagem obj, @PathVariable String id) {
		Hospedagem newHospedagem = new Hospedagem(id, obj.getDataCheckIn(), obj.getDataCheckOut(), obj.getCliente());
		newHospedagem = hospedagemService.update(newHospedagem);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		hospedagemService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
