package br.ufu.succotash.controller.order;

import br.ufu.succotash.controller.order.request.OrderRequest;
import br.ufu.succotash.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Transactional
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> newOrder(@Valid @RequestBody OrderRequest orderItem) {
        String orderId = orderService.newOrder(orderItem);
        URI location = URI.create("/api/v1/order/".concat(orderId));
        return ResponseEntity.ok().location(location).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.findOrder(orderId));
    }

    @PostMapping("/{orderId}/pay")
    public ResponseEntity<?> payOrder(@PathVariable String orderId) {
        orderService.payOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
