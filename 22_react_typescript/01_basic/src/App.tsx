import { useState } from "react";
import "./App.css";
import Input from "./components/Input/Input";

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
                <Input label="Name" value={name} onChange={setName} error="" />
            </div>
        </div>
    );
}

export default App;
