package it.academy.service;

import it.academy.model.ResultDto;
import it.academy.model.ResultItemDto;
import it.academy.model.SearchDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchProcessor {

    public static final Integer DEFLTE_LINK_DEPTH = 8;
    public static final Integer MAX_VISITED_PAGE_LIMIT = 10_000;
    HttpLoader httpLoader = new HttpLoader();

    public ResultDto search(SearchDto searchDto) {
        // Load string content by search URL
        String content = httpLoader.get(searchDto.getSeed());
        String url= searchDto.getSeed();

        //TODO: Parse string and count terms and find other URLs, calculate deep level
        ResultDto resultDto = new ResultDto();

        //TODO: Repeat parse to max 8 level
        resultDto.getResultItemDtoList().add(parse(url,content, searchDto.getTerms()));
        return resultDto;
    }

    private ResultItemDto parse(String url, String s, List<String> terms) {
        String content = s.toLowerCase();

        ResultItemDto resultItemDto = new ResultItemDto();
        resultItemDto.setSearchUrl(url);

        for (String term : terms) {
            Pattern pattern = Pattern.compile(term);
            Matcher matcher = pattern.matcher(content);
            int count=0;
            while (matcher.find()){
                count++;
            }
            resultItemDto.getTermsCountMap().put(term, count);
        }

        return resultItemDto;
    }
}
