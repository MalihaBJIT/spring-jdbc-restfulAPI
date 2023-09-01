package com.maliha.springjdbcrestapi.repository;

import com.maliha.springjdbcrestapi.model.PetStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PetRepository implements PetRepositoryInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<PetStore> getById(Integer id){
        String query = "select * from pet_info where pet_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                Optional.of(
                        new PetStore(
                                resultSet.getString("pet_name"),
                                resultSet.getInt("pet_id"),
                                resultSet.getInt("pet_availability"),
                                resultSet.getString("type")
                        )
                )
        );
    }
    @Override
    public List<PetStore> getAll(){
        String query = "select * from pet_info";
        return jdbcTemplate
                .query(query, (resultSet, rowNum) ->
                        new PetStore(
                                resultSet.getString("pet_name"),
                                resultSet.getInt("pet_id"),
                                resultSet.getInt("pet_availability"),
                                resultSet.getString("type")
                        )
                );
    }
    @Override
    public void add(PetStore petStore){
        String query = "insert into pet_info (pet_name, pet_id, pet_availability, type) values (?, ?, ?, ?)";
        jdbcTemplate.update(query, petStore.getName(),  petStore.getId(),petStore.getAvailability(),petStore.getType());

    }
    @Override
    public boolean delete(Integer id){
        if(id!=null) {
//            String queryID = "select pet_id from pet_info where pet_id = ?";
//            Optional<Integer> idFetched=jdbcTemplate.queryForObject(queryID, new Object[]{id}, (resultSet, rowNum) ->
//                    Optional.of(
//                            new PetStore(resultSet.getInt("pet_id")).getId()
//                            )
//                    );
            String query = "delete from pet_info where pet_id = ?";
            jdbcTemplate.update(query, id);
            return true;
        }
        return false;
    }


}
