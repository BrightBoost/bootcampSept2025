import { useState } from 'react';

function AddCoffeeForm({ onAddCoffee }) {
    // state for a new coffee entry
    const [newCoffee, setNewCoffee] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewCoffee(prevCoffee => ({
            ...prevCoffee,
            [name]: value
        }));
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        if (newCoffee.name && newCoffee.rating) {
            onAddCoffee(newCoffee);
            setNewCoffee({});
        }

    }

    // render a form that updates the new coffee state on change
    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" placeholder="Coffee name" value={newCoffee.name || ''} onChange={handleChange} />
            <input type="text" name="rating" placeholder="Coffee rating" value={newCoffee.rating || ''} onChange={handleChange} />
            <button type="submit">Add Coffee</button>
        </form>
    )
    // and on submit adds the new coffee to the list of coffees in App.jsx

}

export default AddCoffeeForm;