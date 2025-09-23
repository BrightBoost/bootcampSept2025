import CoffeeCard from './CoffeeCard';

function CoffeeList({list}) {
    

    return (
        <>
            <h2>Coffees with ratings:</h2>
            <ul>
                {list.map(coffee => (
                    // you can have multiple props or pass the whole object in
                    // propably better to do whole object, just demonstration purposes like this
                    <CoffeeCard rating={coffee.rating} name={coffee.name} />
                ))}
            </ul>
        </>
    )
}

export default CoffeeList;