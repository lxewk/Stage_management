import styled from 'styled-components';
import { colors } from '../../components/styled/global'


export const NavMenu = styled.ul`
    display: grid;
    grid-template-columns: repeat(7, auto);
    grid-gap: 15px;
    list-style: none;
    text-align: center;
    width: 60vw;
    justify-content: end;
    margin-right: 1rem;
    background-color: pink;

    @media screen and (max-width: 960px){
        display: flex;
        flex-direction: column;
        width: 100%;
        height: 500px;
        position: absolute;
        top: 51px;
        left: -100%;
        transition: all 0.5s ease;
    }

    &:active {
      @media screen and (max-width: 960px){
        background: #6668f6;
        left: 0;
        transition: all 0.5s ease;
        z-index: 1;
      }  
    }
`;
    
export const MenuIcon = styled.div`
    display: none;

    @media screen and (max-width: 960px){
        display: block;
        position: absolute;
        top: 0;
        right: 0;
        transform: translate(-100%, 60%);
        font-size: 1.8rem;
        cursor: pointer;
    }
`;

export const NavLinks = styled.a`
    color: ${colors.headerLogoWhite};
    text-decoration: none;
    padding: 0.5rem 1 rem;

    &:hover {
        background-color: #6d76f7;
        border-radius: 4px;
        transition: all 0.2s ease-out;
    } 
    
    @media screen and (max-width: 960px){
        text-align: center;
        padding: 2 rem;
        width: 100%;
        display: table;

        &:hover {
            background-color: #7577fa;
            border-radius: 0;
        }
    }
`;

export const Bars = styled.i`
    color: ${colors.white};
`;



