
let birthMonthMap = new Map();


let months = [ "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"];

for (let i = 1; i <= 50; i++) 
{
    let monthIndex = Math.floor(Math.random() * 12);
    let monthName = months[monthIndex];
    let year = Math.random() < 0.5 ? 1992 : 1993;
    let person = "Person" + i + " (" + year + ")";
    if (birthMonthMap.has(monthName)) 
    {
        birthMonthMap.get(monthName).push(person);
    } 
    else 
    {
        birthMonthMap.set(monthName, [person]);
    }
}
console.log("SAME MONTH BIRTHDAYS ");

for (let [month, people] of birthMonthMap) 
{
    console.log(month + " :");
    console.log(people.join(", "));
    console.log("---------------------------");
}
