import React, {useEffect, useState} from 'react';
import CustomersTableComponent from "./CustomersTableComponent";

const CustomersPage = () => {
    const [customersData, setCustomersData] = useState([]);

    useEffect(() => {
        // Function to fetch gyms data from the API
        fetch('/customers')
            .then(response => response.json())
            .then(data => {
                setCustomersData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts




    return (
        <div className="container mx-auto mt-8">
            <h3 className="text-3xl font-bold mb-4">Customers</h3>
            <CustomersTableComponent customers={customersData}/>
        </div>
    );
};

export default CustomersPage;
