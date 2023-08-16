import React, {useEffect, useState} from 'react';
import CustomersTableComponent from "./CustomersTableComponent";
import {Button} from "@mui/material";
import NewCustomerModal from "./NewCustomerModal";

const CustomersPage = () => {
    const [customersData, setCustomersData] = useState([]);
    const [isNewCustomerModalOpen, setNewCustomerModalOpen] = useState(false);

    useEffect(() => {
        // Function to fetch customers data from the API
        fetch('/customers')
            .then(response => response.json())
            .then(data => {
                setCustomersData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    useEffect(() => {
        console.log('Meta to add!!!! : ',customersData);
        setCustomersData(customersData); // Update local state when the clientData prop changes
    }, [customersData]);

    function newCustomer() {
        setNewCustomerModalOpen(true);
    }

    const handleCloseNewCustomerModal = () => {
        setNewCustomerModalOpen(false);
    };

    const updateCustomers = (customer) => {
        customersData.push(customer);
        console.log('Meta to add : ',customersData);
        setCustomersData(customersData);
    };

    return (
        <div>
            <div className="relative container mx-auto mt-8 w-100">
                <h3 className="text-3xl font-bold mb-4">Customers</h3>
                <div className="absolute inset-x-0 top-0 h-16 ">
                    <Button variant="contained" color="primary"
                            onClick={() => newCustomer()}>
                        New Customer!
                    </Button>
                </div>
                <CustomersTableComponent customers={customersData} onChange={setCustomersData}/>
            </div>

            {isNewCustomerModalOpen && (
                <NewCustomerModal
                    isOpen={isNewCustomerModalOpen}
                    onClose={handleCloseNewCustomerModal}
                    onSave={updateCustomers}
                />
            )}
        </div>
    );
};

export default CustomersPage;
