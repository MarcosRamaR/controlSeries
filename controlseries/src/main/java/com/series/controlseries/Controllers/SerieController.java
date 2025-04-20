package com.series.controlseries.Controllers;


import com.series.controlseries.Entities.Series;
import com.series.controlseries.Repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {


    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public List<Series> getAllSeries(){
        return serieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Series getSerieById(@PathVariable Long id){
        return serieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serie with ID: "+ id + " dont found"));
    }

    @PostMapping
    public Series createSerie(@RequestBody Series serie){
        return serieRepository.save(serie);
    }

    @PutMapping("/{id}")
    public Series updateSerie(@PathVariable Long id, @RequestBody Series serieDetails){
        Series serie = serieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serie with ID: "+ id + " dont found"));
        serie.setName(serieDetails.getName());
        serie.setGenre(serieDetails.getGenre());
        serie.setDescription(serieDetails.getDescription());
        serie.setPoints(serieDetails.getPoints());
        return serieRepository.save(serie);
    }

    @DeleteMapping("/{id}")
    public String  deleteSerie(@PathVariable Long id){
        Series serie = serieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serie with ID: "+ id + " dont found"));
        serieRepository.delete(serie);
        return "Serie with ID: "+ id + " was deleted";
    }



}
