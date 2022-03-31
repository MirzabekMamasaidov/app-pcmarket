package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Brand;

@Projection(types = Brand.class)
public interface CustomBrand {
    Integer getId();

    String getName();


}
