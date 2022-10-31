const searchbtn=document.getElementById('search-btn');
const mealList=document.getElementById("meal1");
const closebtn=document.getElementsByClassName("btn-cut");
const mealLis4t=document.getElementById("re");
const mealDetailsContent = document.querySelector('.meal-details');




searchbtn.addEventListener('click',getmeallist);
mealList.addEventListener('click', getMealRecipe);
function getmeallist(){
   let usersearch=document.getElementById('search-input').value.trim();
    fetch(`https://www.themealdb.com/api/json/v1/1/filter.php?i=${usersearch}`)
    .then(response=>response.json())
    .then(data=>{
        //  console.log(data);
        let html="";
        if(data.meals)
        {
            data.meals.forEach(element => {
                html+=`
                <div class="meal-item" id="${element.idMeal}">
                    <div class="meal-img">
                        <img src="${element.strMealThumb}">
                    </div>
                    <div class="meal-name">
                        <h3>${element.strMeal}</h3>
                        <a href = "#" class = "recipe-btn">Get Recipe</a>
                    </div>
                </div>
                ` ; 
            });
           
        }
        else{
            html="sorry we dont't have this"
        }
        mealList.innerHTML=html;
        
    })
    }

    
    
   



    function getMealRecipe(e){
        e.preventDefault();
        if(e.target.classList.contains('recipe-btn')){
            let mealItem = e.target.parentElement.parentElement;
            fetch(`https://www.themealdb.com/api/json/v1/1/lookup.php?i=${mealItem.dataset.id}`)
            .then(response => response.json())
            .then(data => mealRecipeModal(data.meals));
        }
    }


    function mealRecipeModal(meal){
        console.log(meal);
        meal = meal[0];
        let html = `
        <div class="meal-details">
        <div class="meal-det" id="meal-det1">
        <div class="cross-btn">
            <button class="btn-cut">
                <i class="fa-solid fa-xmark"></i>
            </button>
        </div>
        <h3class="title">Get The Meal Details</h3>
        <div class="meal-details-name">
           <h2> ${meal.strMeal}</h2>
        </div>
        <div class="meal-detail-img">
            <img class="img-det" src="https://post.healthline.com/wp-content/uploads/2020/09/healthy-eating-ingredients-732x549-thumbnail-732x549.jpg">
        </div>
        <div class="meal-info">
            tiae veniam est a dolores, nihil nulla quo dolorum accusamus ut facere, excepturi sapiente iste quod reprehenderit cupiditate placeat nemo nisi. Aspernatur.
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus necessitatibus eveniet neque totam? Aspernatur illo quasi quia vero excepturi ipsam nostrum dolorum, quis eius quod sint! Cumque dignissimos placeat reiciendis?
        </div>
     </div>
    </div>
        `;
        mealDetailsContent.innerHTML = html;
        mealDetailsContent.parentElement.classList.add('showRecipe');
    }
