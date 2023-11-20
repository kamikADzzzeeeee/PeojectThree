package ru.yamshikov.rest.api.projectthree.util.mapper;

public interface Mapper <E extends AbstractEntity, D extends AbstractDto>{

    E toEntity(D dto);

    D toDto(E entity);
}
