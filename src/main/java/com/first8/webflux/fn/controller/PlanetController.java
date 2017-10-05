package com.first8.webflux.fn.controller;

import com.first8.webflux.fn.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class PlanetController {

    private PlanetRepository planetRepository;

    @RequestMapping(path={"/planets/{substring}","/planets"})
    public Flux<String> getMatchingPlanets(@PathVariable(name = "substring", required=false) Optional<String> substring) {
        return planetRepository.getPlanets()
                .filter( p -> p.toLowerCase().contains(substring.orElse("").toLowerCase()))
                .map( p -> p + "\n");
    }
}
