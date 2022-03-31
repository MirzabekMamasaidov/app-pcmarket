package uz.pdp.apppcmarket.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    String getDescription();

    String getCode();

    Double getPrice();

    @Value(value = "#{target.currency.name}")
    String getCurrencyName();

    @Value(value = "#{target.category.name}")
    String getCategoryName();

    @Value("#{target.brand.name}")
    String getBrandName();

}
