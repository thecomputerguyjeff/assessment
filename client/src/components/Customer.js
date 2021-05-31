import React, {Component} from "react";
import {get} from "../helper/Fetch";

export default class Customer extends Component {

    constructor(props) {
        super(props);
        this.state = {
            numCustomers: null,
            customers: null
        };
    }

    getCustomers = () => {
        get("api/v1/getCustomers")
            .then(res => {
                if (res.status === 200) {
                    return res.json();
                } else{
                        throw 'not 200'
                    }
                }).then((response) => {
                    console.log(response)
            this.state = {
                numCustomers: response[0],
                customers: response[1]
            }
        })
            .catch(err => {
                this.setState({error: true});
            });
    }

    render() {
        return (
            <div>
                <h3>Customers</h3>
                {this.getCustomers}
                <table>
                </table>
            </div>

        );
    }
}

// the first line means, that you should save the customer list into a state variable that is in App.js
// and then the actual table that you are rendering should be a separate component (like how the header is a separate component called Header)
// and you should pass in the customer list as props into that component