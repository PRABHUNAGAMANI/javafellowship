const WAGE_PER_HOUR = 20;
const FULL_TIME_WAGE = 160;
const PART_TIME_WAGE = 80;
const WORKING_DAYS = 30;

let dailyWageArray = [];

function generateDailyWages() {
    for (let day = 1; day <= WORKING_DAYS; day++) {
        let empCheck = Math.floor(Math.random() * 3);

        let dailyWage = 0;
        if (empCheck === 1) {
            dailyWage = PART_TIME_WAGE;
        } else if (empCheck === 2) {
            dailyWage = FULL_TIME_WAGE;
        }

        dailyWageArray.push(dailyWage);
    }
}

function calculateTotalWage() {
    return dailyWageArray.reduce((total, wage) => total + wage, 0);
}

function showDayWithWage() {
    return dailyWageArray.map((wage, index) =>
        `DAY ${index + 1} = ${wage}`
    );
}

function showFullTimeDays() {
    return dailyWageArray
        .map((wage, index) => ({ day: index + 1, wage }))
        .filter(item => item.wage === FULL_TIME_WAGE);
}


function firstFullTimeDay() {
    return dailyWageArray.find(wage => wage === FULL_TIME_WAGE);
}


function isEveryDayFullTime() {
    return dailyWageArray.every(wage => wage === FULL_TIME_WAGE);
}


function isAnyPartTime() {
    return dailyWageArray.some(wage => wage === PART_TIME_WAGE);
}


function numberOfWorkingDays() {
    return dailyWageArray.filter(wage => wage > 0).length;
}


generateDailyWages();
console.log("DAILY WAGE ARRAY :");
console.log(dailyWageArray.join(", "));
console.log("TOTAL WAGE :", calculateTotalWage());

console.log(" DAY-WISE WAGES :");
console.log(showDayWithWage().join("\n"));

console.log("DAYS WITH FULL TIME WAGES :");
showFullTimeDays().forEach(item =>
    console.log(`Day ${item.day} => ${item.wage}`)
);

console.log("FIRST FULL TIME WAGE EARNED :", firstFullTimeDay());
console.log("IS EVERY DAY FULL TIME :", isEveryDayFullTime());
console.log("IS THERE ANY PART TIME WAGE :", isAnyPartTime());
console.log("NUMBER OF DAYS EMPLOYEE WORKED :", numberOfWorkingDays());

