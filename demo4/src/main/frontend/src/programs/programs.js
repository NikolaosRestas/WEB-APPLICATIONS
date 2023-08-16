import React, {useEffect, useState} from 'react';
import ProgramsTableComponent from "./ProgramsTableComponent";
import {Button} from "@mui/material";
import NewProgramModal from "./NewProgramModal";

const ProgramsPage = () => {
    const [programsData, setProgramsData] = useState([]);
    const [isNewProgramModalOpen, setNewProgramModalOpen] = useState(false);

    useEffect(() => {
        // Function to fetch programs data from the API
        fetch('/programs')
            .then(response => response.json())
            .then(data => {
                setProgramsData(data);
            });

        return () => {
            // Any cleanup code can go here
        };
    }, []); // Empty dependency array means this effect runs only once when the component mounts

    useEffect(() => {
        console.log('Meta to add!!!! : ',programsData);
        setProgramsData(programsData); // Update local state when the clientData prop changes
    }, [programsData]);

    function newProgram() {
        setNewProgramModalOpen(true);
    }

    const handleCloseNewProgramModal = () => {
        setNewProgramModalOpen(false);
    };

    const updatePrograms = (program) => {
        programsData.push(program);
        console.log('Meta to add : ',programsData);
        setProgramsData(programsData);
    };

    return (
        <div>
            <div className="relative container mx-auto mt-8 w-100">
                <h3 className="text-3xl font-bold mb-4">Programs</h3>
                <div className="absolute inset-x-0 top-0 h-16 ">
                    <Button variant="contained" color="primary"
                            onClick={() => newProgram()}>
                        New Program!
                    </Button>
                </div>
                <ProgramsTableComponent programs={programsData} onChange={setProgramsData}/>
            </div>

            {isNewProgramModalOpen && (
                <NewProgramModal
                    isOpen={isNewProgramModalOpen}
                    onClose={handleCloseNewProgramModal}
                    onSave={updatePrograms}
                />
            )}
        </div>
    );
};

export default ProgramsPage;