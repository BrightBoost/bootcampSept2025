import { useState, useEffect } from "react";

export default function RecipeList() {
    const [recipes, setRecipes] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        loadRecipes();
    }, [])

    async function loadRecipes() {
        try {
            setLoading(true);
            const response = await fetch("https://dummyjson.com/recipes1");
            if (response.ok) {
                const data = await response.json();
                setRecipes(data.recipes || []);
            } else {
                throw new Error("Failed to fetch recipes");
            }
            setLoading(false);
        } catch (err) {
            console.log(err);
            setError(err);
            setLoading(false);
        }
    }

    if (loading) {
        return <p>Loading...</p>
    }

    if (error) {
        return <p>There was an error: {error.message}</p>
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