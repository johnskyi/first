import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey key;
    @Column(name = "student_id",insertable = false,updatable = false)
    private int studentId;

    @Column(name = "course_id",insertable = false,updatable = false)
    private int courseId;

    @Data
    @Embeddable
    public static class  LinkedPurchaseListKey implements Serializable {

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;
    }
}
