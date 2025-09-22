window.onload = function () {
    const recipeList = document.getElementById('recipeList');
    fetch("https://dummyjson.com/recipes")
        .then(function (response) { 
            return response.json(); 
        })
        .then(function(data) {
            for(let i = 0; i < data["recipes"].length; i++) {
                const li = document.createElement("li");
                li.innerText = data["recipes"][i]["name"] + " : " + data["recipes"][i]["difficulty"];
                recipeList.append(li);
            } 
        })
    }
    
    function showSkills() {
        const skills = ['HTML', 'CSS', 'JavaScript', 'Python', 'Django'];
        // get the UL element
        const skillsList = document.getElementById('skillsList');
        // create an LI element for each skill
        for (let i = 0; i < skills.length; i++) {
            const li = document.createElement('li');
            li.innerText = skills[i];
            // add it to the UL
            skillsList.append(li);
        }
    }