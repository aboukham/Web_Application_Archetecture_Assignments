package com.example.WAA_Assignment1.service.Impl;

import com.example.WAA_Assignment1.Dto.LogDto;
import com.example.WAA_Assignment1.domain.Log;
import com.example.WAA_Assignment1.repository.LogRepo;
import com.example.WAA_Assignment1.service.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImp implements LogService {
    @Autowired
    LogRepo logRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(LogDto log) {
        logRepo.save(modelMapper.map(log, Log.class));
    }
}
