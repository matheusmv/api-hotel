package com.matheus.apiprojetolp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.dto.ClienteDTO;
import com.matheus.apiprojetolp2.repositories.ClienteRepository;
import com.matheus.apiprojetolp2.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Cliente insert(Cliente obj) {
		return clienteRepository.insert(obj);
	}

	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj.getId(), obj.getNome(), obj.getEmail(), obj.getCpf(), obj.getRg(), obj.getEndereco(),
				obj.getTelefone());
	}
}
