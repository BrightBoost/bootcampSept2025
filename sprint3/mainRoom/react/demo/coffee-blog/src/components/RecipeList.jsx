import { useState, useEffect } from "react";

export default function RecipeList() {
    const [recipes, setRecipes] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // state for form
    const [newRecipe, setNewRecipe] = useState({ name: "", difficulty: "" });

    useEffect(() => {
        loadRecipes();
    }, [])

    async function loadRecipes() {
        try {
            setLoading(true);
            const response = await fetch("https://dummyjson.com/recipes");
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

    // handlesubmit function
    async function handleSubmit(event) { 
        event.preventDefault();
        try {
            const response = await fetch("https://dummyjson.com/recipes/add", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newRecipe)
            });
            const addedRecipe = await response.json();
            setRecipes([...recipes, addedRecipe]);
            setNewRecipe({ name: "", difficulty: "" }); // reset form 
        } catch (error) {
            console.error("Error adding recipe:", error);
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
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Recipe name" value={newRecipe.name} onChange={e => setNewRecipe({ ...newRecipe, name: e.target.value })} />
                <input type="text" placeholder="Difficulty" value={newRecipe.difficulty} onChange={e => setNewRecipe({ ...newRecipe, difficulty: e.target.value })} />
                <button type="submit">Add Recipe</button>
            </form>
            <h2>Recipes</h2>
            <ul>
                {recipes.map(recipe => (<li key={recipe.id}>{recipe.name}</li>))}
            </ul>
        </>
    )

}