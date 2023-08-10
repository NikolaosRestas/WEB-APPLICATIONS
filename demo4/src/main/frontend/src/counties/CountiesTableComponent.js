import * as React from 'react';
import {useState} from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {Alert, Button} from "@mui/material";
import EditCountyModal from "./EditCountyModal";


export default function CountiesTableComponent({counties, onChange}) {
    const [isEditModalOpen, setIsEditModalOpen] = useState(false);
    const [selectedCounty, setSelectedCounty] = useState(null);
    const [isSuccessfulDelete, setIsSuccessfulDelete] = useState(false);


    function onEdit(county) {
        console.log('Edit county: ', county);
        setSelectedCounty(county);
        setIsEditModalOpen(true);
    }

    function onDelete(county) {
        console.log('I am going to delete county: ', county);
        fetch(`/counties/${county.id}`,
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
                    onChange(counties.filter(c => c.id !== county.id));
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
                                    <Button variant="contained" color="primary"
                                            onClick={() => onDelete(county, counties)}>
                                        Delete
                                    </Button>
                                </TableCell>

                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            {selectedCounty && (
                <EditCountyModal
                    isOpen={isEditModalOpen}
                    onClose={handleCloseEditModal}
                    clientData={selectedCounty}
                />
            )}

            <div className="relative h-32 flex flex-nowrap">
                <div className="absolute inset-x-0 bottom-0 h-16 flex flex-nowrap">
                    {(isSuccessfulDelete === true) && <Alert severity="success">The county deleted successful!</Alert>}
                </div>
            </div>
        </React.Fragment>
    );
}