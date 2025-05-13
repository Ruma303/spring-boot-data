package com.example.demo.models.embedded;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_orders")
public class Order implements Serializable {

    @EmbeddedId
    private OrderId id;

    private String orderInfo;
}
