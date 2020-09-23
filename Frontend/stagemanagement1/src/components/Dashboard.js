import React, { useContext } from "react";
import { AuthContext } from '../App'; 


export const Dashboard = () => {
    const { state: authState } = useContext(AuthContext);

    return (
        <div>
            <h1>DASHBOARD</h1>
            
        </div>
    );   
};

export default Dashboard;