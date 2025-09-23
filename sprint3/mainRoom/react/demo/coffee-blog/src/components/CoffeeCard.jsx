function CoffeeCard({name, rating}) {
    return (
        <>
        <li>
            <p>{name}</p>
            <p>{rating > 4.5 ? "⭐" : "👎"}</p>
        </li>
        </>
    )
}

export default CoffeeCard;