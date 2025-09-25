import { render, screen, waitFor } from '@testing-library/react';
import { describe, it, expect, vi, afterEach } from 'vitest';
import userEvent from '@testing-library/user-event';

import App from './App';

describe('App Component', () => {
    it('should render the welcome message', () => {
        // Arrange: Render the App component
        render(<App />);

        // Act: Nothing to act on in this simple test

        // Assert: Check if the welcome message is in the document
        expect(screen.getByText(/welcome/i)).toBeInTheDocument();
    });

    it('should contain a link to the Vite documentation', () => {
        // Arrange: Render the App component
        render(<App />);

        // Act: Nothing to act on in this simple test

        // Assert: Check if the link to the Vite documentation is present
        const linkElement = screen.getByRole('link', { name: /vite documentation/i });
        expect(linkElement).toBeInTheDocument();
        expect(linkElement).toHaveAttribute('href', 'https://vitejs.dev');
    });

    it('should update the text on button click', async () => {
        // Arrange: Render the App component
        render(<App />);

        // Act: Find the button and click it
        const button = screen.getByRole('button', { name: /click me/i });
        await userEvent.click(button);

        // Assert: Check if the text has been updated
        expect(screen.getByText(/button clicked/i)).toBeInTheDocument();
    });

    it('should render the fetch recipes button', () => {
        // Arrange: Render the App component
        render(<App />);

        // Act: Nothing to act on

        // Assert: Check if the fetch recipes button is present
        const fetchButton = screen.getByRole('button', { name: /fetch recipes/i });
        expect(fetchButton).toBeInTheDocument();
        expect(fetchButton).not.toBeDisabled();
    });

    it('should show loading state when fetching recipes', async () => {
        // Arrange: Mock fetch to delay response
        globalThis.fetch = vi.fn(() =>
            new Promise(resolve =>
                setTimeout(() => resolve({
                    ok: true,
                    json: () => Promise.resolve({ recipes: [] })
                }), 100)
            )
        );

        render(<App />);

        // Act: Click the fetch recipes button
        const fetchButton = screen.getByRole('button', { name: /fetch recipes/i });
        await userEvent.click(fetchButton);

        // Assert: Check if loading state is shown
        expect(screen.getByRole('button', { name: /loading.../i })).toBeInTheDocument();
        expect(screen.getByRole('button', { name: /loading.../i })).toBeDisabled();

        // Wait for loading to finish
        await waitFor(() => {
            expect(screen.getByRole('button', { name: /fetch recipes/i })).toBeInTheDocument();
        });
    });

    it('should display recipes when fetch is successful', async () => {
        // Arrange: Mock successful API response
        const mockRecipes = {
            recipes: [
                {
                    id: 1,
                    name: 'Chocolate Chip Cookies',
                    cuisine: 'American',
                    prepTimeMinutes: 15,
                    cookTimeMinutes: 10
                },
                {
                    id: 2,
                    name: 'Spaghetti Carbonara',
                    cuisine: 'Italian',
                    prepTimeMinutes: 10,
                    cookTimeMinutes: 15
                }
            ]
        };

        globalThis.fetch = vi.fn(() =>
            Promise.resolve({
                ok: true,
                json: () => Promise.resolve(mockRecipes)
            })
        );

        render(<App />);

        // Act: Click the fetch recipes button
        const fetchButton = screen.getByRole('button', { name: /fetch recipes/i });
        await userEvent.click(fetchButton);

        // Assert: Check if recipes are displayed
        await waitFor(() => {
            expect(screen.getByText('Recipes:')).toBeInTheDocument();
            expect(screen.getByText('Chocolate Chip Cookies')).toBeInTheDocument();
            expect(screen.getByText('Spaghetti Carbonara')).toBeInTheDocument();
            expect(screen.getByText(/american/i)).toBeInTheDocument();
            expect(screen.getByText(/italian/i)).toBeInTheDocument();
            expect(screen.getByText(/prep time: 15 min/i)).toBeInTheDocument();
            expect(screen.getByText(/cook time: 10 min/i)).toBeInTheDocument();
        });
    });

    it('should display error message when fetch fails', async () => {
        // Arrange: Mock failed API response
        globalThis.fetch = vi.fn(() =>
            Promise.resolve({
                ok: false,
                status: 500
            })
        );

        render(<App />);

        // Act: Click the fetch recipes button
        const fetchButton = screen.getByRole('button', { name: /fetch recipes/i });
        await userEvent.click(fetchButton);

        // Assert: Check if error message is displayed
        await waitFor(() => {
            expect(screen.getByText(/error: failed to fetch recipes/i)).toBeInTheDocument();
        });
    });

    it('should handle network errors gracefully', async () => {
        // Arrange: Mock network error
        globalThis.fetch = vi.fn(() =>
            Promise.reject(new Error('Network error'))
        );

        render(<App />);

        // Act: Click the fetch recipes button
        const fetchButton = screen.getByRole('button', { name: /fetch recipes/i });
        await userEvent.click(fetchButton);

        // Assert: Check if error message is displayed
        await waitFor(() => {
            expect(screen.getByText(/error: network error/i)).toBeInTheDocument();
        });
    });
});

// Clean up after each test
afterEach(() => {
    vi.restoreAllMocks();
});
