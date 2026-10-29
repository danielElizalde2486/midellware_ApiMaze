package com.kairos.midelware.service;

import com.kairos.midelware.client.ImazeClient;
import com.kairos.midelware.constants.ApiConstants;
import com.kairos.midelware.dto.Show;
import com.kairos.midelware.dto.ShowSearchResult;
import com.kairos.midelware.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MidelWareService {
    private final ImazeClient imazeClient;
    private final ShowRepository showRepository;

    public List<ShowSearchResult> searchShows(String query){
        log.info(ApiConstants.log_start);
       List<ShowSearchResult> resultShows =  imazeClient.searchShows(query);
        log.info(ApiConstants.log_final);
       return resultShows;
    }

    public Show getShowById(Integer id){
        log.info(ApiConstants.log_start);
        Optional<Show> cachedShow = showRepository.findById(id);

        if (cachedShow.isPresent())
            return cachedShow.get();
        Show showresult = imazeClient.getShowById(id);

        if (showresult != null)
            showRepository.save(showresult);
        log.info(ApiConstants.log_final);
        return showresult;
    }
}
