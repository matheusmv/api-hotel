package com.matheus.apiprojetolp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.dto.HospedagemDTO;
import com.matheus.apiprojetolp2.repositories.HospedagemRepository;
import com.matheus.apiprojetolp2.services.exception.ObjectNotFoundException;

@Service
public class HospedagemService {

	@Autowired
	private HospedagemRepository hospedagemRespository;

	public List<Hospedagem> findAll() {
		return hospedagemRespository.findAll();
	}

	public Hospedagem findById(String id) {
		Optional<Hospedagem> hospedagem = hospedagemRespository.findById(id);
		return hospedagem.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Hospedagem insert(Hospedagem obj) {
		return hospedagemRespository.insert(obj);
	}

	public Hospedagem update(Hospedagem obj) {
		Hospedagem newHospedagem = findById(obj.getId());
		updateDate(newHospedagem, obj);
		return hospedagemRespository.save(newHospedagem);
	}

	private void updateDate(Hospedagem newObj, Hospedagem obj) {
		newObj.setDataCheckIn(obj.getDataCheckIn());
		newObj.setDataCheckOut(obj.getDataCheckOut());
	}

	public void delete(String id) {
		findById(id);
		hospedagemRespository.deleteById(id);
	}

	public Hospedagem fromDTO(HospedagemDTO obj) {
		return new Hospedagem(null, obj.getIdCliente(), obj.getDataCheckIn(), obj.getDataCheckOut());
	}
}
