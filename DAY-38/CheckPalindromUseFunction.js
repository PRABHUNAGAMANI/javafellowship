const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function isPalindrome(num) {
    let original = num;
    let reverse = 0;

    while (num > 0) {
        let digit = num % 10;
        reverse = reverse * 10 + digit;
        num = Math.floor(num / 10);
    }

    return original === reverse;
}

rl.question("Enter first number: ", (a) => {
    rl.question("Enter second number: ", (b) => {

        let num1 = parseInt(a);
        let num2 = parseInt(b);

        if (isPalindrome(num1) && isPalindrome(num2)) {
            console.log("Both numbers are Palindromes");
        } else {
            console.log("Both numbers are NOT Palindromes");
        }

        rl.close();   
    });
});
