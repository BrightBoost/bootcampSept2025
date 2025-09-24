import { useState, useEffect } from "react";

export default function RecipeList() {
    const [recipes, setRecipes] = useState([]);

    useEffect(() => {
        loadRecipes();
    }, [])

    async function loadRecipes() {
        try {
            const response = await fetch("https://dummyjson.com/recipes");
            if (response.ok) {
                const data = await response.json();
                setRecipes(data.recipes || []);
            }
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <>
            <h2>Recipes</h2>
            <ul>
                {recipes.map(recipe => (<li key={recipe.id}>{recipe.name}</li>))}
            </ul>
        </>
    )

}