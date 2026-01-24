const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function convertTemperature(choice, value) {
    switch (choice) {
        case 1:
        
            if (value < 0 || value > 100) {
                console.log("Please enter Celsius value between 0 and 100");
            } else {
                let degF = (value * 9 / 5) + 32;
                console.log("Temperature in Fahrenheit:", degF);
            }
            break;

        case 2:
            
            if (value < 32 || value > 212) {
                console.log("Please enter Fahrenheit value between 32 and 212");
            } else {
                let degC = (value - 32) * 5 / 9;
                console.log("Temperature in Celsius:", degC);
            }
            break;

        default:
            console.log("Invalid selection");
    }
}


rl.question(
    "Select Conversion:\n1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\nEnter choice: ",
    (choice) => {
        rl.question("Enter temperature value: ", (value) => {
            convertTemperature(parseInt(choice), parseFloat(value));
            rl.close();
        });
    }
);
