let initialAmount = 100;
let goalAmount = 2000;

let gamesPlayed = 1;


let result = Math.floor(Math.random() * 2);

let finalAmount;

console.log("Initial Amount: Rs", initialAmount);

if (result === 1) {
    
    finalAmount = goalAmount;
    let profit = finalAmount - initialAmount;

    console.log("Result: WIN");
    console.log("Final Amount: Rs", finalAmount);
    console.log("Profit Amount: Rs", profit);
} else {
    
    finalAmount = 0;
    let loss = initialAmount - finalAmount;

    console.log("Result: LOSE");
    console.log("Final Amount: Rs", finalAmount);
    console.log("Loss Amount: Rs", loss);
}

console.log("Games Played:", gamesPlayed);
