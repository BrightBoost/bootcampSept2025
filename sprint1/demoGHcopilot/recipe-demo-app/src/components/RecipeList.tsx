import React from 'react';
import RecipeCard from './RecipeCard';
import { Recipe } from '../types/Recipe';

interface RecipeListProps {
  recipes: Recipe[];
}

const RecipeList: React.FC<RecipeListProps> = ({ recipes }) => {
  return (
    <div>
      {recipes.length === 0 ? (
        <p>No recipes available.</p>
      ) : (
        recipes.map(recipe => (
          <RecipeCard key={recipe.id} recipe={recipe} />
        ))
      )}
    </div>
  );
};

export default RecipeList;