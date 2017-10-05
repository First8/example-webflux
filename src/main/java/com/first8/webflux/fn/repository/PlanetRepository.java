package com.first8.webflux.fn.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class PlanetRepository {

    public Flux<String> getPlanets() {
        return Flux.fromArray( new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn","Uranus", "Neptune"});
    }

}
