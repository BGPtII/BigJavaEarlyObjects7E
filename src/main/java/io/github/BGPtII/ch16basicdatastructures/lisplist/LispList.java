package bigjavaearlyobjectsexercisesprojects.chaptersixteen.programmingprojects.lisplist;

/**
 * Implements a list as the LISP language implements it
 */
public interface LispList {

    EmptyList NIL = new EmptyList();

    boolean empty();
    Object head();
    LispList tail();
    LispList cons(Object obj);
    int length();
    LispList merge(LispList other);
    boolean contains(Object obj);

}
