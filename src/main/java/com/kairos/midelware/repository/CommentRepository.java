package com.kairos.midelware.repository;

import com.kairos.midelware.dto.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByShowId(Long showId);
}
