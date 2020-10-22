import java.util.Random;
import org.random.api.RandomOrgClient;
import java.security.SecureRandom;
import randomX.randomHotBits;


public class RandomGenerators {
    // Random: Pseudorandom java generator
    private Random pseudorandom;

    // SecureRandom: OS generator through hardware
    private SecureRandom randomOS;

    // RANDOM.org: Atmospheric noise
    private RandomOrgClient randomOrg;

     // HotBits: Radioactive decay
    private randomHotBits randomHB;
    

    public static final int ITERATIONS = 5;

    public RandomGenerators(){
        this.pseudorandom = new Random();
        this.randomOS = new SecureRandom();
        this.randomOrg = RandomOrgClient.getRandomOrgClient("ecf83375-317a-4c7d-a352-53454082281b");
        this.randomHB = new randomHotBits();
    }

    public double runtimeJava(){
        long startTime = System.nanoTime();
        for(int i=0; i< ITERATIONS*10000; i++){
            this.pseudorandom.nextInt(10);
        }
        return (System.nanoTime()-startTime) / 1000000;
    }
    
    public double runtimeOS(){
        long startTime = System.nanoTime();
        for(int i=0; i< ITERATIONS; i++){
            this.randomOS.nextInt(10);
        }
        return (System.nanoTime()-startTime) / 1000000;
    }

    public double runtimeROrg() throws Exception{
        long startTime = System.nanoTime();
        for(int i=0; i< ITERATIONS; i++){
            this.randomOrg.generateIntegers(1, 0, 10);
        }
        return (System.nanoTime()-startTime) / 1000000;
    }
    
    public double runtimeHB(){
        long startTime = System.nanoTime();
        for(int i=0; i< ITERATIONS; i++){
            Math.abs(this.randomHB.nextInt() % 10);
        }
        return (System.nanoTime()-startTime) / 1000000;
    }
}