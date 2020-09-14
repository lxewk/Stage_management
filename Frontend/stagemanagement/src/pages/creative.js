import React, {
    useState,
    useEffect,
} from 'react';
import { LogContext } from '../context/LoginProvider';
import axios from 'axios';
import userService from '../services/user.service';

const Creative = (props) => {
    const [creativeDetails, setCreativeDetails] = useState(null);
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try{
                const result = await axios.get(userService.getCreativeBoard);
                setCreativeDetails(result.data);
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

                {creativeDetails !== null &&
                    <h3>Creativeboard {creativeDetails.result}</h3>
                }         
            </header>
        </div>  
    )
}

export default Creative;