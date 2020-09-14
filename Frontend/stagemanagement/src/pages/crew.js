import React, {
    useState,
    useEffect,
} from 'react';

import axios from 'axios';
import userService from '../services/user.service';

const Crew = () => {
    const [crewDetails, setCrewDetails] = useState(null);
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try{
                const result = await axios.get(userService.getCrewBoard);
                setCrewDetails(result.data);
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

                {crewDetails !== null &&
                    <h3>Crewboard {crewDetails.result}</h3>
                }         
            </header>
        </div>  
    )
}

export default Crew;