import React, {Component, useEffect} from "react";
import {Table} from "reactstrap";
import {get} from "../helper/Fetch";

export default class CustomerTable extends Component {

    constructor(props) {
        super(props);
        this.state = {
            customerList: null
        };
    }

    getCustomers = () => {

        get("api/v1/getCustomers"
        ).then(res => {
            if (res.status === 200)
                return res.json();
            throw 'not 200'
        })
            .then((response) => {
                this.setState({customerList: response})

            })
            .catch(err => {

            });
    }

    render() {
        return (

            <Table>
                {}
                <thead>
                <tr>
                    <th>id</th>

                </tr>
                </thead>
                <tbody>
                {this.getCustomers()}
                {this.state.customerList != null && this.state.customerList.map
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
