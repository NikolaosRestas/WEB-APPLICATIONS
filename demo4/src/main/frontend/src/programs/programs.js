import React, {useEffect, useState} from 'react';
import ProgramsTableComponent from "./ProgramsTableComponent";

const ProgramsPage = () => {
    const [programsData, setProgramsData] = useState([]);

    useEffect(() => {
        // Function to fetch program data from the API
        fetch('/programs')
            .then(response => response.json())
            .then(data => {
                setProgramsData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts




    return (
        <div className="container mx-auto mt-8">
            <h3 className="text-3xl font-bold mb-4">Programs</h3>
            <ProgramsTableComponent programs={programsData}/>
        </div>
    );
};

export default ProgramsPage;