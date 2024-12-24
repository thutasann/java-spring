// @ts-check
class BenchmarkTests {
    loopSample() {
        console.log("\n==> Loop Sample")
        const start = Date.now();
        let sum = 0;
        for (let i = 0; i < 1_000_000_000; i++) {
            sum += i;
        }
        const end = Date.now();
        console.log(`Time: ${end - start} ms`)
    }
}

const benchmarkTests = new BenchmarkTests();
benchmarkTests.loopSample();