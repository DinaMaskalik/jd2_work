package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class ProductPrice {

    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Id
    private String priseId;

    private BigDecimal priceValue;

    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}

enum Currency{
    BYN, EUR, USD
}
