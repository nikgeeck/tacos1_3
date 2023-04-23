package com.controller;

import com.model.TacoOrder;
import com.model.User;
import com.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Slf4j //добавляет логирование (логер)
@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepository;
    private OrderProps props;

    public OrderController(OrderRepository orderRepository, OrderProps props) {
        this.orderRepository = orderRepository;
        this.props = props;
    }

    @GetMapping
    public String getOrder() {
        return "sosi";
    }

    @GetMapping("/current")
    public String showOrderForm() {
        return "order";
    }

    @GetMapping("/myOrders")
    public String getMyOrders(@AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("myOrders", orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));

        return "myOrders";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "order";
        }

        tacoOrder.setUser(user);

        orderRepository.save(tacoOrder);
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
