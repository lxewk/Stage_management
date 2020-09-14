import React, {
    useState,
    useEffect,
} from 'react';

import axios from 'axios';
import userService from '../services/user.service';
import AuthService from '../services/auth.service';

const Dashboard = () => {
    const [dashboardDetails, setDashboardDetails] = useState(null);
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    const logout = () => {
        AuthService.logout();
    }

    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try{
                const result = await axios.get(userService.getDashboardBoard);
                setDashboardDetails(result.data);
                toggleLoading(false);
            } catch(error){
                setError(error);
                toggleLoading(false);
            }
        }
        fetchData();
    }, []);

    return(
        <div>
            <header>
                {error !== null && <p>Something went wrong: {error}</p>}
                {loading === true && <p>Loading...</p>}

                {dashboardDetails !== null &&
                    <h3>Dashboard board {dashboardDetails.result}</h3>
                }         
            </header>
            {/* // check of een user ingelogd is , zo ja laat button zien */}
            <button type="button" onClick={logout}>
                Log out
            </button>
        </div>  
    )
}

export default Dashboard;