
import './App.css'
// ⭐
function App() {
  const favCoffee = "Latte";
  const rating = 4.76;
  const show = true;
  const coffees = ["Latte", "Cappuccino", "Espresso"];
  const coffeeObjects = [
    { name: "Latte", rating: 4.5 },
    { name: "Cappuccino", rating: 4.7 },
    { name: "Espresso", rating: 4.9 }
  ];

  return (
    <>
      <h1>Welcome to my Coffee Blog</h1>
      <p>My favorite coffee is {favCoffee}.</p>
      <p>Numbers 2 and 3 are together {3 + 2}</p>
      <p>Numbers 5 and 7 are together {sum(5, 7)}</p>
      <p>This coffee is good {rating > 4.5 ? "⭐" : "👎"}</p>
      {show && <p>This is a special coffee!</p>}

      <h2>The top 3 coffees of our class:</h2>
      <ul>
        {coffees.map(coffee => (
          <li key={coffee}>{coffee}</li>
        ))}
      </ul>

      <h2>Coffees with ratings:</h2>
      <ul>
        {coffeeObjects.map(coffee => (
          <li key={coffee.name}>
            {coffee.name} - {coffee.rating > 4.5 ? "⭐" : "👎"}
          </li>
        ))}
      </ul>
    </>
  )
}

function sum(a, b) {
  return a + b;
}

export default App
