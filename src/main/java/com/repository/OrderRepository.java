package com.repository;

import com.model.TacoOrder;
import com.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
//    TacoOrder save(TacoOrder order);

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
