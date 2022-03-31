package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();

    String getPhoneNumber();

    String getEmail();

    Boolean getActive();
}
