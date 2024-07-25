package bigjavaearlyobjectsexercisesprojects.chapterten.programmingprojects.numberformatter;

public class BaseFormatter implements NumberFormatter {

    private int base;

    public BaseFormatter(int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("base must be between 2 & 36 inclusive.");
        }
        this.base = base;
    }

    @Override
    public String format(int integer) {
        return Integer.toString(integer, base);
    }
}
