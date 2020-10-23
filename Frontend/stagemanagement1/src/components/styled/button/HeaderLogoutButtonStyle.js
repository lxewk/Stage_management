import styled, { css } from 'styled-components';
import { colors } from '../global.js';
import { Link } from 'react-router-dom';

export const HeaderBut = styled(Link)`
    
    background-color: transparent;
    border: none;
    align-self: center;
    cursor: pointer;
    font-size: xx-small;
    text-decoration: none;
    color: ${colors.headerLogoWhite};
    margin-left: 15px;

    ${props => props.outline && css`
        outline: none !important;
    `}

    i {
       font-size: 22px;
       font-weight: bolder;
       margin-right: 5px; 
    }

    @media screen and (max-width: 1200px){
        display: flex;
        width: 100%;
        padding-right: 0;
        padding-left: 0;

        i {
            margin-right: 175px;
            margin-left: 13px;
        }
    }
`;