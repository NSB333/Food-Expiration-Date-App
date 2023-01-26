import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food {
    public static void main(String[] args) throws Exception{
}

String getName(){
    String name = System.console().readLine("Enter item name: ");
    return name;
}

Date getExpireDate(){
    String sExpireDate = System.console().readLine("Enter expiration date (dd/mm/yy): ");
    Date expireDate = new Date();
    try {
        expireDate = new SimpleDateFormat("dd/MM/yy").parse(sExpireDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return expireDate;
}

Boolean isExpired(Date expireDate, String name) {
    Date cDate = new Date();
Boolean expire = false;
int c = cDate.compareTo(expireDate);
if (c >= 0) {
    expire = true;
}
return expire;
}

public Date expireDate;
public String foodName;
}
