package com.farmacy.neighborhood.aplication;

import com.farmacy.neighborhood.domain.service.NeighborhoodService;

public class DeleteNeighborhoodUC {
    private final NeighborhoodService neighborhoodService;

    public DeleteNeighborhoodUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public void execute (int id) {
        neighborhoodService.deleteNeighborhood(id);
    }
}
