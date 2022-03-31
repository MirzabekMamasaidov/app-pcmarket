package uz.pdp.apppcmarket.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();

    String getDescription();

    Boolean getActive();

    Double getPrice();

    @Value("#{target.attachment.id}")
    Integer getAttachmentId();


}
