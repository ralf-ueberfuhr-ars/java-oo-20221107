public class Mitarbeiter {

    String name;
    int alter;
    double gehalt;
    Konto konto;

    boolean heißtWie(Mitarbeiter ma) {
//        if(ma != null && this.name != null) {
//            return this.name.equals(ma.name);
//        } else {
//            return false;
//        }
        return ma != null && this.name != null
          && this.name.equals(ma.name);
    }

}
