import { render, screen } from '@testing-library/react';
import { describe, expect, test } from 'vitest';
import RecipeCard from './RecipeCard';

describe('RecipeCard', () => {
  const recipe = {
    id: 1,
    title: 'Test Recipe Card',
    ingredients: ['Ingredient 1', 'Ingredient 2'],
    instructions: 'Test instructions for the bla.',
  };
  test('renders RecipeCard component', () => {
    render(<RecipeCard recipe={recipe} />);
    const element = screen.getByText(/recipe card/i);
    expect(element).toBeInTheDocument();
  });
});