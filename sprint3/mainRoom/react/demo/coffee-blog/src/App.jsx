import { Link, Route, Routes } from 'react-router-dom'
import './App.css'
import Contact from './pages/Contact'
import Home from './pages/Home'
import Recipes from './pages/Recipes'
import RecipeDetails from './pages/RecipeDetails'


function App() {
  return (
    <>
      <Link to="/">Home</Link>
      <Link to="/contact">Contact</Link>
      <Link to="/recipes">Recipes</Link>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/recipes" element={<Recipes />}></Route>
        <Route path="/recipes/:id" element={<RecipeDetails />}></Route>
        <Route path="/contact" element={<Contact />}></Route>
      </Routes>
    </>
  )
}

export default App
