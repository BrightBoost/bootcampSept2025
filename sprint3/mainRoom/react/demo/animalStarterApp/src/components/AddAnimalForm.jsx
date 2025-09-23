import { useState } from 'react';

function AddAnimalForm({onAddAnimal}) {
    const [newAnimal, setNewAnimal] = useState({});

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddAnimal(newAnimal);
        setNewAnimal({ name: '' });
    }

    return (
     <>
       <input type="text" value={newAnimal.name} onChange={(e) => setNewAnimal({...newAnimal, name: e.target.value})} placeholder="Animal Name" />
       <button type="button" onClick={handleSubmit}>Add Animal</button>
     </>
    );
}

export default AddAnimalForm;