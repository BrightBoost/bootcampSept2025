function AnimalList({animalList}) {
    return (
        <>
        <h2>Animal list</h2>
        <ul>
            {animalList.map((animal, index) => <li key={index}>{animal.name}</li>)}
        </ul>
        </>
    )
}

export default AnimalList;