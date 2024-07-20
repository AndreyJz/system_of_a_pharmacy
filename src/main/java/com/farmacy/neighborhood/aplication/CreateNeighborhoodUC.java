package com.farmacy.neighborhood.aplication;

import com.farmacy.neighborhood.domain.entity.Neighborhood;
import com.farmacy.neighborhood.domain.service.NeighborhoodService;

public class CreateNeighborhoodUC {
    private final NeighborhoodService neighborhoodService;

    public CreateNeighborhoodUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public void execute (Neighborhood neighborhood){
        neighborhoodService.createNeighborhood(neighborhood);
    }
}
