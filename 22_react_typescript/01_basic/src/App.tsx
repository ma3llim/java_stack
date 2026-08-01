import Card from "./components/card/Card";
import "./App.css";

function App() {
    return (
        <div className="hero">
            <br />
            <br />
            <br />
            <br />
            <br />
            <div className="card-container">
                <Card title="Testing Title" description="description testing" imageUrl="https://placehold.co/250x200" />
                <Card title="Testing Title" description="description testing" imageUrl="https://placehold.co/250x200" />
                <Card title="Testing Title" description="description testing" imageUrl="https://placehold.co/250x200" />
            </div>
        </div>
    );
}

export default App;
