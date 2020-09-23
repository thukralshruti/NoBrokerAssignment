import lombok.Getter;
import lombok.Setter;

@Getter
public class PropertyTestData {

    String city;
    String area1;
    String area2;
    String bedroom1;
    String bedroom2;
    String correctConfig;
    String note;
    int propertyIndex;


    public PropertyTestData(String city, String area1, String area2, String bedroom1, String bedroom2, String correctConfig, String note, int index) {
        this.city = city;
        this.area1 = area1;
        this.area2 = area2;
        this.bedroom1 = bedroom1;
        this.bedroom2 = bedroom2;
        this.correctConfig = correctConfig;
        this.note = note;
        this.propertyIndex = index;
    }

}
