import logo from './logo.svg';
import './App.css';
import Head from "./Head";
import {Button} from "reactstrap";
import React, {useEffect, useState} from 'react';

const App = () => {
    const [testValue, setTestValue] = useState('value has not been set');

    const getTestValue = () => {
        fetch('http://localhost:8080/api/test', {
            method: "GET",
        })
            .then(res => res.json())
            .then(res => setTestValue(res.value));
    }

    return (
        <div className="App">
            <Head></Head>
            <header className="App-header">
                <h1>
                    This is your test value :
                </h1>
                <p>
                    {testValue}
                </p>
                <Button onClick={getTestValue}>GetValue</Button>
            </header>
        </div>
    );
}

export default App;
