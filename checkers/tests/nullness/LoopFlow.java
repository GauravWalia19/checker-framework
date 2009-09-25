import checkers.nullness.quals.*;

public class LoopFlow {
    void simpleWhileLoop() {
        String s = "m";

        while (s != null) {
            s.toString();
            s = null;
        }
        s.toString();   // error
    }

    void whileConditionError() {
        String s = "m";

        while (s.toString() == "m") {  // error
            s.toString();
            s = null;
        }
        s.toString();
    }

    void simpleForLoop() {
        for (String s = "m"; s != null; s = null) {
            s.toString();
        }
    }

    void forLoopConditionError() {
        for (String s = "m";
             s.toString() != "m";   // error
             s = null) {
            s.toString();
        }
    }

    class Link {
        Object val;
        @Nullable Link next;
    }

    // Both dereferences of l should succeed
    void test(@Nullable Link in) {
        for (@Nullable Link l=in; l!=null; l=l.next) {
            Object o;
            o = l.val;
        }
    }

    void multipleRuns() {
        String s = "m";
        while (true) {
            s.toString();   // error
            s = null;
        }
    }

    void multipleRunsDo() {
        String s = "m";
        do {
            s.toString();   // error
            s = null;
        } while (true);
    }

    void alwaysRunForLoop() {
        String s = "m";
        for (s = null; s != null; s = "m") {
            s.toString();   // ok
        }
        s.toString();   // error
    }

    public void badIterator () {
        Class<?> opt_doc1 = null;
        opt_doc1.getInterfaces();
        Class<?> opt_doc2 = null;
        for (Class<?> fd : opt_doc2.getInterfaces()) {
            // empty loop body
        }
    }

    void testContinue(@Nullable Object o) {
        for (;;) {
            o.toString();
            if (true) continue;
        }
    }

    void testBreak(@Nullable Object o) {
        while (true) {
            o.toString();
            if (true) break;
        }
    }

    void testSimpleNull() {
        String r1 = null;
        while (r1 != null);
        r1.toString();  // error
    }

    void testMulticheckNull() {
        String r1 = null;
        while (r1 != null && r1.equals("m"));
        r1.toString();  // error
    }

    void testAssignInLoopSimple() {
        String r1 = "";
        while (r1 != null) {
            r1 = null;
        }
        r1.toString();  // error
    }

    void testAssignInLoopMulti() {
        String r1 = "";
        while (r1 != null && r1.isEmpty()) {
            r1 = null;
        }
        r1.toString();  // error
    }

}
