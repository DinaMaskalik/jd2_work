package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "T_PRODUCT")
@NoArgsConstructor
public class Product {

    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Id
    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "P_PRODUCT_NAME")
    private String productName;

    @Column(name = "P_PRODUCT_DESC")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrice;

}
