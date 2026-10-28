package com.kairos.midelware.service;

import com.kairos.midelware.client.ImazeClient;
import com.kairos.midelware.dto.ShowSearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MidelWareService {
    private final ImazeClient imazeClient;

    public List<ShowSearchResult> searchShows(String query){
       List<ShowSearchResult> resultShows =  imazeClient.searchShows(query);
       return resultShows;
    }
}
