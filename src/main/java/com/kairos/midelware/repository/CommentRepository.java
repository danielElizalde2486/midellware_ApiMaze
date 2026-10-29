package com.kairos.midelware.repository;

import com.kairos.midelware.dto.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
