import './App.css';
import React, {Component} from 'react';
import Header from "./components/Header";
// import CustomerTable from "./components/CustomerTable";

export default class App extends Component {

    constructor(props) {
        super(props);
        this.state = {"customers": {}};

        fetch("/api/v1/getCustomers", {
            method: "GET",
            headers: {
                // 'Accept': 'application/json', *** I was getting a 404 error when I did the fetch until I commented this out.
                'Content-Type': 'application/json'
            }
        }).then((response) => {
            if (response.status === 200)
                return response.json();
            // throw '400'
        }).then((data) => {
            // console.log(data);
            // this.setState({"customers": JSON.stringify(data)});//.customers = response;
        });
    }

    render () {
        return (
        <div className="App">
            <Header/>
            {/*<CustomerTable customers={this.state.customers}/>*/}
        </div>
        )
    }
}