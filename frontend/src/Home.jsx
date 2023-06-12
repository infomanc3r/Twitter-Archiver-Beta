import React, { useState } from "react";

export const Home = (props) => {

    function Card1() {
    return (
        <div className="card1">
            <div className="card-body">
                <img src="card1-small.png" alt="card" onClick={() => props.onFormSwitch('archive')}></img>
                <h1 className="card-header">Archive Tweets by User</h1>
            </div>
        </div>
        );
    }

    function Card2() {
        return (
            <div className="card2gray">
                <div className="card-body-gray">
                    <img src="card2-small-gray.png" alt="card"></img>
                    <h1 className="card-header-gray">Archive Followers by User (Coming Soon)</h1>
                </div>
            </div>
            );
        }

    function Card3() {
        return (
            <div className="card3gray">
                <div className="card-body-gray">
                    <img src="card3-small-gray.png" alt="card"></img>
                    <h1 className="card-header-gray">Archive Likes by Tweet (Coming Soon)</h1>
                </div>
            </div>
            );
        }
    return (
            <div className="home-container">
                <div className="banner-container">
                    Twitter Archiver Beta
                </div>
                <div className="card-container">
                    <Card1 />
                    <Card2 />
                    <Card3 />
                </div>
            </div>
    )
}