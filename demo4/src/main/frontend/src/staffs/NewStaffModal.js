import React, {useEffect, useState} from 'react';
import {Alert, Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField,MenuItem,Select} from '@mui/material';

export default function NewStaffModal({isOpen, onClose, onSave}) {
    const [staff, setStaff] = useState({name: ""});
    const [isSuccessAlertOpen, setIsSuccessAlertOpen] = useState(false);
    const[gymsData,setGymsData] = useState([]);

     useEffect(() => {
        fetch('/gyms')
            .then(response => response.json())
            .then(data => {
                setGymsData(data);
            })
            .catch(error => {
                console.error('Error fetching gyms:', error);
            });
    }, []);

    useEffect(() => {
        setStaff({...staff}); // Update local state when the clientData prop changes
    }, [staff]);

    const handleSave = () => {
        fetch(`/staffs/add`,
            {
                method: 'POST',
                body: JSON.stringify(staff),
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

        console.log("Save changes:", staff);
        onClose(); // Close the modal after saving (you can modify this based on your requirements).
    };

    const handleCancel = () => {
        onClose(); // Close the modal without saving.
    };

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setStaff((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    return (
        <React.Fragment>
            <Dialog open={isOpen} onClose={onClose}>
                <DialogTitle>New Staff</DialogTitle>
                <DialogContent>
                    <TextField
                        label="Staff Name"
                        name="name"
                        value={staff.name}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                     <TextField
                        label="Specialty"
                        name="specialty"
                        value={staff.specialty}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Phone"
                        name="phone"
                        value={staff.phone}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Gender"
                        name="gender"
                        value={staff.gender}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    />
                    <Select
                        label="Gym"
                        name="gymId"
                        value={staff.gymId || 'default'}
                        onChange={(e) => handleInputChange(e)}
                        fullWidth
                        margin="normal"
                    >
                        <MenuItem value="default" disabled>Select a Gym</MenuItem>
                        {
                            gymsData.map((gym) => (
                                <MenuItem key={gym.id} value={gym.id}> {gym.name} </MenuItem>))
                        }
                    </Select>

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
                    {isSuccessAlertOpen && <Alert severity="success">The staff added successfully!</Alert>}
                </div>
            </div>
        </React.Fragment>
    );
}