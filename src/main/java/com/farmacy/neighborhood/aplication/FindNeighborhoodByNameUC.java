package com.farmacy.neighborhood.aplication;

import java.util.Optional;

import com.farmacy.neighborhood.domain.entity.Neighborhood;
import com.farmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodByNameUC {
    private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodByNameUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Optional<Neighborhood> execute(String name) {
        return neighborhoodService.findNeighborhoodByName(name);
    }
}
