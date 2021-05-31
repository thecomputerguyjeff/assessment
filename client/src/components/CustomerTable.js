import React from "react";
import {get} from "../helper/fetch";
import {Component} from "react/cjs/react.production.min";

export default class CustomerInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userDatabase: null
        };
    }

    getCustomers = () => {

        get("api/v1/CustomerName"
        ).then(res => {
            if (res.status === 200)
                return res.json();
            throw 'not 200'
        })
            .then((response) => {
                this.setState({userDatabase: response})

            })
            .catch(err => {

            });
    }

    render() {
        return (

            <Table>
                <thead>
                <tr>
                    <th>id</th>
                </tr>
                </thead>
                <tbody>
                {this.getCustomers()}
                {this.state.userDatabase != null && this.state.userDatabase.map
                ((listValue, index) => {
                    return (
                        <tr key={index}>
                            <td>{listValue.id}</td>
                        </tr>
                    );
                })}


                </tbody>
            </Table>
        );
    }
}