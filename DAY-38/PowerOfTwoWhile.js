const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter n value: ", (n) => {
    let num = parseInt(n);

    if (isNaN(num) || num < 0) {
        console.log("Please enter a valid non-negative number");
    } else {
        let power = 1;
        let i = 0;

        while (i <= num && power <= 256) {
            console.log(power);
            power = power * 2;
            i++;
        }
    }

    rl.close();  
});
