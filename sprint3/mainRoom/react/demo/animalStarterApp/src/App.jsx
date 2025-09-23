import { useState } from 'react'

import './App.css'
import AddAnimalForm from './components/AddAnimalForm';
import AnimalList from './components/AnimalList';
function App() {
   const [animals, setAnimals] = useState([]);
   return (
    <>
      <AnimalList animalList={animals} />
      <AddAnimalForm onAddAnimal={(newAnimal) => setAnimals([...animals, newAnimal])} />
    </>
   )
}

export default App
