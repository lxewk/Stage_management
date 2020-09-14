import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import AuthService from '../services/auth.service';



const Navigation = () => {
    const [smBoard, setSmBoard] = useState(false);
    const [deputyBoard, setDeputyBoard] = useState(false);
    const [currentUser, setCurrentUser] = useState('');
          
    const user = AuthService.getCurrentUser(); 
    
    if(user) {
        setCurrentUser(user);
        user.roles.includes("STAGEMANAGER");
        setSmBoard(true);
        user.roles.includes("DEPUTY");
        setDeputyBoard(true);
    }
   

    return(
        <nav>
            <div>
                <ul>
                    <li><Link to="/home">Stage Management</Link></li>
                    <li><Link to={{pathname: "/dashboard", state: { currentUser }}}>Dashboard</Link></li>
                    <li><Link to={{pathname: "/stagemanager", state: { smBoard }}}>SM</Link></li>
                    <li><Link to={{pathname: "/deputy", state: { deputyBoard }}}>DSM</Link></li>
                    <li><Link to="/assistant">ASM</Link></li>
                    <li><Link to="/crew">CREW</Link></li>
                    <li><Link to="/props">PROPS</Link></li>
                    <li><Link to="/creative">CREATIVE</Link></li>
                    <li><Link to="/production">PRODUCTION</Link></li>
                </ul>
            </div>            
        </nav>
    );
}

export default Navigation;