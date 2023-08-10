import React, {useEffect, useState} from 'react';
import StaffsTableComponent from "./StaffsTableComponent";

const StaffsPage = () => {
    const [staffsData, setStaffsData] = useState([]);

    useEffect(() => {
        // Function to fetch program data from the API
        fetch('/staffs')
            .then(response => response.json())
            .then(data => {
                setStaffsData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts




    return (
        <div className="container mx-auto mt-8">
            <h3 className="text-3xl font-bold mb-4">Staffs</h3>
            <StaffsTableComponent staffs={staffsData}/>
        </div>
    );
};

export default StaffsPage;