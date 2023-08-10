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
import EditCountyModal from "./EditCountyModal";
import DeleteCountyModal from "./DeleteCountyModal";


export default function CountiesTableComponent({counties}) {

    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedClient, setSelectedClient] = useState(null);
    const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);

    const initialState=[{counties}];

    function onEdit(county) {
        console.log('Edit county: ', county);
        setSelectedClient(county);
        setIsEditModalOpen(true);
    }

    function onDelete(county,id) {
        console.log('Delete county: ', county);
        setSelectedClient(county.id);
        setIsDeleteModalOpen(true);


    }

    const handleCloseEditModal = () => {
        setIsEditModalOpen(false);
    };

    const handleCloseDeleteModal = () => {
            setIsDeleteModalOpen(false);
        };

    return (
        <React.Fragment>
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Id</TableCell>
                            <TableCell align="right">Name</TableCell>

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {counties.map((county) => (
                            <TableRow
                                key={county.id}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {county.id}
                                </TableCell>
                                <TableCell align="right">{county.name}</TableCell>

                                <TableCell align="right">
                                    <Button variant="contained" color="primary" onClick={() => onEdit(county)}>
                                        Edit
                                    </Button>
                                </TableCell>

                                <TableCell align="left">
                                    <Button variant="contained" color="primary" onClick={() => onDelete(county.id)}>
                                        Delete
                                    </Button>
                                </TableCell>

                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            {selectedClient && (
                    <EditCountyModal
                        isOpen={isEditModalOpen}
                        onClose={handleCloseEditModal}
                        clientData={selectedClient}
                    />
                )}


                {selectedClient && (
                    <DeleteCountyModal
                        isOpen={isDeleteModalOpen}
                        onClose={handleCloseDeleteModal}
                        clientData={selectedClient}
                    />
                )}
        </React.Fragment>
    );
}