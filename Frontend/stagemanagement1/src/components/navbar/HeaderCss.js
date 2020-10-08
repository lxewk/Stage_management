import styled from 'styled-components'
import { colors } from '../../components/styled/global'
import { Link } from 'react-router-dom'


export const NavMenu = styled.ul`
    display: flex;
    margin-block-start: 0;
    margin-block-end: 0;
    padding-inline-start: 0;
    height: 100%;
    position: absolute;
    right: 20px;
    align-items: center;
    background: pink;
    

    @media screen and (max-width: 960px){
        height: 100%;
        width: 300px;
        position: fixed;
        right: -240px;
        top: 70px;
        background: rgba(73,63,252,1);
        flex-direction: column;
        transition: 300ms ease all;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);

        &:active {
            right: 0; 
        }
    }

    
`;


export const ListItem = styled.li`
    list-style-type: none;
    padding: 10px 20px;
    
    @media screen and (max-width: 759px){
        width: 100%;
        padding-right: 0;
        padding-left: 0;
    }
`;
    


export const NavLinks = styled(Link)`
    color: ${colors.headerLogoWhite};
    text-decoration: none;
    display: flex;
    flex-direction: row-reverse;
    align-items: center;  

    @media screen and (max-width: 759px){
        flex-direction: row-reverse;
        justify-content: space-between;
        margin-right: 20px;
        margin-left: 20px;
    }
`;

export const Icons = styled.i`
    margin-right: 15px;
    font-size: 20px;
`;


export const MenuIcon = styled.figure`
    margin-block-start: 0;
    margin-block-end: 0;
    padding-inline-start: 0;
    padding-inline-end: 0;
    cursor: pointer;

    @media screen and (max-width: 759px){
        position: fixed;
        right: 0;
        top: 20px;
    }

`;

export const Bars = styled.i`
    color: ${colors.white};
`;



