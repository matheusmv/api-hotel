package com.matheus.apiprojetolp2.resources;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.dto.ClienteDTO;
import com.matheus.apiprojetolp2.dto.ClienteSimplesDTO;
import com.matheus.apiprojetolp2.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteSimplesDTO>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		List<ClienteSimplesDTO> clientesDTO = clientes.stream().map(x -> new ClienteSimplesDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(clientesDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> findById(@PathVariable String id) {
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(cliente));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
		Cliente cliente = obj;
		cliente = clienteService.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable String id) {
		Cliente cliente = obj;
		cliente.setId(id);
		cliente = clienteService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/hospedagens", method = RequestMethod.GET)
	public ResponseEntity<Set<Hospedagem>> findHospedagens(@PathVariable String id) {
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj.getHospedagens());
	}
}
