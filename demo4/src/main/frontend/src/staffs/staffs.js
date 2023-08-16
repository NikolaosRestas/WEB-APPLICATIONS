import React, {useEffect, useState} from 'react';
import StaffsTableComponent from "./StaffsTableComponent";
import {Button} from "@mui/material";
import NewStaffModal from "./NewStaffModal";

const StaffsPage = () => {
    const [staffsData, setStaffsData] = useState([]);
    const [isNewStaffModalOpen, setNewStaffModalOpen] = useState(false);

    useEffect(() => {
        // Function to fetch staffs data from the API
        fetch('/staffs')
            .then(response => response.json())
            .then(data => {
                setStaffsData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    useEffect(() => {
        console.log('Meta to add!!!! : ',staffsData);
        setStaffsData(staffsData); // Update local state when the clientData prop changes
    }, [staffsData]);

    function newStaff() {
        setNewStaffModalOpen(true);
    }

    const handleCloseNewStaffModal = () => {
        setNewStaffModalOpen(false);
    };

    const updateStaffs = (staff) => {
        staffsData.push(staff);
        console.log('Meta to add : ',staffsData);
        setStaffsData(staffsData);
    };

    return (
        <div>
            <div className="relative container mx-auto mt-8 w-100">
                <h3 className="text-3xl font-bold mb-4">Staffs</h3>
                <div className="absolute inset-x-0 top-0 h-16 ">
                    <Button variant="contained" color="primary"
                            onClick={() => newStaff()}>
                        New County!
                    </Button>
                </div>
                <StaffsTableComponent staffs={staffsData} onChange={setStaffsData}/>
            </div>

            {isNewStaffModalOpen && (
                <NewStaffModal
                    isOpen={isNewStaffModalOpen}
                    onClose={handleCloseNewStaffModal}
                    onSave={updateStaffs}
                />
            )}
        </div>
    );
};

export default StaffsPage;