

public class TRNG {
    public static void main(String[] args) {
        
        try {
            displayRuntime();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }
    }

    private static void displayRuntime() throws Exception{
        RandomGenerators allRandoms = new RandomGenerators();
        System.out.format( "\n\n" +
            "|  PROVIDER     |  RUNTIME (ms) | ITERATIONS |\n" +
            "|---------------|---------------|------------|\n" +
            "| JAVA RANDOM   |        %.1f    |    %d   |\n" +
            "| SECURE RANDOM |      %.1f    |        %d   |\n" +
            "| RANDOM.ORG    |    %.1f    |        %d   |\n" +
            "| HOTBITS       |     %.1f    |        %d   |\n",
            allRandoms.runtimeJava(), RandomGenerators.ITERATIONS*10000,
            allRandoms.runtimeOS(), RandomGenerators.ITERATIONS,
            allRandoms.runtimeROrg(), RandomGenerators.ITERATIONS,
            allRandoms.runtimeHB(), RandomGenerators.ITERATIONS
        );
    }
}