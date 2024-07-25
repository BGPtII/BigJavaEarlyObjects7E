package bigjavaearlyobjectsexercisesprojects.chaptersixteen.programmingprojects.lisplist;

public class NonEmptyList implements LispList {

    private Object head;
    private LispList tail;

    public NonEmptyList(Object head, LispList tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        if (tail().empty()) {
            return head().toString();
        }
        return head() + " " + tail().toString();
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Object head() {
        return head;
    }

    @Override
    public LispList tail() {
        return tail;
    }

    @Override
    public LispList cons(Object x) {
        return new NonEmptyList(head, tail().cons(x));
    }

    @Override
    public int length() {
        return 1 + tail().length();
    }

    @Override
    public LispList merge(LispList other) {
        if (other.empty()) {
            return this;
        }
        return new NonEmptyList(head(), other.merge(tail));
    }

    @Override
    public boolean contains(Object obj) {
        if (head().equals(obj)) {
            return true;
        }
        return tail().contains(obj);
    }

}
