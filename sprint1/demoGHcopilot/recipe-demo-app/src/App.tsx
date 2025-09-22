import React from 'react';
import RecipeList from './components/RecipeList';
import RecipeForm from './components/RecipeForm';
import { useRecipes } from './hooks/useRecipes';
import './App.css';

const App: React.FC = () => {
  const { recipes, addRecipe } = useRecipes();

  return (
    <div className="App">
      <h1>Recipe Demo App</h1>
      <RecipeForm onAddRecipe={addRecipe} />
      <RecipeList recipes={recipes} />
    </div>
  );
};

export default App;