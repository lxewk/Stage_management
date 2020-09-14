import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';



const Navigation = () => {
    return(
        <nav>
            <div>
                <ul>
                    <li><h4>Stage Management</h4></li>
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