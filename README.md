## TRUE RANDOM NUMBER GENERATOR - TRNG

A Pseudorandom number generator (PRNG) helps you efficiently generate random numbers, but in a lot of applications true random numbers are required. 
In this program, we test a few features that use true random numbers (HotBits, RANDOM.org and Java's Secure Random package), comparing it to Pseudorandom generators.

### 🏁 Installation <a name = "inicio"></a>

This software uses the following Libraries:
1. <a href= "https://github.com/RandomOrg/JSON-RPC-Java">JSON-RPC-Java</a> : To get data from RANDOM.org
2. <a href= "https://www.fourmilab.ch/hotbits/source/randomX/randomX.html">randomX</a> : Java package to get data from HotBits

** Please notice that JSON-RPC also has <a href="https://github.com/RandomOrg/JSON-RPC-Java#installation">requirements</a> that must be installed

### ⛏️ Features <a name = "Features"></a>

- Runtime comparison
- Chi-squared comparison (not yet implement due to hardware deficiency)
