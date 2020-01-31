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

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.dto.HospedagemDTO;
import com.matheus.apiprojetolp2.dto.HospedagemResponseDTO;
import com.matheus.apiprojetolp2.services.HospedagemService;

@RestController
@RequestMapping(value = "/hospedagens")
public class HospedagemResource {

	@Autowired
	private HospedagemService hospedagemService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HospedagemResponseDTO>> findAll() {
		List<Hospedagem> hospedagens = hospedagemService.findAll();
		List<HospedagemResponseDTO> hospedagensResponseDTO = hospedagens.stream().map(x -> new HospedagemResponseDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(hospedagensResponseDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HospedagemDTO> findById(@PathVariable String id) {
		Hospedagem hospedagem = hospedagemService.findById(id);
		return ResponseEntity.ok().body(new HospedagemDTO(hospedagem));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody HospedagemDTO obj) {
		Hospedagem hospedagem = hospedagemService.fromDTO(obj);
		hospedagem = hospedagemService.insert(hospedagem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hospedagem.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody HospedagemDTO obj, @PathVariable String id) {
		Hospedagem newHospedagem = hospedagemService.fromDTO(obj);
		newHospedagem = hospedagemService.update(newHospedagem);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		hospedagemService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
