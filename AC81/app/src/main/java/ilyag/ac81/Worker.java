package ilyag.ac81;

/**
 * Created by zelig on 10/12/14.
 */
public class Worker {
    private String name, manager;
    int maskoret;

    public Worker(String name, String manager, int maskoret) {
        this.name = name;
        this.manager = manager;
        this.maskoret = maskoret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getMaskoret() {
        return maskoret;
    }

    public void setMaskoret(int maskoret) {
        this.maskoret = maskoret;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", maskoret=" + maskoret +
                '}';
    }
}
