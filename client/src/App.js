import logo from './logo.svg';
import './App.css';
import {Button} from "reactstrap";
import {useState} from "react";
import Header from "./HeaderandCustomerTable/Header";
import CustomerTable from "./HeaderandCustomerTable/CustomerTable";



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
            <Header/>
            <CustomerTable/>

        </div>
    );
}

export default App;