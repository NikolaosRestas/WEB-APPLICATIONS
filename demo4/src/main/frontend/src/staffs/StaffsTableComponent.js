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
import EditStaffModal from "./EditStaffModal";


export default function StaffsTableComponent({staffs}) {

    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedClient, setSelectedClient] = useState(null);

    function onEdit(staff) {
        console.log('Ekana click to staff: ', staff);
        setSelectedClient(staff);
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
                            <TableCell align="right">Specialty</TableCell>
                            <TableCell align="right">Phone</TableCell>
                            <TableCell align="right">Gender</TableCell>
                            <TableCell align="right">Gym</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {staffs.map((staff) => (
                            <TableRow
                                key={staff.id}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {staff.id}
                                </TableCell>
                                <TableCell align="right">{staff.name}</TableCell>
                                <TableCell align="right">{staff.specialty}</TableCell>
                                <TableCell align="right">{staff.phone}</TableCell>
                                <TableCell align="right">{staff.gender}</TableCell>
                                <TableCell align="right">{staff.gym}</TableCell>
                                <TableCell align="right">
                                    <Button variant="contained" color="primary" onClick={() => onEdit(staff)}>
                                        Edit
                                    </Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            {selectedClient && (
                    <EditStaffModal
                        isOpen={isEditModalOpen}
                        onClose={handleCloseEditModal}
                        clientData={selectedClient}
                    />
                )}
        </React.Fragment>
    );
}