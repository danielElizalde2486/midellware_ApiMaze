package com.kairos.midelware.client;


import com.kairos.midelware.dto.ShowSearchResult;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${api.tvmaze.name}", url = "${api.tvmaze.url}")
public interface ImazeClient {
    @GetMapping(value = "/search/shows")
    List<ShowSearchResult> searchShows(@RequestParam(value = "q") String query);
}
