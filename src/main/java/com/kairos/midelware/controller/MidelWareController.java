package com.kairos.midelware.controller;

import com.kairos.midelware.constants.ApiConstants;
import com.kairos.midelware.dto.ShowSearchResult;
import com.kairos.midelware.service.MidelWareService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MidelWareController {
    private final MidelWareService midelWareService;
    private final ApiConstants apiConstants;

    @GetMapping("/search")
    public ResponseEntity<List<ShowSearchResult>> search(@RequestParam("search_query") String query) {
      log.info(ApiConstants.log_start);
        List<ShowSearchResult> showsResults = midelWareService.searchShows(query);
        log.info(ApiConstants.log_final);
        return ResponseEntity.ok(showsResults);
    }
}
