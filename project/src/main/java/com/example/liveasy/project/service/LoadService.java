package com.example.liveasy.project.service;

import com.example.liveasy.project.entity.Load;
import com.example.liveasy.project.repository.LoadDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadDetailsRepository loadDetailsRepository;

    public Load saveLoad(Load load) {
        return loadDetailsRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadDetailsRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(UUID loadId) {
        return loadDetailsRepository.findById(loadId);
    }

    public void deleteLoad(UUID loadId) {
        loadDetailsRepository.deleteById(loadId);
    }
}
