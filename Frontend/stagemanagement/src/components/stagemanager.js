import React, {
    useState,
    useEffect,
} from 'react';
import axios from 'axios';
import userService from '../services/user.service';

const Stagemanager = (props) => {
    const [stagemanagerDetails, setStagemanagerDetails] = useState(null);
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try{
                const result = await axios.get(userService.getStagemanagerBoard);
                setStagemanagerDetails(result.data);
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

                {stagemanagerDetails !== null &&
                    <h3>Stagemanager Board {stagemanagerDetails.result}</h3>
                }
            
            </header>
        </div>
    )

}

export default Stagemanager;