console.log("file included sucessfully");
showNotes();
let addbtn=document.getElementById("btn");
addbtn.addEventListener("click",function(e){
    let addtext=document.getElementById("addtext");
    let notes=localStorage.getItem("notes");
    if(notes==null)
    {
        notesObj=[];
       
    }
    else
    {
        notesObj=JSON.parse(notes);
    }if(addtext.value=="")
    {
        alert("enter something")
    }
    else{
       
    
    notesObj.push(addtext.value);
    localStorage.setItem("notes",JSON.stringify(notesObj));
    addtext.value="";
    console.log(notesObj);
    showNotes();}
})
function showNotes(){
    let notes=localStorage.getItem("notes");
    if(notes==null)
    {
        notesObj=[];
        
    }
    else
    {
        notesObj=JSON.parse(notes);
    }
    let html="";
    notesObj.forEach(function(element,index) {
        html+=
        `
        
        <div class=" mx-2 my-2 note-card" style="width: 400px ;margin-inline: 10px 40px;">
        <div class="card-body">
          <h5 class="card-title">Note number:${index +1}</h5>
          <h6 class="card-subtitle" style="color:blue;">${element}</h6>
          <p class="card-text"></p>
         <button id="${index}"onclick="deleteNote(this.id)" style="background-color: skyblue;">DELETE NOTE</button>
        </div>
        </div>
        
        `
        
    });
    let noteselem=document.getElementById('notes');
    if(notesObj.length!=0)
    {
        noteselem.innerHTML=html;
    }
    
}
function deleteNote(index)
{
     let notes=localStorage.getItem("notes");
     console.log("Deleting the node"+index);
     let ind=index;
    if(notes==null)
    {
        notesObj=[];
       
    }
    else
    {
        notesObj=JSON.parse(notes);
    }
    notesObj.splice(ind,1);
    localStorage.setItem("notes",JSON.stringify(notesObj));
    showNotes();
//   
}
let search=document.getElementById("search");
search.addEventListener("input",function(){
    let input=search.value;
console.log("event fired",input);    
})
