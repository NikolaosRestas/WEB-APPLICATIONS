import React, {useEffect, useState} from 'react';
import CountiesTableComponent from "./CountiesTableComponent";

const CountiesPage = () => {
    const [countiesData, setCountiesData] = useState([]);

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




    return (
        <div className="container mx-auto mt-8">
            <h3 className="text-3xl font-bold mb-4">Counties</h3>
            <CountiesTableComponent counties={countiesData}/>
        </div>
    );
};

export default CountiesPage;