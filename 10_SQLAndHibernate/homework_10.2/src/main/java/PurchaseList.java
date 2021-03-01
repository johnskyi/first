

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey purchaseListKey;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Data
    @Embeddable
    public static class PurchaseListKey implements Serializable{

        @Column(name = "student_name")
        private String studentName;

        @Column(name = "course_name")
        private String courseName;

    }
}

