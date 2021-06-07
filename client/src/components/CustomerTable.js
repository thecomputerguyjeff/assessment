import React from 'react';
import {Table} from 'reactstrap';
import "./CustomerTable.css"

const CustomerTable = (props) => {

    function getTableKeys() {
        return Object.keys(this.props.data[0]);
    }

    function getRowsData() {
        const keys = getTableKeys();
        return keys.map((key, index) => {
            return <th key={key}> {key.toUpperCase()} </th>
        });
    }

    return (
        <Table className="customerTable" data={this.props.customers} dark striped hover bordered>
            <thead>
            <h1> Customers </h1>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone Number</th>
            </tr>
            </thead>

            <tbody>
            {getRowsData()}


            {/*{fillCustomerTable()}*/}
            {/*<tr>*/}
            {/*    <th scope="row">1</th>*/}
            {/*    <td>Mark</td>*/}
            {/*    <td>Otto</td>*/}
            {/*    <td>@mdo</td>*/}
            {/*</tr>*/}
            {/*<tr>*/}
            {/*    <th scope="row">2</th>*/}
            {/*    <td>Jacob</td>*/}
            {/*    <td>Thornton</td>*/}
            {/*    <td>@fat</td>*/}
            {/*</tr>*/}
            {/*<tr>*/}
            {/*    <th scope="row">3</th>*/}
            {/*    <td>Larry</td>*/}
            {/*    <td>the Bird</td>*/}
            {/*    <td>@twitter</td>*/}
            {/*</tr>*/}
            </tbody>
        </Table>
    )

};

export default CustomerTable;