import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function RecipeDetails() {
    const { id } = useParams();
    const [recipe, setRecipe] = useState(null);

    useEffect(() => {
        async function loadRecipe() {
            try {
                const response = await fetch(`https://dummyjson.com/recipes/${id}`);
                if (response.ok) {
                    const data = await response.json();
                    setRecipe(data);
                }
            } catch (err) {
                console.log(err);
            }
        }
        loadRecipe();
    }, [id])



    return (
        <h2>Recipe {recipe?.name}</h2>
    )

}