import React, { useState } from 'react';
import { Recipe } from '../types/Recipe';

interface RecipeFormProps {
    onAddRecipe: (recipe: Omit<Recipe, 'id'>) => void;
}

const RecipeForm: React.FC<RecipeFormProps> = ({ onAddRecipe }) => {
    const [title, setTitle] = useState('');
    const [ingredients, setIngredients] = useState('');
    const [instructions, setInstructions] = useState('');

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const newRecipe = {
            title,
            ingredients: ingredients.split(',').map(ingredient => ingredient.trim()),
            instructions,
        };

        onAddRecipe(newRecipe);
        setTitle('');
        setIngredients('');
        setInstructions('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Ingredients (comma separated):</label>
                <input
                    type="text"
                    value={ingredients}
                    onChange={(e) => setIngredients(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Instructions:</label>
                <textarea
                    value={instructions}
                    onChange={(e) => setInstructions(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Add Recipe</button>
        </form>
    );
};

export default RecipeForm;