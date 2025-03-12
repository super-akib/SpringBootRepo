package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.CricketPlayer;
@Repository
public interface CricketPlayerRepository  extends CrudRepository<CricketPlayer, Long>
{
    
}
