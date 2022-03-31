package uz.pdp.apppcmarket.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Order;
import uz.pdp.apppcmarket.entity.Product;

import java.util.List;

@Projection(types = Order.class)
public interface CustomOrder {

    Integer getId();

    String getCode();

    Integer getAmount();

    @Value("#{target.product}")
    List<CustomProduct> getProduct();

    /*@Value("#{target.product}")
    List<CustomProduct> getProduct();
*/

}
