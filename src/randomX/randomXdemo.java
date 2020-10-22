
    /*  Generate a quantity of randomX values and
        compute mean.  Expectation value is 127.5.  */
/*
    import randomX.*;

    class randomXdemo {

        public static void main(String[] args) {
            randomX r;
            int i;

            //  Uncomment the generator you wish to test
//          r = new randomLCG();
//          r = new randomMCG();
//          r = new randomJava();
            r = new randomLEcuyer();
//          r = new randomHotBits("Pseudorandom");

            long mean = 0;
//          long n = 100000000;
            long n = 256;
            for (i = 0; i < n; i++) {
                int b = r.nextByte() & 0xFF;
                mean += b;
            }

            System.out.print("Mean for ");
            System.out.print(n);
            System.out.print(" values is ");
            System.out.println((double) mean / n);
        }
    }
*/