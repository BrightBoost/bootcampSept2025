import { useEffect, useState } from "react";
import { fetchRecipes, addRecipe } from "../services/api";
import { Recipe } from "../types/Recipe";


export const useRecipes = () => {
  const [recipes, setRecipes] = useState<Recipe[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const loadRecipes = async () => {
      try {
        const fetchedRecipes = await fetchRecipes();
        setRecipes(fetchedRecipes);
      } catch (err) {
        setError("Failed to fetch recipes");
      } finally {
        setLoading(false);
      }
    };

    loadRecipes();
  }, []);

  const handleAddRecipe = async (newRecipe: Omit<Recipe, "id">) => {
    try {
      const addedRecipe = await addRecipe(newRecipe);
      setRecipes((prevRecipes) => [...prevRecipes, addedRecipe]);
    } catch (err) {
      setError("Failed to add recipe");
    }
  };

  return { recipes, loading, error, addRecipe: handleAddRecipe };
};
