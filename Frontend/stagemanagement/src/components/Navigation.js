import React, { useContext, useEffect, useState } from 'react';
import { Link, Route } from 'react-router-dom';
import { LoginContext } from '../context/LoginProvider';
import styled from 'styled-components';




const Navigation = () => {
    const accessRolePage = useContext(LoginContext);

    return(
        <nav>
            <div>
                <ul>
                    <li><Link to="/home">Stage Management</Link></li>
                    <li><Link to="/dashboard">Dashboard</Link></li>
                    <li><Link to="/stagemanager">SM</Link></li>
                    <li><Link to="/deputy">DSM</Link></li>
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