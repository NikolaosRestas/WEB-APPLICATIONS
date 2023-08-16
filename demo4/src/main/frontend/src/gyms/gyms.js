import React, {useEffect, useState} from 'react';
import GymsTableComponent from "./GymsTableComponent";
import {Button} from "@mui/material";
import NewGymModal from "./NewGymModal";

const GymsPage = () => {
    const [gymsData, setGymsData] = useState([]);
    const [isNewGymModalOpen, setNewGymModalOpen] = useState(false);

    useEffect(() => {
        // Function to fetch gyms data from the API
        fetch('/gyms')
            .then(response => response.json())
            .then(data => {
                setGymsData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    useEffect(() => {
        console.log('Meta to add!!!! : ',gymsData);
        setGymsData(gymsData); // Update local state when the clientData prop changes
    }, [gymsData]);

    function newGym() {
        setNewGymModalOpen(true);
    }

    const handleCloseNewGymModal = () => {
        setNewGymModalOpen(false);
    };

    const updateGyms = (gym) => {
        gymsData.push(gym);
        console.log('Meta to add : ',gymsData);
        setGymsData(gymsData);
    };

    return (

        <div>
            <div className="relative container mx-auto mt-8 w-100">
                <h3 className="text-3xl font-bold mb-4">Gyms</h3>

                <div className="absolute inset-x-0 top-0 h-16 ">
                    <Button variant="contained" color="primary"
                            onClick={() => newGym()}>
                        New Gym!
                    </Button>
                </div>

                <GymsTableComponent gyms={gymsData} onChange={setGymsData}/>
            </div>



            {isNewGymModalOpen && (
                <NewGymModal
                    isOpen={isNewGymModalOpen}
                    onClose={handleCloseNewGymModal}
                    onSave={updateGyms}
                />
            )}
        </div>

    );
};

export default GymsPage;