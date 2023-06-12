import React, { useState } from "react";
import axios from 'axios';

export const Archive = (props) => {
    const [id, setId] = useState("");

    async function archiveTweets(event) {
        event.preventDefault();
        const reqBody = {
            id: id,
        };
        const body = JSON.stringify(reqBody);
        const headers = {
            'Content-Type': 'application/json',
            };
        try {
            let response = await axios.get('http://localhost:8080/archive', body, { headers });
        } catch(exception) {
            alert("Request failed");
        }
    }

    return (
        <div className="auth-form-container">
            <h2>Archive Tweets</h2>
            <form className="login-form" onSubmit={(event) => archiveTweets(event)}>
                <label htmlFor="id">Converted Twitter User ID of user you wish to archive tweets from: </label>
                <input
                    value={id}
                    onChange={(event) => setId(event.target.value)}
                    type="id"
                    placeholder="Enter the converted id of user "
                    id="id"
                    name="id" />
                <button type="submit">Submit</button>
            </form>
            <button className="home-button" onClick={() => props.onFormSwitch('home')}>Back to Home</button>
        </div>
    )
}