package com.docestate.immobilienservice.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.docestate.immobilienservice.model.Immobilie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ImmobilienRepository extends CrudRepository<Immobilie, Integer> {
    
    public List<Immobilie> findAll();
    public Optional<Immobilie> findById(Integer id);
    
}
