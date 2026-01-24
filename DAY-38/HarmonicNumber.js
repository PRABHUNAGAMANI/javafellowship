const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter n value: ", (n) => {
    let num = parseInt(n);

    if (isNaN(num) || num <= 0) {
        console.log("Please enter a positive number");
    } else {
        let harmonic = 0;

        for (let i = 1; i <= num; i++) {
            harmonic = harmonic + 1 / i;
        }

        console.log("Harmonic Number " + num + " = " + harmonic);
    }

    rl.close();
});
