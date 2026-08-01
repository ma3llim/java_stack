import Button from "./components/Button/Button";

function App() {
    const handleOnClick = () => {
        console.log("Handle On Click");
    };
    return (
        <div className="hero">
            <br />
            <br />
            <br />
            <br />
            <br />
            <Button onClick={handleOnClick} variant="secondary">
                Submit
            </Button>
        </div>
    );
}

export default App;
