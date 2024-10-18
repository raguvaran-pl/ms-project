package com.project.microservices.order.dto;

import java.math.BigDecimal;

public record OrderResponse(Long id, String orderNumber, BigDecimal price) {
}
