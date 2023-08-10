import React, {useEffect, useState} from 'react';
import CountiesTableComponent from "./CountiesTableComponent";
import {Button} from "@mui/material";
import NewCountyModal from "./NewCountyModal";

const CountiesPage = () => {
    const [countiesData, setCountiesData] = useState([]);
    const [isNewCountyModalOpen, setNewCountyModalOpen] = useState(false);

    useEffect(() => {
        // Function to fetch counties data from the API
        fetch('/counties')
            .then(response => response.json())
            .then(data => {
                setCountiesData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    useEffect(() => {
        console.log('Meta to add!!!! : ',countiesData);
        setCountiesData(countiesData); // Update local state when the clientData prop changes
    }, [countiesData]);

    function newCounty() {
        setNewCountyModalOpen(true);
    }

    const handleCloseNewCountyModal = () => {
        setNewCountyModalOpen(false);
    };

    const updateCounties = (county) => {
        countiesData.push(county);
        console.log('Meta to add : ',countiesData);
        setCountiesData(countiesData);
    };

    return (
        <div>
            <div className="relative container mx-auto mt-8 w-100">
                <h3 className="text-3xl font-bold mb-4">Counties</h3>
                <div className="absolute inset-x-0 top-0 h-16 ">
                    <Button variant="contained" color="primary"
                            onClick={() => newCounty()}>
                        New County!
                    </Button>
                </div>
                <CountiesTableComponent counties={countiesData} onChange={setCountiesData}/>
            </div>

            {isNewCountyModalOpen && (
                <NewCountyModal
                    isOpen={isNewCountyModalOpen}
                    onClose={handleCloseNewCountyModal}
                    onSave={updateCounties}
                />
            )}
        </div>
    );
};

export default CountiesPage;