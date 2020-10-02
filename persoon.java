import java.time.LocalDate;
import java.time.Period;

public class persoon {
    //aanmaken van variabelen
    String name;
    String lastname;
    int datebirth;


    public static void main(String[] args) {
        //aanroepen van methodes
        persoon a = new persoon();

        a.getName();
        a.getLastname();
        a.agecalc();

    }

    //methodes met functies
    public void getName() {
        this.name = "Tomas";
        System.out.println(name);
        //return name;
    }

    public void getLastname() {
        this.lastname = "Ruiters";
        System.out.println(lastname);
        //return lastname;
    }

    public void agecalc() {
        LocalDate today = LocalDate.now();
        LocalDate birthdate = LocalDate.of(2003, 3, 16);
        int years = Period.between(birthdate, today).getYears();
        System.out.println(birthdate);
        System.out.println(today);
        System.out.println(years + " Jaar oud");

    }
}
