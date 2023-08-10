import React, {useEffect, useState} from 'react';
import {Dialog, DialogTitle, DialogContent, DialogActions, Button, TextField, Alert} from '@mui/material';

export default function DeleteCountyModal({isOpen,onClose,clientData}) {
    const [deletedData, setDeletedData] = useState({...clientData});
    const [isSuccessAlertOpen, setIsSuccessAlertOpen] = useState(false);

    const [counties,setCounties] = useState();


    const onDelete = (county,id) => {
        const updatedCounties = counties.filter((county) => county.id !== id);
        setCounties(updatedCounties);
      };

       fetch(`/counties/${clientData.id}`,
           {
               method: 'DELETE',
               body: JSON.stringify(clientData),
               headers: {
                   'Content-Type': 'application/json'
               },
           })
           .then(response => response.json());


           <div className="relative h-32 flex flex-nowrap">
               <div className="absolute inset-x-0 bottom-0 h-16 flex flex-nowrap">
                   {isSuccessAlertOpen && <Alert severity="success">The client delete was successful!</Alert>}
               </div>
           </div>
   }