import './App.css';
import {useEffect, useState} from "react";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Head from "./components/Head";
import {CustomInput} from "reactstrap";

const App = () => {

    const [customer, setCustomer] = useState('');
    useEffect(() => {
        const customer = JSON.parse(localStorage.getItem('customer'));
        setCustomer(customer);
    }, []);

    const [head, setHead] = useState('');
    useEffect(() => {
        const head = JSON.parse(localStorage.getItem('head'));
            setHead(head);
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <Head showHeader={head!==''} setHead={setHead} head={head}/>
            </header>
            <body>
            <Head showCustomer={customer!==''} setCustomer={setCustomer} customer={customer}/>
            </body>

        </div>
    );
}
export default App;


