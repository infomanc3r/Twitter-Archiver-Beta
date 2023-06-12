import React, { useState } from "react";

export const Register = (props) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [date, setDate] = useState('');

    const handleSubmit = (event) => {
            event.preventDefault();
            console.log(username);
            console.log(password);
            console.log(date);
        }

    return (
        <div className="auth-form-container">
            <h2>Register</h2>
            <form className="register-form" onSubmit={(event) => handleSubmit(event)}>
                <label htmlFor="username">Username: </label>
                    <input
                        value={username}
                        onChange={(event) => setUsername(event.target.value)}
                        type="username"
                        placeholder="Enter your username"
                        id="username"
                        name="username" />
                <label htmlFor="password">Password: </label>
                    <input
                        value={password}
                        onChange={(event) => setPassword(event.target.value)}
                        type="password"
                        placeholder="Enter your password"
                        id="password"
                        name="password" />
                <label htmlFor="date">Cohort Start Date: </label>
                    <input
                        value={date}
                        onChange={(event) => setDate(event.target.value)}
                        name="date"
                        id="date"
                        placeholder="Enter your start date:" />
                <button type="submit">Register</button>
            </form>
            <button className="link-button" onClick={() => props.onFormSwitch('login')}>Already have an account? Login here.</button>
            <button className="home-button" onClick={() => props.onFormSwitch('home')}>Back to Home</button>
        </div>
    )
}