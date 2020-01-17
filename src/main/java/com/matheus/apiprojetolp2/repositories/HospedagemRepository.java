package com.matheus.apiprojetolp2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheus.apiprojetolp2.domain.Hospedagem;

@Repository
public interface HospedagemRepository extends MongoRepository<Hospedagem, String> {

}
