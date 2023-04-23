package com.repository;

import com.model.Taco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.ListCrudRepository;

public interface TacoRepository extends ListCrudRepository<Taco, Long> {
    Slice<Object> findAll(Pageable page);
}
