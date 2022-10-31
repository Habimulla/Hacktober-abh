const quizdata=[
    {
        question:'Kathmandu is the capital city of which country??',
        a:'India',
        b:'Nepal',
        c:'USA',
        d:'Australia',
        correct:'b',
    },
    {
        question:'which is the most dangerous country??',
        a:'Pakistan',
        b:'Nepal',
        c:'USA',
        d:'Australia',
        correct:'a',
    },
    {
        question:'which is the largest country??',
        a:'India',
        b:'Russia',
        c:'USA',
        d:'Australia',
        correct:'b',
    },
    {
        question:'Who is the President  of India??',
        a:'Robin Pal',
        b:'Narendra Modi',
        c:'Usha Anant Subramanyam',
        d:'Ram Nath Kovind',
        correct:'d',
    },
];
const a_text=document.getElementById("a_text");
const b_text=document.getElementById("b_text");
const c_text=document.getElementById("c_text");
const d_text=document.getElementById("d_text");
const question=document.getElementById("question");
const submitbtn=document.getElementById("button");
const prevbtn=document.getElementById("back");
var marks=0;
let currentquiz=0;
const s=document.getElementById('hello');
var rel=0;




var currentquestiondata =0;
function checkquiz()
{
    const k=displayRadioValue();
    console.log(k);
    if(currentquestiondata.correct==k)
    {
        marks++;
        console.log(k,marks,currentquiz,currentquestiondata.question,currentquestiondata.correct);
    }
}

showquiz();
function showquiz()
{
    
    
    currentquestiondata=quizdata[currentquiz]; 
    
    
    
    

    
    
    
    question.innerText=currentquestiondata.question;
    a_text.innerText=currentquestiondata.a
    b_text.innerText=currentquestiondata.b
    c_text.innerText=currentquestiondata.c
    d_text.innerText=currentquestiondata.d
    

     
    
    

}
function taketestagain()
{
    document. location. reload();
}


submitbtn.addEventListener("click",()=>{
    
    
       
    
   
if(currentquiz<quizdata.length){
    checkquiz();
    currentquiz++; 
    showquiz();
    
    
    
    
    


        
    
     
    
    
    
   

}
    else
    {
        
        
        s.innerHTML=`<h1>you have comepleted the quiz ${marks}/${quizdata.length}</h1>`;
        // na.innerHTML=`<h1>marks obtained :: ${marks}/${quizdata.length}</h1>`;
        submitbtn.innerHTML=`<button id="reload">Give Test Again</button>`;
        rel++;;
        const reload=document.getElementById("reload");
        if(rel<2){alert("You have completed the quiz");};
        
        if(rel==2){
reload.addEventListener("click",document. location. reload());}
            
            
        
        
       
        
        

        
    }
})

prevbtn.addEventListener("click",()=>{
    if(currentquiz>=0){
    currentquiz--;
    showquiz();}
    else
    {
        
        alert("You are at the first question");
    }
}) 
// const n=document.getElementById("res");
// displayRadioValue();

// function displayRadioValue() {
//     var ele = document.getElementsByName('answer');
      
//     for(i = 0; i < ele.length; i++) {
//         if(ele[i].checked)
//         document.getElementById("result").innerHTML
//                 = "selected: ";
//     }
// }
// n.addEventListener("click",displayRadioValue());
const na=document.getElementById("res");


function  displayRadioValue() {
    var ele = document.getElementsByName('answer');
      var kj=0;
    for(i = 0; i < ele.length; i++) {
        if(ele[i].checked){
        document.getElementById("result").innerHTML
                = "selected: "+ele[i].value;
                kj=ele[i].value;}
            
    }
    return kj;
}

showquiz();
