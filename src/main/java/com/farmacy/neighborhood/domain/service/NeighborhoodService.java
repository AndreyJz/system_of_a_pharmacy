package com.farmacy.neighborhood.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.neighborhood.domain.entity.Neighborhood;

public interface NeighborhoodService {
    void createNeighborhood(Neighborhood neighborhood);
    void updateNeighborhood(Neighborhood neighborhood);
    Neighborhood deleteNeighborhood(int id);
    Optional<Neighborhood> findNeighborhoodById(int id);
    List<Neighborhood> findAllNeighborhoods();
    Optional<Neighborhood> findNeighborhoodByName(String name);
}
