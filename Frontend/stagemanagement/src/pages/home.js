import React, {
    useState,
    useEffect,
} from 'react';

import axios from 'axios';
import userService from '../services/user.service';


const Home = () => {
    const [content, setContent] = useState("");
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try{
                const result = await axios.get(userService.getHomeContent);
                setContent(result.data);
                toggleLoading(false);
            } catch(error){
                setError(error);
                toggleLoading(false);
            }
        }
        fetchData();
    }, []);

    return (
        <div className="home">
          
            <h3>{ content }</h3>
          
        </div>
      );
}

export default Home;