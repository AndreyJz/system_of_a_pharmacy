package com.farmacy.neighborhood.aplication;

import com.farmacy.neighborhood.domain.service.NeighborhoodService;
import com.farmacy.neighborhood.domain.entity.Neighborhood;

public class UpdateNeighborhoodUC {
    private final NeighborhoodService neighborhoodService;

    public UpdateNeighborhoodUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public void execute (Neighborhood neighborhood) {
        neighborhoodService.updateNeighborhood(neighborhood);
    }
}
