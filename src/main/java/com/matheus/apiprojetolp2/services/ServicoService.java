package com.matheus.apiprojetolp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.apiprojetolp2.domain.Servico;
import com.matheus.apiprojetolp2.repositories.ServicoRepository;
import com.matheus.apiprojetolp2.services.exception.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public List<Servico> findAll() {
		return servicoRepository.findAll();
	}

	public Servico findById(String id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		return servico.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Servico insert(Servico obj) {
		return servicoRepository.insert(obj);
	}

	public Servico update(Servico obj) {
		Servico newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return servicoRepository.save(newObj);
	}

	private void updateDate(Servico newObj, Servico obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setCusto(obj.getCusto());
	}

	public void delete(String id) {
		findById(id);
		servicoRepository.deleteById(id);
	}
}
