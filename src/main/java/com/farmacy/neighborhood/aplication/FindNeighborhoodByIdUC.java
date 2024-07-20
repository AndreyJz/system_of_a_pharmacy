package com.farmacy.neighborhood.aplication;

import java.util.Optional;

import com.farmacy.neighborhood.domain.entity.Neighborhood;
import com.farmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodByIdUC {
    private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodByIdUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Optional<Neighborhood> execute(int id){
        return neighborhoodService.findNeighborhoodById(id);
    }
}
