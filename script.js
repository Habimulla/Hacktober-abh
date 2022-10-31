const dayrem=document.getElementById('days');
const hourrem=document.getElementById('hours');
const minrem=document.getElementById('minutes');
const secrem=document.getElementById('seconds');
const newyear="1 Jan 2023";
function countdown()
{
    const newyearsDate=new Date(newyear)
    const dop=new Date();
    const seconds=(newyearsDate-dop)/1000;
     const minutes=(seconds)%24%60;
     const days=Math.floor(seconds/(24*3600));
     
    const hours=Math.floor((seconds/3600)%24);
    const min=Math.floor(seconds/60)%60;
    const sec=Math.floor(seconds%60);
    
    // console.log((newyearsDate-dop)/(24*60*60*1000));

    // console.log(Math.floor(days));
    // console.log(hours);
    // console.log(min);
    // console.log(sec);
    dayrem.innerHTML=timeformat(days);
    hourrem.innerHTML=timeformat(hours);
    minrem.innerHTML=timeformat(min);
    secrem.innerHTML=timeformat(sec);

}
function timeformat(time)
{
    if(time<10)
    {
        
        return`0${time}`;
    }
    else
    {
        return time;
    }
}
countdown();
setInterval(countdown,1000);