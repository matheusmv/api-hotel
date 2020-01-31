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

	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return clienteRepository.save(newObj);
	}

	private void updateDate(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setCpf(obj.getCpf());
		newObj.setRg(obj.getRg());
		newObj.setEndereco(obj.getEndereco());
		newObj.setTelefone(obj.getTelefone());
	}

	public void delete(String id) {
		findById(id);
		clienteRepository.deleteById(id);
	}

	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(null, obj.getNome(), obj.getEmail(), obj.getSenha(), obj.getCpf(), obj.getRg(),
				obj.getEndereco(), obj.getTelefone());
	}
}
