import userIdentification.UserIdentification;
import userIdentificationService.UserIdentificationService;

public class Main {
    public static void main(String[] args) {
        UserIdentificationService user = new UserIdentificationService(
                "ASx33xc99__09_ds_AS",
                "00__as9SFF__sd98",
                "000__as9SFF__sd98");
        System.out.println(UserIdentificationService.userIdentificationCheck(user));
    }
}