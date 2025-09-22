import { Recipe } from "../types/Recipe";

// Dummy data for demo purposes
const dummyRecipes: Recipe[] = [
  {
    id: 1,
    title: "Spaghetti Carbonara",
    ingredients: ["pasta", "eggs", "bacon", "parmesan cheese", "black pepper"],
    instructions:
      "Cook pasta. Mix eggs with cheese. Cook bacon. Combine all ingredients while pasta is hot.",
  },
  {
    id: 2,
    title: "Chocolate Chip Cookies",
    ingredients: [
      "flour",
      "butter",
      "sugar",
      "eggs",
      "chocolate chips",
      "vanilla",
    ],
    instructions:
      "Mix dry ingredients. Cream butter and sugar. Add eggs and vanilla. Combine mixtures. Add chocolate chips. Bake at 375°F for 10 minutes.",
  },
  {
    id: 3,
    title: "Caesar Salad",
    ingredients: [
      "romaine lettuce",
      "croutons",
      "parmesan cheese",
      "caesar dressing",
    ],
    instructions: "Chop lettuce. Add croutons and cheese. Toss with dressing.",
  },
];

export const fetchRecipes = async (): Promise<Recipe[]> => {
  // Simulate API delay
  await new Promise((resolve) => setTimeout(resolve, 500));
  return [...dummyRecipes];
};

export const addRecipe = async (
  recipe: Omit<Recipe, "id">
): Promise<Recipe> => {
  // Simulate API delay
  await new Promise((resolve) => setTimeout(resolve, 300));

  const newRecipe: Recipe = {
    ...recipe,
    id: Date.now(), // Simple ID generation for demo
  };

  dummyRecipes.push(newRecipe);
  return newRecipe;
};
