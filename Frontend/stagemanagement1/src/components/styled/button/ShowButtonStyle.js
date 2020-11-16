import styled from 'styled-components';
import { colors } from '../global.js';
import { Link } from 'react-router-dom';



export const ShowBtn = styled(Link)`
  box-sizing: border-box;
  color: ${colors.red};
  text-align: right;
  text-decoration: none;
  font-size: 2vw;
  font-weight: bold;
  padding: 35px 35px;
  height: 450px;
  width: 550px;
  cursor: pointer;
  
  

  @media screen and (max-width: 600px){
    background-image: none;
    height: 100px;
    width: auto;
    font-size: 5vw;
    text-align: center;
    padding: 25px 10px 10px 10px;
    margin: 0;
  }

`;
