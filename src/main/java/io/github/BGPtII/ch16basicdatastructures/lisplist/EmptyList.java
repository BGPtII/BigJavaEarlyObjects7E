package bigjavaearlyobjectsexercisesprojects.chaptersixteen.programmingprojects.lisplist;

public class EmptyList implements LispList {

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Object head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LispList tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LispList cons(Object x) {
        return new NonEmptyList(x, this);
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public LispList merge(LispList other) {
        return other;
    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

}
