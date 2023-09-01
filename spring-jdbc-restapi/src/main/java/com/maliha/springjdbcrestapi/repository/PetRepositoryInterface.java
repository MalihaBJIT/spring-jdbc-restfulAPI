package com.maliha.springjdbcrestapi.repository;


import com.maliha.springjdbcrestapi.model.PetStore;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryInterface {
    Optional<PetStore> getById(Integer id);

    List<PetStore> getAll();

    void add(PetStore petStore);
    boolean delete(Integer id);
}
