import { useState } from 'react'

import CoffeeList from '../components/CoffeeList';
import AddCoffeeForm from '../components/AddCoffeeForm';

export default function Home() {
      const [likes, setLikes] = useState(0);  
  const [coffees, setCoffees] = useState([]);
  const [newCoffee, setNewCoffee] = useState("");
  const favCoffee = "Latte";
  const rating = 4.76;
  const show = true;
  const [coffeeObjects, setCoffeeObjects] = useState([
    { name: "Latte", rating: 4.5 },
    { name: "Cappuccino", rating: 4.7 },
    { name: "Espresso", rating: 4.9 },
    { name: "Hazelnut coffee", rating: 4.0 }
  ]);

  function addLike() {
    setLikes(likes + 1);  
  }

  function handleNewCoffee() {
    setCoffees([...coffees, newCoffee]);
    setNewCoffee("");
  }

  return (
    <>
      <h1>Very welcome to my Coffee Blog</h1>
      <p>This many people liked my page: {likes}</p>
      <p>Do you like my page too?</p>
      <button onClick={addLike}>Like</button>
      <p>My favorite coffee is {favCoffee}.</p>
      <p>Numbers 2 and 3 are together {3 + 2}</p>
      <p>Numbers 5 and 7 are together {sum(5, 7)}</p>
      <p>This coffee is good {rating > 4.5 ? "⭐" : "👎"}</p>
      {show && <p>This is a special coffee!</p>}

      <input type="text" value={newCoffee} onChange={e => setNewCoffee(e.target.value)}></input>
      <button onClick={handleNewCoffee}>Add coffee</button>
      <h2>The coffees of our class:</h2>
      <ul>
        {coffees.map(coffee => (
          <li key={coffee}>{coffee}</li>
        ))}
      </ul>

      <CoffeeList list={coffeeObjects} />
      <AddCoffeeForm onAddCoffee={(coffee) => setCoffeeObjects([...coffeeObjects, coffee])} />
    </>
  )
}

function sum(a, b) {
  return a + b;
}
