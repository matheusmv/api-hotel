package com.matheus.apiprojetolp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.repositories.QuartoRepository;
import com.matheus.apiprojetolp2.services.exception.ObjectNotFoundException;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository quartoRepository;

	public List<Quarto> findAll() {
		return quartoRepository.findAll();
	}

	public Quarto findById(String id) {
		Optional<Quarto> quarto = quartoRepository.findById(id);
		return quarto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Quarto insert(Quarto obj) {
		return quartoRepository.insert(obj);
	}

	public Quarto update(Quarto obj) {
		Quarto newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return quartoRepository.save(newObj);
	}

	private void updateDate(Quarto newObj, Quarto obj) {
		newObj.setCategoria(obj.getCategoria());
		newObj.setStatus(obj.getStatus());
		newObj.setCusto(obj.getCusto());
	}

	public void delete(String id) {
		findById(id);
		quartoRepository.deleteById(id);
	}
}
