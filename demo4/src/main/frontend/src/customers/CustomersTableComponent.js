import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {Button} from "@mui/material";
import {useState} from "react";
import EditCustomerModal from "./EditCustomerModal";


export default function CustomersTableComponent({customers}) {

    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedClient, setSelectedClient] = useState(null);

    function onEdit(customer) {
        console.log('Ekana click to customer: ', customer);
        setSelectedClient(customer);
        setIsEditModalOpen(true);
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
                                <TableCell align="right">
                                    <Button variant="contained" color="primary" onClick={() => onEdit(customer)}>
                                        Edit
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
        </React.Fragment>
    );
}