package ec.edu.uce.pa.grupo.u2;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Quarkus iniciado y entidades mapeadas.");
        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
}