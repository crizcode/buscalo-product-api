package com.empresa.buscaloproductapi.mapper;

public interface IMapper <I, O> {
    O map(I in);
}
