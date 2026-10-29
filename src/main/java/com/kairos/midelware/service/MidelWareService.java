package com.kairos.midelware.service;

import com.kairos.midelware.client.ImazeClient;
import com.kairos.midelware.constants.ApiConstants;
import com.kairos.midelware.dto.Comment;
import com.kairos.midelware.dto.CommentsPerformance;
import com.kairos.midelware.dto.Show;
import com.kairos.midelware.dto.ShowSearchResult;
import com.kairos.midelware.repository.CommentRepository;
import com.kairos.midelware.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MidelWareService {
    private final ImazeClient imazeClient;
    private final ShowRepository showRepository;
    private final CommentRepository commentRepository;

    public List<ShowSearchResult> searchShows(String query){
        log.info(ApiConstants.log_start);
       List<ShowSearchResult> resultShows =  imazeClient.searchShows(query);
        for (ShowSearchResult result : resultShows) {
            Show show = result.getShow();
            Long showId = ((Number) show.getId()).longValue();
            show.setComments(convertTypeComments(show.getId().longValue()));
        }
        log.info(ApiConstants.log_final);
       return resultShows;
    }

    public Show getShowById(Integer id){
        log.info(ApiConstants.log_start);
        Optional<Show> cachedShow = showRepository.findById(id);

        if (cachedShow.isPresent()) {
           Show show =  cachedShow.get();
           show.setComments(convertTypeComments(Long.parseLong(id.toString())));
            return show;
        }
        Show showresult = imazeClient.getShowById(id);

        if (showresult != null)
            showRepository.save(showresult);

        showresult.setComments(convertTypeComments(Long.parseLong(id.toString())));
        log.info(ApiConstants.log_final);
        return showresult;
    }

    public Comment saveComment(Long showId, String commentText, Integer rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 5");
        }
        Comment comment = new Comment();
        comment.setShowId(showId);
        comment.setComment(commentText);
        comment.setRating(rating);
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    private List<CommentsPerformance> convertTypeComments(Long id ){
        List<Comment> lstcomments = commentRepository.findByShowId(id);
        List<CommentsPerformance> lstcommentsPerformances = new ArrayList<>();
        for(Comment comment : lstcomments){
            lstcommentsPerformances.add(CommentsPerformance.builder().comment(comment.getComment()).rating(comment.getRating()).build());
        }
        return lstcommentsPerformances;
    }
}
