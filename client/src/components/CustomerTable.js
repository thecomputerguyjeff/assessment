import {Button, Modal, ModalBody, ModalFooter, ModalHeader, Table} from "reactstrap";
import '../css/CustomerTable.css'
import {useState} from "react";


export const CustomerTable = (props) => {

    const [selectedCustomer, setSelectedCustomer] = useState(null);

    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
    });

    const getCustomer = (id) => {
        fetch('http://localhost:8080/api/v1/getCustomer', {
           method: "POST",
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json',
           } ,
            body: JSON.stringify({"customerId": id})
        })
            .then(customer => customer.json())
            .then(res => setSelectedCustomer(res.customer));
    }

    const customerRows = props.customerList.map((c, i) =>
        <tr onClick={() => getCustomer(c.id)}>
            <th scope="row">
                {i+1}
            </th>
            <td>
                {c.name}
            </td>
            <td>
                {c.email}
            </td>
            <td>
                {formatter.format(c.balance)}
            </td>
        </tr>
    )

    return (
        <div className="CustomerTable">
            {selectedCustomer && (
                <Modal isOpen>
                    <ModalHeader>
                        {selectedCustomer.name}
                    </ModalHeader>
                    <ModalBody>
                        <strong>Balance:</strong> {formatter.format(selectedCustomer.balance)}
                        <br /><strong>Created:</strong> {new Date(selectedCustomer.created).toString()}
                        <br /><strong>Delinquent:</strong> {selectedCustomer.delinquent.toString()}
                        <br /><strong>Email:</strong> {selectedCustomer.email}
                        <br /><strong>Description:</strong> {selectedCustomer.description}
                        <br /><strong>Tax Exempt:</strong> {selectedCustomer.tax_exempt}
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => setSelectedCustomer(null)}>
                            Close
                        </Button>
                    </ModalFooter>
                </Modal>
            )}



            <Table dark size="sm">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Email
                    </th>
                    <th>
                        Balance
                    </th>
                </tr>
                </thead>
                <tbody>
                {customerRows}
                </tbody>
            </Table>
        </div>
    )
}