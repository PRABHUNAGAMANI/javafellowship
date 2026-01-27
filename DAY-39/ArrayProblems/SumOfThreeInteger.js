let numbers=[0,-1,2,-3,1];

console.log("ARRAY : ", numbers.join(","));
let found=false;

for(let i=0;i<numbers.length;i++)
{
    for(let j=i+1;j<numbers.length;j++)
    {
        for(let k=j+1;k<numbers.length;k++)
        {
            if(numbers[i]+numbers[j]+numbers[k] === 0)
            {
                console.log("TRIPLET : ",numbers[i],numbers[j],numbers[k]);
                 found=true;
            }
        
        }
    }
}
if(!found)
{
    console.log("NO TRIPLETS FOUND ");
}