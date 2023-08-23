import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {Alert,Button} from "@mui/material";
import {useState} from "react";
import EditCustomerModal from "./EditCustomerModal";


export default function CustomersTableComponent({customers,onChange}) {

    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedClient, setSelectedClient] = useState(null);
    const [isSuccessfulDelete, setIsSuccessfulDelete] = useState(false);

    function onEdit(customer) {
        console.log('Edit customer: ', customer);
        setSelectedClient(customer);
        setIsEditModalOpen(true);
    }

    function onDelete(customer) {
        console.log('I am going to delete customer: ', customer);
        fetch(`/customers/${customer.id}`,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    setIsSuccessfulDelete(true);
                    setTimeout(() => {
                        setIsSuccessfulDelete(false);
                    }, 5000);
                    onChange(customers.filter(c => c.id !== customer.id));
                }
            });
    }

    const handleCloseEditModal = () => {
        setIsEditModalOpen(false);
    };

    return (
        <React.Fragment>
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Id</TableCell>
                            <TableCell align="right">Name</TableCell>
                            <TableCell align="right">Address</TableCell>
                            <TableCell align="right">Email</TableCell>
                            <TableCell align="right">Phone</TableCell>
                            <TableCell align="right">Gym</TableCell>
                            <TableCell align="right">Actions</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {customers.map((customer) => (
                            <TableRow
                                key={customer.id}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {customer.id}
                                </TableCell>
                                <TableCell align="right">{customer.name}</TableCell>
                                <TableCell align="right">{customer.address}</TableCell>
                                <TableCell align="right">{customer.email}</TableCell>
                                <TableCell align="right">{customer.phone}</TableCell>
                                <TableCell align="right">{customer.gym.name}</TableCell>
                                <TableCell align="right">

                                    <Button variant="contained" color="primary" onClick={() => onEdit(customer)}>
                                        Edit
                                    </Button>
                                </TableCell>

                                 <TableCell align="left">
                                    <Button variant="contained" color="primary"
                                            onClick={() => onDelete(customer, customers)}>
                                        Delete
                                    </Button>
                                </TableCell>


                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            {selectedClient && (
                    <EditCustomerModal
                        isOpen={isEditModalOpen}
                        onClose={handleCloseEditModal}
                        clientData={selectedClient}
                    />
                )}

                <div className="relative h-32 flex flex-nowrap">
                    <div className="absolute inset-x-0 bottom-0 h-16 flex flex-nowrap">
                        {(isSuccessfulDelete === true) && <Alert severity="success">The customer deleted successful!</Alert>}
                    </div>
                </div>
        </React.Fragment>
    );
}