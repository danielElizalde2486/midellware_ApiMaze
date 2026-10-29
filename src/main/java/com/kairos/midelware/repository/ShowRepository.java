package com.kairos.midelware.repository;

import com.kairos.midelware.dto.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, Integer> {
}
