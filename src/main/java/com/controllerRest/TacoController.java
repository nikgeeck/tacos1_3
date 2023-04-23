package com.controllerRest;

import com.model.Taco;
import com.model.TacoOrder;
import com.repository.OrderRepository;
import com.repository.TacoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "http://tacocloud:8087")
public class TacoController {
    private TacoRepository tacoRep;
    private OrderRepository orderRepository;

    public TacoController(TacoRepository tacosRep, OrderRepository orderRepository) {
        this.tacoRep = tacosRep;
        this.orderRepository = orderRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Object> recentTaco() {
        Pageable page = PageRequest.of(0, 12, Sort.by("createdAt").descending());

        return tacoRep.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRep.findById(id);

        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {

        return tacoRep.save(taco);
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long id, @RequestBody TacoOrder order) {
        order.setId(id);

        return orderRepository.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long id, @RequestBody TacoOrder patch) {
        TacoOrder order = orderRepository.findById(id).get();
        if (patch.getDeliveryName() != null) order.setDeliveryName(patch.getDeliveryName());
        if (patch.getDeliveryStreet() != null) order.setDeliveryStreet(patch.getDeliveryName());
        if (patch.getDeliveryCity() != null) order.setDeliveryCity(patch.getDeliveryName());
        if (patch.getDeliveryState() != null) order.setDeliveryState(patch.getDeliveryName());
        if (patch.getDeliveryZip() != null) order.setDeliveryZip(patch.getDeliveryName());
        if (patch.getCcNumber() != null) order.setCcNumber(patch.getDeliveryName());
        if (patch.getCcCVV() != null) order.setCcCVV(patch.getDeliveryName());
        if (patch.getCcExpiration() != null) order.setCcExpiration(patch.getDeliveryName());

        return orderRepository.save(order);
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {

        }
    }
}
