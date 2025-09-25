# Setting Up Testing in React with Vitest - Step-by-Step Guide

## Overview

This guide demonstrates how to set up comprehensive testing in a React project using Vitest, including testing API calls, async operations, and user interactions.

## Prerequisites

- React project created with Vite
- Basic understanding of React hooks (useState, useEffect)

## Step 1: Install Testing Dependencies

First, install the necessary testing libraries:

```bash
npm install --save-dev vitest jsdom @testing-library/react @testing-library/jest-dom @testing-library/user-event
```

**What each package does:**

- `vitest`: Fast unit test framework (Vite-native alternative to Jest)
- `jsdom`: DOM environment for testing React components
- `@testing-library/react`: React testing utilities
- `@testing-library/jest-dom`: Custom Jest matchers for DOM testing
- `@testing-library/user-event`: Advanced user interaction simulation

## Step 2: Configure Vitest

Create or update `vitest.config.js`:

```javascript
import { defineConfig } from "vitest/config";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    environment: "jsdom",
    setupFiles: "./setupTests.js",
  },
});
```

## Step 3: Create Test Setup File

Create `setupTests.js` in the project root:

```javascript
import "@testing-library/jest-dom";
```

This imports custom matchers like `toBeInTheDocument()`.

## Step 4: Add Test Scripts to package.json

Update your `package.json` scripts section:

```json
{
  "scripts": {
    "dev": "vite",
    "build": "vite build",
    "preview": "vite preview",
    "test": "vitest",
    "test:ui": "vitest --ui",
    "test:run": "vitest run"
  }
}
```

## Step 5: Create a Component with State and API Calls

Here's our example `App.jsx` with multiple features to test:

```jsx
import { useState } from "react";
import "./App.css";

function App() {
  // State for basic interaction
  const [text, setText] = useState("Hello!");

  // State for API functionality
  const [recipes, setRecipes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  // Basic click handler
  const handleClick = () => {
    setText("Button clicked!");
  };

  // Async API call with error handling
  const fetchRecipes = async () => {
    setLoading(true);
    setError(null);
    try {
      const response = await fetch("https://dummyjson.com/recipes?limit=5");
      if (!response.ok) {
        throw new Error("Failed to fetch recipes");
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
        <p>Welcome to Vite + React!</p>
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

          <div style={{ marginTop: "20px" }}>
            <button onClick={fetchRecipes} disabled={loading}>
              {loading ? "Loading..." : "Fetch Recipes"}
            </button>

            {error && <p style={{ color: "red" }}>Error: {error}</p>}

            {recipes.length > 0 && (
              <div style={{ marginTop: "20px", textAlign: "left" }}>
                <h3>Recipes:</h3>
                <ul>
                  {recipes.map((recipe) => (
                    <li key={recipe.id} style={{ marginBottom: "10px" }}>
                      <strong>{recipe.name}</strong> - {recipe.cuisine}
                      <br />
                      <small>
                        Prep time: {recipe.prepTimeMinutes} min | Cook time:{" "}
                        {recipe.cookTimeMinutes} min
                      </small>
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
```

## Step 6: Create Comprehensive Tests

Create `App.test.jsx` with various testing scenarios:

```jsx
import { render, screen, waitFor } from "@testing-library/react";
import { describe, it, expect, vi, afterEach } from "vitest";
import userEvent from "@testing-library/user-event";
import App from "./App";

describe("App Component", () => {
  // Test 1: Basic Rendering
  it("should render the welcome message", () => {
    // Arrange: Render the App component
    render(<App />);

    // Act: Nothing to act on in this simple test

    // Assert: Check if the welcome message is in the document
    expect(screen.getByText(/welcome/i)).toBeInTheDocument();
  });

  // Test 2: Static Content Testing
  it("should contain a link to the Vite documentation", () => {
    render(<App />);

    const linkElement = screen.getByRole("link", {
      name: /vite documentation/i,
    });
    expect(linkElement).toBeInTheDocument();
    expect(linkElement).toHaveAttribute("href", "https://vitejs.dev");
  });

  // Test 3: User Interaction Testing
  it("should update the text on button click", async () => {
    render(<App />);

    const button = screen.getByRole("button", { name: /click me/i });
    await userEvent.click(button);

    expect(screen.getByText(/button clicked/i)).toBeInTheDocument();
  });

  // Test 4: Button Existence
  it("should render the fetch recipes button", () => {
    render(<App />);

    const fetchButton = screen.getByRole("button", { name: /fetch recipes/i });
    expect(fetchButton).toBeInTheDocument();
    expect(fetchButton).not.toBeDisabled();
  });

  // Test 5: Loading State Testing
  it("should show loading state when fetching recipes", async () => {
    // Mock fetch with delayed response
    globalThis.fetch = vi.fn(
      () =>
        new Promise((resolve) =>
          setTimeout(
            () =>
              resolve({
                ok: true,
                json: () => Promise.resolve({ recipes: [] }),
              }),
            100
          )
        )
    );

    render(<App />);

    const fetchButton = screen.getByRole("button", { name: /fetch recipes/i });
    await userEvent.click(fetchButton);

    // Check loading state
    expect(
      screen.getByRole("button", { name: /loading.../i })
    ).toBeInTheDocument();
    expect(screen.getByRole("button", { name: /loading.../i })).toBeDisabled();

    // Wait for loading to finish
    await waitFor(() => {
      expect(
        screen.getByRole("button", { name: /fetch recipes/i })
      ).toBeInTheDocument();
    });
  });

  // Test 6: Successful API Response
  it("should display recipes when fetch is successful", async () => {
    // Mock successful API response
    const mockRecipes = {
      recipes: [
        {
          id: 1,
          name: "Chocolate Chip Cookies",
          cuisine: "American",
          prepTimeMinutes: 15,
          cookTimeMinutes: 10,
        },
        {
          id: 2,
          name: "Spaghetti Carbonara",
          cuisine: "Italian",
          prepTimeMinutes: 10,
          cookTimeMinutes: 15,
        },
      ],
    };

    globalThis.fetch = vi.fn(() =>
      Promise.resolve({
        ok: true,
        json: () => Promise.resolve(mockRecipes),
      })
    );

    render(<App />);

    const fetchButton = screen.getByRole("button", { name: /fetch recipes/i });
    await userEvent.click(fetchButton);

    // Assert recipes are displayed
    await waitFor(() => {
      expect(screen.getByText("Recipes:")).toBeInTheDocument();
      expect(screen.getByText("Chocolate Chip Cookies")).toBeInTheDocument();
      expect(screen.getByText("Spaghetti Carbonara")).toBeInTheDocument();
      expect(screen.getByText(/american/i)).toBeInTheDocument();
      expect(screen.getByText(/italian/i)).toBeInTheDocument();
    });
  });

  // Test 7: HTTP Error Handling
  it("should display error message when fetch fails", async () => {
    // Mock failed API response
    globalThis.fetch = vi.fn(() =>
      Promise.resolve({
        ok: false,
        status: 500,
      })
    );

    render(<App />);

    const fetchButton = screen.getByRole("button", { name: /fetch recipes/i });
    await userEvent.click(fetchButton);

    await waitFor(() => {
      expect(
        screen.getByText(/error: failed to fetch recipes/i)
      ).toBeInTheDocument();
    });
  });

  // Test 8: Network Error Handling
  it("should handle network errors gracefully", async () => {
    // Mock network error
    globalThis.fetch = vi.fn(() => Promise.reject(new Error("Network error")));

    render(<App />);

    const fetchButton = screen.getByRole("button", { name: /fetch recipes/i });
    await userEvent.click(fetchButton);

    await waitFor(() => {
      expect(screen.getByText(/error: network error/i)).toBeInTheDocument();
    });
  });
});

// Clean up mocks after each test
afterEach(() => {
  vi.restoreAllMocks();
});
```

## Step 7: Run the Tests

Execute your tests with:

```bash
# Run tests in watch mode
npm test

# Run tests once
npm run test:run

# Run tests with UI
npm run test:ui
```

## Key Testing Concepts Demonstrated

### 1. **Arrange, Act, Assert Pattern**

Each test follows this structure:

- **Arrange**: Set up the test (render component, mock data)
- **Act**: Perform the action being tested (click button, etc.)
- **Assert**: Check the expected outcome

### 2. **API Mocking**

```javascript
globalThis.fetch = vi.fn(() =>
  Promise.resolve({
    ok: true,
    json: () => Promise.resolve(mockData),
  })
);
```

### 3. **Async Testing**

```javascript
await waitFor(() => {
  expect(screen.getByText("Expected Text")).toBeInTheDocument();
});
```

### 4. **User Interaction Testing**

```javascript
const button = screen.getByRole("button", { name: /click me/i });
await userEvent.click(button);
```

### 5. **State Testing**

- Loading states (button disabled, text changes)
- Error states (error messages displayed)
- Success states (data rendered correctly)

## Best Practices Demonstrated

1. **Descriptive test names** that explain what is being tested
2. **Proper cleanup** with `afterEach()` to reset mocks
3. **Testing different scenarios**: success, error, loading states
4. **Using semantic queries** like `getByRole()` instead of generic selectors
5. **Async handling** with `waitFor()` for dynamic content
6. **Comprehensive coverage** of user interactions and edge cases

## Running the Demo

1. Run `npm run test:run` to see all tests pass
2. Experiment with how changing the component breaks tests
3. Inspect the test output and interpret the results

