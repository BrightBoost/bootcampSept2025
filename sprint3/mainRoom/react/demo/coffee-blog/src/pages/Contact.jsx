import { useNavigate } from "react-router-dom"

export default function Contact() {
    const navigate = useNavigate();
    return (
        <>
            <p>Contact me!</p>
            <button onClick={() => navigate(-1)}>Go back!</button>
        </>
    )
}