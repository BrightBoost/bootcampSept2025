import './App.css'
import CoffeeList from './components/CoffeeList';
// ⭐
function App() {
  const favCoffee = "Latte";
  const rating = 4.76;
  const show = true;
  const coffees = ["Latte", "Cappuccino", "Espresso"];
  const coffeeObjects = [
    { name: "Latte", rating: 4.5 },
    { name: "Cappuccino", rating: 4.7 },
    { name: "Espresso", rating: 4.9 },
    { name: "Hazelnut coffee", rating: 4.0 }
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

      <CoffeeList list={coffeeObjects} />


    </>
  )
}

function sum(a, b) {
  return a + b;
}

export default App
