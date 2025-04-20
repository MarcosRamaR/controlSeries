package com.series.controlseries.Repositories;

import com.series.controlseries.Entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Series,Long> {
}
