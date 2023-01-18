package com.example.WAA_Assignment1.service.Adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListAdapter<T, E> {
    @Autowired
    ModelMapper modelMapper;
    public List<?> mapToList(List<T> list, E toClass){
        return list.stream().map(e -> modelMapper.map(e, toClass.getClass()))
                .collect(Collectors.toList());
    }
}
