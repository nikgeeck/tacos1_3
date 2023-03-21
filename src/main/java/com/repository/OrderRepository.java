package com.repository;

import com.model.TacoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
