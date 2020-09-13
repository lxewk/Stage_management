import React, {
    useState,
    useEffect,
} from 'react';
import axios from 'axios';
import AuthService from '../services/auth.service';

const Account = () => {
    const [currentUser, setCurrentUser] = useState(null);

    useEffect(() => {
        const fetchData = () => {
            const result = AuthService.getCurrentUser;
            setCurrentUser(result);
        }
        fetchData();
    }, []);

    return(
        <div>
            <header>
                <h3>
                    <strong>{currentUser.username}</strong> Account
                </h3>
            </header>
            <p>
            <strong>Token:</strong>{" "}
            {currentUser.accessToken.substring(0, 20)} ...{" "}
            {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
            </p>
            <p>
            <strong>Id:</strong>{" "}
            {currentUser.id}
            </p>
            <strong>Authorities:</strong>
            <ul>
            {currentUser.roles &&
                currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
            </ul>
        </div>
    )
}


