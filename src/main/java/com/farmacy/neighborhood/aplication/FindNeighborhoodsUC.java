package com.farmacy.neighborhood.aplication;

import java.util.List;

import com.farmacy.neighborhood.domain.entity.Neighborhood;
import com.farmacy.neighborhood.domain.service.NeighborhoodService;

public class FindNeighborhoodsUC {
    private final NeighborhoodService neighborhoodService;

    public FindNeighborhoodsUC(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public List<Neighborhood> execute(){
        return neighborhoodService.findAllNeighborhoods();
    }
}
