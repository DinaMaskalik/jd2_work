package it.academy.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ProductSpecPrice implements Serializable {


    private long id;
    private float productSpecPrice;
    private Date priceStartDate;
    private Date priceEndDate;
    private int productSpecId;

    public ProductSpecPrice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getProductSpecPrice() {
        return productSpecPrice;
    }

    public void setProductSpecPrice(float productSpecPrice) {
        this.productSpecPrice = productSpecPrice;
    }

    public Date getPriceStartDate() {
        return priceStartDate;
    }

    public void setPriceStartDate(Date priceStartDate) {
        this.priceStartDate = priceStartDate;
    }

    public Date getPriceEndDate() {
        return priceEndDate;
    }

    public void setPriceEndDate(Date priceEndDate) {
        this.priceEndDate = priceEndDate;
    }

    public int getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(int productSpecId) {
        this.productSpecId = productSpecId;
    }

    @Override
    public String toString() {
        return "ProductSpecPrice{" +
                "id=" + id +
                ", productSpecPrice=" + productSpecPrice +
                ", priceStartDate=" + priceStartDate +
                ", priceEndDate=" + priceEndDate +
                ", productSpecId=" + productSpecId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSpecPrice that = (ProductSpecPrice) o;
        return id == that.id &&
                Float.compare(that.productSpecPrice, productSpecPrice) == 0 &&
                productSpecId == that.productSpecId &&
                Objects.equals(priceStartDate, that.priceStartDate) &&
                Objects.equals(priceEndDate, that.priceEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productSpecPrice, priceStartDate, priceEndDate, productSpecId);
    }
}
