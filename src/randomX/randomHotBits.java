package randomX;

import java.net.*;
import java.io.*;
import randomX.*;

/**
    <p>
    Implementation of a <b>randomX</b>-compliant class which obtains
    genuine random data from <a href="http://www.fourmilab.ch/">John
    Walker</a>'s <a href="http://www.fourmilab.ch/hotbits/">HotBits</a>
    radioactive decay random sequence generator.
    </p>

    <p>
    Designed and implemented in July 1996 by
    <a href="http://www.fourmilab.ch/">John Walker</a>.
    </p>
*/

public class randomHotBits extends randomX {
    long state;
    int nuflen = 256, buflen = 0;
    byte[] buffer;
    int bufptr = -1;
    String apiKey = "Pseudorandom";

    //  Constructors

    /** Creates a new random sequence generator.  An API key of
        "Pseudorandom" will be used, requesting pseudorandom data
        from the HotBits server. */

    public randomHotBits() {
        buffer = new byte[nuflen];
    }

    /** Creates a new random sequence generator using the specified
        API key to request radioactively-generated random data from
        the HotBits generator.

@param apikey API Key to request HotBits data
    */

    public randomHotBits(String apikey) {
        this();
        apiKey = apikey;
    }

    /*  Private method to fill buffer from HotBits server.  */

    private void fillBuffer()
        throws java.io.IOException
    {
        URL u = new URL("https://www.fourmilab.ch/cgi-bin/Hotbits?nbytes=128&fmt=bin&apikey=" + apiKey);
        InputStream s = u.openStream();
        int l;

        buflen = 0;
        while ((l = s.read()) != -1) {

            /*  If an error occurs obtaining data from the HotBits generator
                (for example, the quota has been exceeded or an invalid API
                key was specified), an HTML error message will be returned
                which is guaranteed to exceed the 256 byte reply buffer.  We
                detect that here, convert what we've received so far into a
                string, then append the rest of the message as characters to
                the string.  The HTML error message is then printed and a
                RuntimeException thrown to report the error.  */

            if (buflen >= nuflen) {
                System.err.println("Error obtaining HotBits from server:");
                String msg = new String(buffer, 0, nuflen);
                while ((l = s.read()) != -1) {
                    byte b[] = { (byte) l };
                    msg += new String(b);
                }
                System.err.println(msg);
                throw new RuntimeException("Cannot obtain HotBits");
            }
            buffer[buflen++] = (byte) l;
        }
        s.close();
        bufptr = 0;
    }

    /** Get next byte from generator.

@return the next byte from the generator.
    */

    public byte nextByte()  {
        try {
            synchronized (buffer) {
                if (bufptr < 0 || bufptr >= buflen) {
                    fillBuffer();
                }
                return buffer[bufptr++];
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot obtain HotBits");
        }
    }
};
