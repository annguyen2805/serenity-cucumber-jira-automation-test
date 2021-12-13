package starter.booking;

import net.serenitybdd.screenplay.targets.Target;

public class BookingPage {

    public static Target LABLE_TEN_GIAN_HANG = Target.the("Label tên gian hàng")
            .locatedBy("//input[@id='Retailer']//preceding-sibling::label");

    public static Target LABLE_USER_NAME = Target.the("Label user name")
            .locatedBy("//input[@id='UserName']//preceding-sibling::label");

    public static Target LABLE_PASSWORD = Target.the("Label password")
            .locatedBy("//input[@id='Password']//parent::div/preceding-sibling::label");

}
