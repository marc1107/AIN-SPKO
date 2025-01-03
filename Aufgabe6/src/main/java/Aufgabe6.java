import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.*;

public class Aufgabe6 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Bitte geben Sie mindestens eine Klasse oder ein Interface an.");
            return;
        }

        List<Class<?>> classList = new ArrayList<>();

        try {
            for (String className : args) {
                classList.add(Class.forName(className));
            }

            STGroup stGroup = new STGroupFile("Aufgabe6/aufgabe6.stg");
            ST template = stGroup.getInstanceOf("root");

            template.add("classes", classList);

            System.out.println(template.render());
        } catch (ClassNotFoundException e) {
            System.err.println("Klasse nicht gefunden: " + e.getMessage());
        }
    }
}
