import java.util.Arrays;
import java.util.Scanner;

//String.valueOf(persoonauto).equals(input)
//moet er voor zorgen min mogelijk typen dus moet meerdere kunnen van personenauto en werkauto moet allebij in zelde methodes kunnen
public class wegenbelasting {

    String type[] = {"personenauto", "werkauto"};
    String electric = "elektrisch";
    String waterstof = "waterstof";
    String diesel = "diesel";
    String benzine = "benzine";


    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        wegenbelasting auto = new wegenbelasting();
        auto.personenauto();

    }

    public void personenauto() {
        wegenbelasting auto = new wegenbelasting();
        System.out.println("personenauto of werkauto");
        Scanner obj = new Scanner(System.in);
        String input = obj.nextLine();
        if (Arrays.stream(type).anyMatch(input::equals)) {
            auto.belastingpersoon(input);
        } else {
            System.out.println("U hebt niet duidelijk aangegeven.");
            System.exit(0);
        }
    }

    public void belastingpersoon(String input) {
        wegenbelasting auto = new wegenbelasting();

        System.out.println("Rijdt u " + input + " op benzine, diesel, waterstof of elektrisch");
        Scanner obj = new Scanner(System.in);
        String type = obj.nextLine();
        if (String.valueOf(electric).equals(type)) {
            System.out.println("U hoeft geen wegenbelasting te betalen.");
            System.exit(0);
        } else if (String.valueOf(waterstof).equals(type)) {
            System.out.println("U hoeft geen wegenbelasting te betalen.");
            System.exit(0);
        } else if (String.valueOf(diesel).equals(type)) {
            auto.dieselpersoon(input, type);
        } else if (String.valueOf(benzine).equals(type)) {
            auto.benzinepersoon(input, type);
        }

    }

    public void dieselpersoon(String input, String type) {
        System.out.println("Wat is de gewicht van u " + input);
        Scanner obj = new Scanner(System.in);
        String gewicht = obj.nextLine();
        int kilos = Integer.parseInt(gewicht);
        if (String.valueOf(type).equals(diesel) && (kilos >= 1000) && (input.equals("werkauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€145.");
        } else if (String.valueOf(type).equals(diesel) && (kilos < 1000) && (input.equals("werkauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€50.");
        } else if (String.valueOf(type).equals(diesel) && (kilos >= 1000) && (input.equals("personenauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€710.");
        } else if (String.valueOf(type).equals(diesel) && (kilos < 1000) && (input.equals("personenauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€450.");
        } else {
            System.out.println("U hebt niet duidelijk aangegeven.");
            System.exit(0);
        }
    }

    public void benzinepersoon(String input, String type) {
        System.out.println("Wat is de gewicht van u " + input);
        Scanner obj = new Scanner(System.in);
        String gewicht = obj.nextLine();
        int kilos = Integer.parseInt(gewicht);
        if (String.valueOf(type).equals(benzine) && (kilos >= 1000) && (input.equals("werkauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€145.");
        } else if (String.valueOf(type).equals(benzine) && (kilos < 1000) && (input.equals("werkauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€76.");
        } else if (String.valueOf(type).equals(benzine) && (kilos >= 1000) && (input.equals("personenauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€352.");
        } else if (String.valueOf(type).equals(benzine) && (kilos < 1000) && (input.equals("personenauto"))) {
            System.out.println("Belasting per tijdvak van 3 maanden:€107.");
        } else {
            System.out.println("U hebt niet duidelijk aangegeven.");
            System.exit(0);
        }
    }
}
