import styled from 'styled-components';
import { colors } from './global.js';

import  BoysFromJersey  from '../../assets/jersey-boys.svg';
import  img  from '../../assets/jersey-boy-tim.svg';
// import showDetail from '../../pages/Show';





/******  LOGIN/HOME PAGE  ******/
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

  @media screen and (max-width: 700px){
    justify-content: center;
    background-image: none;
  }

`;

export const LoginCard = styled.div`
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  height: 70%;
  width: 45%;

  &:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);

  @media screen and (max-width: 350px){
    width: 100%;
  }

  @media screen and (max-width: 700px){
    width: 80%;
    align-self: center;
  }
  
  }
`;

export const LoginCardContainer = styled.div`
  padding-left: 7%;
  padding-right: 7%;
  height: 100%;
`;

export const LoginCardHead = styled.h1`
  font-size: 2.5rem;
`;

export const LoginFormContainer = styled.form`
  display: flex;
  height: 80%;
  flex-direction: column;
  justify-content: space-around;
  align-self: center;
`;

export const LoginLabel = styled.label`
  display: flex;
  flex-direction: column;
`;

export const LoginInput = styled.input`
  padding-left: 10px;
  padding-right: 1px;
  height: 40px;
  border-radius: 5px;
  border: .5px solid rgb(143, 143, 143);
  font-size: 15px;
`;

export const FormError = styled.span`
  color: ${colors.red};
  text-align: center;
`;
/******  LOGIN/HOME PAGE  ******/


/******  SHOW PAGE  ******/
export const HomeContainer = styled.div`
  margin-top: 150px;
  margin-left: 8%;
  margin-right: 8%;
  .row {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
   

  @media screen and (max-width: 780px){
    justify-content: space-around;
  }

  @media screen and (min-width: 1400px){
    margin: auto;
    width: 1400px;
  }
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

  @media screen and (max-width: 780px){
    width: 45%;
  }

  @media screen and (max-width: 500px){
    width: 90%;
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

// @media screen and (min-width: 1400px){
//   .home {
//     margin: auto;
//     width: 1400px;
//   } */
//   .toggle-button{
//     margin-bottom: 10px;
//   }
// }


/******  SHOW PAGE  ******/

