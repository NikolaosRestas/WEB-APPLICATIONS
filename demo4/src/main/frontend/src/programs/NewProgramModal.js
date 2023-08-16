import React, {useEffect, useState} from 'react';
import {Alert, Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from '@mui/material';

export default function NewProgramModal({isOpen, onClose, onSave}) {
    const [program, setProgram] = useState({name: ""});
    const [isSuccessAlertOpen, setIsSuccessAlertOpen] = useState(false);

    useEffect(() => {
        setProgram({...program}); // Update local state when the clientData prop changes
    }, [program]);

    const handleSave = () => {
        fetch(`/programs/add`,
            {
                method: 'POST',
                body: JSON.stringify(program),
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => response.json())
            .then((data) => {
                onSave(data);
                setIsSuccessAlertOpen(true);
                setTimeout(() => {
                    setIsSuccessAlertOpen(false);
                }, 5000);
            })
            .catch((error) => {
                console.error('Error while calling the API:', error);
            });

        console.log("Save changes:", program);
        onClose(); // Close the modal after saving (you can modify this based on your requirements).
    };

    const handleCancel = () => {
        onClose(); // Close the modal without saving.
    };

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setProgram((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    return (
        <React.Fragment>
            <Dialog open={isOpen} onClose={onClose}>
                <DialogTitle>New Program</DialogTitle>
                <DialogContent>
                    <TextField
                        label="Program Name"
                        name="name"
                        value={program.name}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Price"
                        name="price"
                        value={program.price}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Customers"
                        name="customers"
                        value={program.customers}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleCancel}>Cancel</Button>
                    <Button onClick={handleSave} color="primary">
                        Save
                    </Button>
                </DialogActions>
            </Dialog>

            <div className="relative h-32 flex flex-nowrap">
                <div className="absolute inset-x-0 bottom-0 h-16 flex flex-nowrap">
                    {isSuccessAlertOpen && <Alert severity="success">The program added successfully!</Alert>}
                </div>
            </div>
        </React.Fragment>
    );
}