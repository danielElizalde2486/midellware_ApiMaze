package com.kairos.midelware.controller;

import com.kairos.midelware.constants.ApiConstants;
import com.kairos.midelware.dto.Comment;
import com.kairos.midelware.dto.CommentRequest;
import com.kairos.midelware.dto.Show;
import com.kairos.midelware.dto.ShowSearchResult;
import com.kairos.midelware.repository.ShowRepository;
import com.kairos.midelware.service.MidelWareService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MidelWareController {
    private final MidelWareService midelWareService;
    private final ApiConstants apiConstants;


    @Operation(summary = "Busqueda por medio de query")
    @GetMapping("/search")
    public ResponseEntity<List<ShowSearchResult>> search(@RequestParam("query") String query) {
      log.info(ApiConstants.log_start);
        List<ShowSearchResult> showsResults = midelWareService.searchShows(query);
        log.info(ApiConstants.log_final);
        return ResponseEntity.ok(showsResults);
    }
    @Operation(summary = "Busqueda por medio de id")
    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShow(@PathVariable("id") Integer id) {
        log.info(ApiConstants.log_start);
        Show showCacheResult =  midelWareService.getShowById(id);
        log.info(ApiConstants.log_final);
        return ResponseEntity.ok(showCacheResult);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentRequest request) {
        Comment savedComment = midelWareService.saveComment(
                request.getShowId(),
                request.getComment(),
                request.getRating()
        );
        return ResponseEntity.ok(savedComment);
    }
}
