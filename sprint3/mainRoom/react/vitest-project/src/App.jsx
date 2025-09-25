import { useState } from 'react';
import './App.css';

function App() {
  const [text, setText] = useState('Hello!');
  const [recipes, setRecipes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleClick = () => {
    setText('Button clicked!');
  };

  const fetchRecipes = async () => {
    setLoading(true);
    setError(null);
    try {
      // Using DummyJSON API for recipe data
      const response = await fetch('https://dummyjson.com/recipes?limit=5');
      if (!response.ok) {
        throw new Error('Failed to fetch recipes');
      }
      const data = await response.json();
      setRecipes(data.recipes);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <p>
          Welcome to Vite + React!
        </p>
        <a
          className="App-link"
          href="https://vitejs.dev"
          target="_blank"
          rel="noopener noreferrer"
        >
          Vite Documentation
        </a>
      </header>
      <div className="App">
        <header className="App-header">
          <p>{text}</p>
          <button onClick={handleClick}>Click me</button>

          <div style={{ marginTop: '20px' }}>
            <button onClick={fetchRecipes} disabled={loading}>
              {loading ? 'Loading...' : 'Fetch Recipes'}
            </button>

            {error && (
              <p style={{ color: 'red' }}>Error: {error}</p>
            )}

            {recipes.length > 0 && (
              <div style={{ marginTop: '20px', textAlign: 'left' }}>
                <h3>Recipes:</h3>
                <ul>
                  {recipes.map((recipe) => (
                    <li key={recipe.id} style={{ marginBottom: '10px' }}>
                      <strong>{recipe.name}</strong> - {recipe.cuisine}
                      <br />
                      <small>Prep time: {recipe.prepTimeMinutes} min | Cook time: {recipe.cookTimeMinutes} min</small>
                    </li>
                  ))}
                </ul>
              </div>
            )}
          </div>
        </header>
      </div>
    </div>
  );
}

export default App;
