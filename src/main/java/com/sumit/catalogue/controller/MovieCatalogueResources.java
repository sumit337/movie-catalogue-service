package com.sumit.catalogue.controller;

import com.sumit.catalogue.constants.MovieRating;
import com.sumit.catalogue.model.Catalogue;
import com.sumit.catalogue.model.MovieInfo;
import com.sumit.catalogue.model.Ratings;
import com.sumit.catalogue.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogues")
public class MovieCatalogueResources {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<Catalogue> getCatalogue(@PathVariable String userId){

       UserRatings ratings = restTemplate.getForObject("http://localhost:8282/ratings/user/"+userId,UserRatings.class);
        return ratings.getRatings().stream().map(
                rating -> {
               //  MovieInfo movieInfo= restTemplate.getForObject("http://localhost:8181/movies/"+rating.getMovieId(), MovieInfo.class);
                    MovieInfo movieInfo = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8181/movies/"+rating.getMovieId())
                            .retrieve()
                            .bodyToMono(MovieInfo.class)
                            .block();
                    return new Catalogue(movieInfo.getMovieName(),"Movie About ALien robots", MovieRating.BEST);
                }).collect(Collectors.toList());
    }
}
