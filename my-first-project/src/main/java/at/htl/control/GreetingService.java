package at.htl.control;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    private int counter;

    public String greeting(String name) {
        return String.format("Hello %s (%d x aufgerufen)", name, ++counter);
    }

}
