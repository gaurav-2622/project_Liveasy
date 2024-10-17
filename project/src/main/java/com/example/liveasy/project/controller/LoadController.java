package com.example.liveasy.project.controller;

import com.example.liveasy.project.entity.Load;
import com.example.liveasy.project.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/load")
@RestController
public class LoadController {

    @Autowired
    private LoadService loadService;


    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad) {
        Optional<Load> load = loadService.getLoadById(loadId);
        if (load.isPresent()) {
            updatedLoad.setLoadId(loadId);
            loadService.saveLoad(updatedLoad);
            return ResponseEntity.ok("Load updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        if (load.isPresent()) {
            loadService.deleteLoad(loadId);
            return ResponseEntity.ok("Load deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
