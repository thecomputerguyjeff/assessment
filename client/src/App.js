import logo from './logo.svg';
import './css/App.css';
import {Button} from "reactstrap";
import {useEffect, useState} from "react";
import {Header} from "./components/Header";
import {CustomerTable} from "./components/CustomerTable";

const App = () => {
    const [testValue, setTestValue] = useState('value has not been set');
    const [customerList, setCustomerList] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/getCustomers')
            .then(customers => customers.json())
            .then(customers => setCustomerList(customers.customerList))
    }, [])

    const getTestValue = () => {
        fetch('http://localhost:8080/api/test', {
            method: "GET",
        })
            .then(res => res.json())
            .then(res => setTestValue(res.value));
    }

    return (
        <div className="App">
            <Header />
            <CustomerTable customerList={customerList}/>
        </div>
    );
};

export default App;
