import styled, {css} from 'styled-components';
import { colors } from '../global.js';
import { Link } from 'react-router-dom';



export const ShowBtn = styled(Link)`
  color: ${colors.red};
  text-align: right;
  text-decoration: none;
  font-size: 24px;
  font-family: "Georgia", serif;
  padding: 35px 0px 0px 0px;
  height: 350px;
  width: 400px;
  cursor: pointer;

  @media screen and (max-width: 780px){
    width: 45%;
  }

  @media screen and (max-width: 500px){
    width: 90%;
  }
    

`
