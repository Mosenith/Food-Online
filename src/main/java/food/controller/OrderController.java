package food.controller;

import food.domain.Order;
import food.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if(errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order Submitted: " + order);
        orderService.createOrder(order);

        return "redirect:/";
    }

//    @GetMapping("/test/{orderId}")
//    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
//        Order searchOrder = orderService.getOrderById(orderId);
//        if(searchOrder == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(searchOrder, HttpStatus.OK);
//    }
//
//    @PostMapping("/test")
//    public ResponseEntity<?> addOrder(@RequestBody Order order) {
//        Order createdOrder = orderService.createOrder(order);
//        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
//    }
}
