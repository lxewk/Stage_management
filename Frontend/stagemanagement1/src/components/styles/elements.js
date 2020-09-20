import styled, { css } from 'styled-components';
import { colors } from './global.js';

import  BoysFromJersey  from '../../assets/jersey-boys.svg';
import  img  from '../../assets/jersey-boy-tim.svg';


/******  HEADER  ******/
export const HeaderContainer = styled.nav`
  width: 100%;
  position: fixed;
  z-index: 10;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  background-color: ${colors.headerBlue};
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  height: 70px;
  top: 0;
  padding-right: 20px;
  padding-left: 20px;
`;

export const HeaderLogo = styled.h1`
  color: ${colors.headerLogoWhite};
`;

export const LogoSpan = styled.span`
    vertical-align: sub;
`;

export const LogoItalic = styled.i`
color: ${colors.stage};
`;
/******  HEADER  ******/


/******  LOGIN PAGE  ******/
export const LoginContainer = styled.div`
  display: flex;
  align-items: center;
  background-image: url(${BoysFromJersey});
  height: calc(100vh - 70px);
  background-repeat: no-repeat;
  background-position: right;
  padding-left: 5%;
  padding-right: 5%;
  margin-top: 70px;
`;

export const LoginCard = styled.div`
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  height: 70%;
  width: 45%;

  &:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
  }
`;

export const LoginCardContainer = styled.div`
  padding-left: 7%;
  padding-right: 7%;
  height: 100%;
`;

export const LoginCardContainerHead = styled.h1`
  font-size: 2.5rem;
`;

export const LoginFormContainer = styled.form`
  display: flex;
  height: 80%;
  flex-direction: column;
  justify-content: space-around;
  align-self: center;
`;
/******  LOGIN PAGE  ******/


/******  HOME PAGE  ******/
export const HomeContainer = styled.div`
  margin-top: 100px;
  margin-left: 2%;
  margin-right: 2%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between; 
`;

export const HomeLoader = styled.span`
  align-self: center;
  width: 100%;
  text-align: center;
`;

export const HomeError = styled.span`
  width: 100%;
  align-self: center;
  color: ${colors.headerBlue};
  font-size: 30px;
  font-weight: bold;
  text-align: center;
`;

export const ContainerShowCard = styled.div`
  display: flex;
  align-items: flex-end;
  background-color: ${colors.beam};
  background-image: url(${img});
  height: calc(100vh - 20px); 
  background-repeat: no-repeat;
  background-position: 50% 25%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  height: 400px;
  width: 40%;
  position: relative;
  margin-bottom: 5%;
  padding: 10px;

  &:hover {
    background-color: ${colors.gray};
  }

  &:h2 {
    
  }
`;

export const ShowCardText = styled.h2`
  color: ${colors.red};
  text-align: center;
  font-size: 2rem;
`;

export const ShowCardManaged = styled.span`
  color: ${colors.red};
  text-align: center;
`;


/******  HOME PAGE  ******/

// const Container = styled.div`
//   width: 1280px;
//   min-width: 1280px;
//   margin: 0 auto;
//   .row {
//     width: 100%;
//     display: flex;
//     align-items: center;
//   }
// `