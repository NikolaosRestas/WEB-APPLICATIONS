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
import EditGymModal from "./EditGymModal";


export default function GymsTableComponent({gyms}) {

    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedClient, setSelectedClient] = useState(null);

    function onEdit(gym) {
        console.log('Ekana click to gym: ', gym);
        setSelectedClient(gym);
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
                            <TableCell align="right">County</TableCell>

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {gyms.map((gym) => (
                            <TableRow
                                key={gym.id}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {gym.id}
                                </TableCell>
                                <TableCell align="right">{gym.name}</TableCell>
                                <TableCell align="right">{gym.address}</TableCell>
                                <TableCell align="right">{gym.county}</TableCell>

                                <TableCell align="right">
                                    <Button variant="contained" color="primary" onClick={() => onEdit(gym)}>
                                        Edit
                                    </Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            {selectedClient && (
                    <EditGymModal
                        isOpen={isEditModalOpen}
                        onClose={handleCloseEditModal}
                        clientData={selectedClient}
                    />
                )}
        </React.Fragment>
    );
}