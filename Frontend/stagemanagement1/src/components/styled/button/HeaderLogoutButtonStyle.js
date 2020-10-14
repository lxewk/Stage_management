import styled, { css } from 'styled-components';
import { colors } from '../global.js';
import { Link } from 'react-router-dom';

export const HeaderBut = styled(Link)`
    
    background-color: transparent;
    border: none;
    align-self: center;
    cursor: pointer;
    font-size: 13px;
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

    @media screen and (max-width: 992px){
        width: 100%;
        padding-right: 0;
        padding-left: 0;

        i {
            margin-right: 170px;
            margin-left: 13px;
        }
    }
`;