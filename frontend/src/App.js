import React, { useState } from "react";
import logo from './logo.svg';
import './App.css';
import { Archive } from "./Archive";
import { Home } from "./Home";

function App() {
    const [currentForm, setCurrentForm] = useState('home');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    return (
        <div className="App">
        {
            {
                'archive': <Archive onFormSwitch={toggleForm} />,
                'home': <Home onFormSwitch={toggleForm} />,

            }[currentForm]
        }
        </div>
    );
}

export default App;
