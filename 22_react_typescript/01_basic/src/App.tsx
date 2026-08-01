import { useState } from "react";
import "./App.css";
import Input from "./components/Input/Input";
import LoadingSpinner from "./components/spinner/LoadingSpinner";

function App() {
    const [name, setName] = useState("");

    return (
        <div className="hero">
            <br />
            <br />
            <br />
            <br />
            <br />
            <div className="card-container">
                <LoadingSpinner />
            </div>
        </div>
    );
}

export default App;
