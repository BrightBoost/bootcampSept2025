window.onload = function () {
    const apiURL = "https://dummyjson.com/todos";
    const todoList = document.getElementById('todoList');
    fetch(apiURL)
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            for(let i = 0; i < data["todos"].length; i++) {
                const li = document.createElement("li");
                li.innerText = data["todos"][i]["todo"];
                todoList.append(li);
            }
        })
        .catch(function (err) {
            console.log("Oh no: " + err)
        });

}
function greet() {
    // get the value from an input box
    const name = document.getElementById('nameInput').value;
    // display the value in a console.log
    console.log('Hello, ' + name + '!');
    // update the div with the greeting
    document.getElementById('greeting').innerText = 'Hello, ' + name + '!';
    // clear the input box
    document.getElementById('nameInput').value = '';
}

function changeColors() {
    const squares = document.getElementsByClassName('square');
    for (let i = 0; i < squares.length; i++) {
        squares[i].style.backgroundColor = getRandomColor();
    }
}

function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function generateListItems() {
    const favoriteAnimals = ['Dog', 'Cat', 'Elephant', 'Giraffe', 'Lion'];
    const list = document.getElementById('animalList');
    list.innerHTML = '';
    for (let i = 0; i < favoriteAnimals.length; i++) {
        const listItem = document.createElement('li');
        listItem.innerText = favoriteAnimals[i];
        list.appendChild(listItem);
    }
}